package traductor_con_json.model;

public class Palabras {
    private String es;
    private String en;
    private String fr;

    public Palabras(String es, String en, String fr){
        this.es = es;
        this. en = en;
        this.fr = fr;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    @Override
    public String toString() {
        return "Traduccion{" +
                "ES='" + es + '\'' +
                ", EN='" + en + '\'' +
                ", FR='" + fr + '\'' +
                '}';
    }
}
