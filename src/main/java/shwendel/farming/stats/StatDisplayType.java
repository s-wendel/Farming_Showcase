package shwendel.farming.stats;

public enum StatDisplayType {

    // The way stats are shown on an item, e.g. if they enabled EXPLAINED, it would say: "Grants a 10% chance
    // to get a bonus ore drop" while STAT_NAME would show +10 Ore Fortune and EXPLAINED_AND_STAT_NAME would combine
    // both of them into a sentence
    EXPLAINED,
    STAT_NAME,
    EXPLAINED_AND_STAT_NAME,
    // Maybe they can set their own stat names?
    ;

}
