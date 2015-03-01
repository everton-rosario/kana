package br.com.kana.model;

/**
 * Created by everton on 01/03/15.
 */
public class KanaSymbol {
    private String katakana;
    private String romaji;

    public String getKatakana() {
        return katakana;
    }

    public void setKatakana(String katakana) {
        this.katakana = katakana;
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KanaSymbol)) return false;

        KanaSymbol that = (KanaSymbol) o;

        if (katakana != null ? !katakana.equals(that.katakana) : that.katakana != null)
            return false;
        if (romaji != null ? !romaji.equals(that.romaji) : that.romaji != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = katakana != null ? katakana.hashCode() : 0;
        result = 31 * result + (romaji != null ? romaji.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KanaSymbol{");
        sb.append("katakana='").append(katakana).append('\'');
        sb.append(", romaji='").append(romaji).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
