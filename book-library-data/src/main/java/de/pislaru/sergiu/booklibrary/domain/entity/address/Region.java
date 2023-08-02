package de.pislaru.sergiu.booklibrary.domain.entity.address;

public enum Region {

    BW("Baden-Württemberg"),
    BY("Bayern"),
    BE("Berlin"),
    BB("Brandenburg"),
    HB("Bremen"),
    HH("Hamburg"),
    HE("Hessen"),
    MV("Mecklenburg-Vorpommern"),
    NI("Niedersachsen"),
    NW("Nordrhein-Westfalen"),
    RP("Rheinland-Pfalz"),
    SL("Saarland"),
    SN("Sachsen"),
    ST("Sachsen-Anhalt"),
    SH("Schleswig-Holstein"),
    TH("Thüringen");

    private String name;

    Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
