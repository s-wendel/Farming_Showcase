package shwendel.farming.crops;

import java.util.ArrayList;
import java.util.List;

/**
 * I want child classes that extend this' methods to be blueprints to creating a crop. The point
 * of getBaseStageProtected() and getAllStagesProtected() are to create a new reference of a CropStage / List of CropStage
 * one time, and then store that inside of CropManager, so we only have one consistent reference of it - there might be a better way
 * to do this but this is all I thought of after pondering for a medium length amount of time.
 *
 * I don't want each class to need static variables of CropStages / List of CropStages or any other variables I need that
 * are objects and inherently have a reference, I want them to be simple to create. The only sacrifice I see here is negligible amounts
 * of memory at server start up as well as code complexity.
 *
 * The idea is sound (I think) but the execution might be gross
 */
public abstract class Crop {

    public abstract CropID getID();

    /**
     * Returns the first stage of the crop's reference that will be stored in CropManager, read the class contract for more information =)
     * @return the first stage of the crop's reference that will be stored in CropManager, read the class contract for more information =)
     */
    protected abstract CropStage getBaseStageReference();

    /**
     * Returns if the crop can keep growing beyond where it's at now
     * @return if the crop can keep growing beyond where it's at now
     */
    public abstract boolean canContinueGrowing();

    /**
     * Ran when the crop is supposed to grow, e.g. the next stage or Bamboo growing one block in height
     * @param crop The crop being grown
     * @return Whether or not the crop was able to grow (The only way it can't grow is if it's at its maximum growth stage whether
     * that be its final CropStage
     */
    public abstract boolean grow(ProfileCropMemory crop);

    /**
     * Returns every stage a crop can go through, where the 0th index is the first stage
     * @return Every stage a crop can go through, where the 0th index is the first stage
     */
    protected List<CropStage> getAllStagesListReference() {

        List<CropStage> allStages = new ArrayList<>();

        allStages.add(getBaseStage());

        return allStages;
    }

    /**
     * Returns the base (first) stage of a Crop, the reference to a list of all CropStage's (even if the crop only supports one stage)
     * in a Crop are stored for each Crop, so the reference of the returned CropStage will always be the same
     * on every call of getBaseStage()
     * @return The base (first) stage of a Crop, the reference to a list of all CropStage's (even if the crop only supports one stage)
     * in a Crop are stored for each Crop, so the reference of the returned CropStage will always be the same
     * on every call of getBaseStage()
     */
    public final CropStage getBaseStage() {
        return CropManager.getCropData(getID()).getAllStages().getFirst();
    }

    /**
     * Returns every stage a Crop has, the reference to a list of all CropStage's in a Crop are stored for each Crop, so the reference
     * of the returned List of CropStages will always be the same on every call of getAllStages()
     * @return Every stage a Crop has, the reference to a list of all CropStage's in a Crop are stored for each Crop, so the reference
     * of the returned List of CropStages will always be the same on every call of getAllStages()
     */
    public final List<CropStage> getAllStages() {
        return CropManager.getCropData(getID()).getAllStages();
    }

    /**
     * Returns the total amount of ticks needed to go through all stages of a crop
     * e.g. Bamboo's only grows vertically, if Bamboo takes 2 seconds to go through that, the total
     * amount of ticks is 2 seconds. Another example; wheat grows in stages, if each stage takes 2 seconds, and Wheat has 8 stages - the
     * total amount of ticks is 16 seconds
     * @return The total amount of ticks needed to go through all stages of a crop
     */
    public int getTotalGrowthTimeInTicks() {

        int totalGrowthTimeInTicks = 0;

        for(CropStage stage : getAllStages()) {

            totalGrowthTimeInTicks += stage.getTicksToGrow();

        }

        return totalGrowthTimeInTicks;
    }

}
