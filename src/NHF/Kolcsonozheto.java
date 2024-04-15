package NHF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public abstract class Kolcsonozheto implements Serializable {
    private String kiadas_datum;
    private boolean kolcsonozve_van;
    private String cim;
    private String leiras;
    private String visszahozatal_datum;


    public Kolcsonozheto( String cim, String leiras) {
        this.kiadas_datum = null;
        this.kolcsonozve_van = false;
        this.cim = cim;
        this.leiras = leiras;
        this.visszahozatal_datum = null;
    }
    public abstract int getId();

    public String getKiadas_datum() {
        return kiadas_datum;
    }

    public boolean isKolcsonozve_van() {
        return kolcsonozve_van;
    }

    public String getCim() {
        return cim;
    }

    public String getLeiras() {
        return leiras;
    }

    public String getVisszahozatal_datum() {
        return visszahozatal_datum;
    }

    public void setKiadas_datum(String kd) {
        this.kiadas_datum = kd;
    }

    public void setKolcsonozve_van(boolean kolcsonozve_van) {
        this.kolcsonozve_van = kolcsonozve_van;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public void setVisszahozatal_datum(String visszahozatal_datum) {
        this.visszahozatal_datum = visszahozatal_datum;
    }

}
