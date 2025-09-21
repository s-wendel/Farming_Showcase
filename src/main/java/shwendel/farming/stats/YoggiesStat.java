package shwendel.farming.stats;

import java.util.Map;

public abstract class YoggiesStat {

    public abstract String getName();

    public abstract YoggiesStatID getID();

    public abstract Map<StatDisplayType, String> getStatDisplayOptions();

    public String getStatDisplay(StatDisplayType type, double value) {
        // Replaces e.g. "+%d Mining Fortune" with value
        return String.format(getStatDisplayOptions().get(type), value);
    }

}