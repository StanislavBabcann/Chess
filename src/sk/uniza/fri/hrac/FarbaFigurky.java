package sk.uniza.fri.hrac;

public enum FarbaFigurky {
    BIELA("biela"),
    CIERNA("cierna");

    private final String reprezentacia;

    FarbaFigurky (String paReprezentacia) {
        this.reprezentacia = paReprezentacia;
    }

    public String getReprezentacia() {
        return this.reprezentacia;
    }

}
