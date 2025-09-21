package shwendel.farming.crops;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import shwendel.farming.Farming;
import shwendel.farming.util.TimeUtil;

import java.util.Iterator;

public class ProfileCropMemory {

    private Crop crop;
    private Location location;
    // The current milliseconds of when this crop was planted
    private long currentMillisWhenCropWasPlanted;
    // The task ID for the runnable being scheduled,
    // e.g. the task ID of Wheat growing to its second stage in 30 ticks or
    // the task ID of Bamboo growing 1 block in height in 45 ticks
    private int cropGrowthScheduledTaskID;

    public ProfileCropMemory(Crop crop, Location location, long currentMillisWhenCropWasPlanted) {
        this.crop = crop;
        this.location = location;
        this.currentMillisWhenCropWasPlanted = currentMillisWhenCropWasPlanted;
    }

    public Crop getCrop() {
        return this.crop;
    }

    public Location getLocation() {
        return this.location;
    }

    public long getCurrentMillisWhenCropWasPlanted() {
        return this.currentMillisWhenCropWasPlanted;
    }

    public CropStage getCurrentStage() {

        CropStage currentStage = this.crop.getBaseStage();

        long growthTimeInTicks = TimeUtil.millisToTicks(System.currentTimeMillis() - this.currentMillisWhenCropWasPlanted);

        if(this.crop.getAllStages().size() > 1) {

            Iterator<CropStage> cropStageIterator = this.crop.getAllStages().iterator();

            // cropStageIterator.next() will make the loop start from the second stage
            int totalTicks = cropStageIterator.next().getTicksToGrow();

            while(growthTimeInTicks > totalTicks && cropStageIterator.hasNext()) {

                CropStage iteratorStage = cropStageIterator.next();

                totalTicks += iteratorStage.getTicksToGrow();

                // 47 needs 20 / 40
                currentStage = iteratorStage;

            }

        }

        return currentStage;
    }

    /**
     * Returns the total amount of ticks from every stage the crop has gone through at one point excluding its current stage
     * (All of the stages the crop has gone past)
     * @return
     */
    public int getAllGrownStagesTotalTicks() {

        Iterator<CropStage> cropStageIterator = this.crop.getAllStages().iterator();;

        int totalTicks = 0;

        boolean foundCurrentStage = false;

        while(!foundCurrentStage && cropStageIterator.hasNext()) {

            CropStage stage = cropStageIterator.next();

            if(stage == getCurrentStage()) {

                foundCurrentStage = true;

            } else {

                totalTicks += stage.getTicksToGrow();

            }

        }

        return totalTicks;
    }

    /**
     * Returns the next stage, null if there isn't a next stage
     * @return The next stage, null if there isn't a next stage
     */
    public CropStage getNextStage() {

        CropStage currentStage = getCurrentStage();
        CropStage nextStage = null;

        Iterator<CropStage> cropStageIterator = this.crop.getAllStages().iterator();

        while(nextStage == null && cropStageIterator.hasNext()) {

            CropStage stage = cropStageIterator.next();

            if(stage.equals(currentStage) && cropStageIterator.hasNext()) {

                nextStage = cropStageIterator.next();

            }

        }

        return nextStage;
    }

    /**
     * Starts the growth process of this crop
     * @return whether or not the task was successful, will only return false if there's no next stage to grow to
     */
    public void startCropGrowthScheduledTask() {

        CropStage nextStage = getNextStage();

        if(nextStage != null) {

            ProfileCropMemory cropMemory = this;

            int nextStageTicksToGrow = nextStage.getTicksToGrow();

            long timeUntilGrowthInTicks = nextStageTicksToGrow - (TimeUtil.millisToTicks(System.currentTimeMillis() - this.currentMillisWhenCropWasPlanted) - getAllGrownStagesTotalTicks());

            Bukkit.broadcastMessage("Time until growth : " + timeUntilGrowthInTicks);

            if(timeUntilGrowthInTicks == 0) {

                boolean canGrow = crop.grow(cropMemory);

                this.cropGrowthScheduledTaskID = new BukkitRunnable() {

                    @Override
                    public void run() {

                        if(canGrow) {

                            startCropGrowthScheduledTask();

                        }

                    }

                }.runTaskLater(Farming.getInstance(), nextStageTicksToGrow).getTaskId();

            } else {

                this.cropGrowthScheduledTaskID = new BukkitRunnable() {

                    @Override
                    public void run() {

                        boolean canGrow = crop.grow(cropMemory);

                        if(canGrow) {

                            startCropGrowthScheduledTask();

                        }

                    }

                }.runTaskLater(Farming.getInstance(), timeUntilGrowthInTicks).getTaskId();

            }

        }

    }

}
