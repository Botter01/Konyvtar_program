package NHF;

enum Tipus{
    NAPI, HETI, HAVI
}

enum Nyelv{
    ANGOL, NÉMET, MAGYAR, ROMÁN
}

public class Hirlap extends Kolcsonozheto {
    private String szerkeszto;
    private Nyelv nyelve;
    private  Tipus tipus;
    private  int id;

    public Hirlap(String szerkeszto, Nyelv nyelve, Tipus tipus,  String c, String l) {
        super( c, l);
        this.szerkeszto = szerkeszto;
        this.nyelve = nyelve;
        this.tipus = tipus;
        this.id = 2;
    }


    public String getSzerkeszto() {
        return szerkeszto;
    }

    public void setSzerkeszto(String szerkeszto) {
        this.szerkeszto = szerkeszto;
    }

    public Nyelv getNyelve() {
        return nyelve;
    }

    public void setNyelve(Nyelv nyelve) {
        this.nyelve = nyelve;
    }


    public Tipus getTipus() {
        return tipus;
    }

    public void setTipus(Tipus tipus) {
        this.tipus = tipus;
    }
    @Override
    public String toString() {
        return "Hirlap{" +
                "szerkeszto='" + szerkeszto + '\'' +
                ", nyelve='" + nyelve + '\'' +
                ", tipus=" + tipus +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}
