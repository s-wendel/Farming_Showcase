package shwendel.farming.crops;

import org.bukkit.Bukkit;

import java.util.List;

public abstract class StagedCrop extends Crop {

    public abstract CropID getID();

    // Make getAllStages() no longer default, so StagedCrop classes
    public abstract List<CropStage> getAllStagesListReference();

    @Override
    public boolean grow(ProfileCropMemory crop) {

        CropStage nextStage = crop.getNextStage();

        boolean canGrow = false;

        if(nextStage != null) {

            canGrow = true;

            crop.getLocation().getBlock().setBlockData(nextStage.getBlockData());

        }

        return canGrow;

    }

    @Override
    public boolean canContinueGrowing() {
        //TODO?
        return true;
    }

    @Override
    public CropStage getBaseStageReference() {
        return getAllStages().getFirst();
    }

}
