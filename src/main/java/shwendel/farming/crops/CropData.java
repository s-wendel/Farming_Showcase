package shwendel.farming.crops;

import java.util.List;

public class CropData {

    private Crop crop;
    private List<CropStage> stages;

    public CropData(Crop crop) {
        this.crop = crop;
        // According to Crop's contract
        this.stages = this.crop.getAllStagesListReference();
    }

    public Crop getCrop() {
        return this.crop;
    }

    public List<CropStage> getAllStages() {
        return this.stages;
    }

}
