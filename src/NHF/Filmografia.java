package NHF;

enum Hordozo{
    SSD, HDD, LEMEZ
}

public class Filmografia extends Kolcsonozheto {

    private String rendezo;
    private Hordozo hordozo;
    private  int id;

    public Filmografia(String rendezo, Hordozo hordozo, String c, String l) {
        super( c, l);
        this.rendezo = rendezo;
        this.hordozo = hordozo;
        this.id = 1;
    }

    public String getRendezo() {
        return rendezo;
    }

    public void setRendezo(String rendezo) {
        this.rendezo = rendezo;
    }

    public Hordozo getHordozo() {
        return hordozo;
    }

    public void setHordozo(Hordozo hordozo) {
        this.hordozo = hordozo;
    }



    @Override
    public String toString() {
        return "Filmografia{" +
                ", rendezo='" + rendezo + '\'' +
                ", hordozo='" + hordozo + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}
