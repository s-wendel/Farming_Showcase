package shwendel.farming.placeables;

import shwendel.farming.item.YoggiesItem;

public interface Placeable {

    // TODO: Incorporate custom block system better
    PlaceableID getID();

    String getName();

    YoggiesItem getItemUsedToPlace();

    void place();

}