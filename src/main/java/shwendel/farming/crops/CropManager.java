package shwendel.farming.crops;

import shwendel.farming.crops.crops.WheatCrop;

import java.util.HashMap;
import java.util.Map;

public class CropManager {

    private static final Map<CropID, CropData> CROPS = new HashMap<>();

    static {

        CROPS.put(CropID.WHEAT, new CropData(new WheatCrop()));

    }

    public static CropData getCropData(CropID id) {
        return CROPS.getOrDefault(id, null);
    }

    public static Crop getCrop(CropID id) {

        CropData cropData = getCropData(id);

        return cropData == null ? null : cropData.getCrop();
    }

}
