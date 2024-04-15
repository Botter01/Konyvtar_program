package NHF;

public class Konyv extends Kolcsonozheto {

    private  String iro;
    private  String kiado;
    private  String mufaj;
    private  String kategoria;
    private  int id;




    public Konyv(String a, String p, String g, String b, String c, String l){
        super(c, l);
        this.iro = a;
        this.kiado = p;
        this.mufaj = g;
        this.kategoria = b;
        this.id = 0;
    }

    public String getIro() {
        return iro;
    }

    public String getMufaj() {
        return mufaj;
    }

    public String getKiado() {
        return kiado;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setIro(String iro) {
        this.iro = iro;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public void setMufaj(String mufaj) {
        this.mufaj = mufaj;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }


    @Override
    public String toString() {
        return "Book{" +
                "iro='" + iro + '\'' +
                ", kiado='" + kiado + '\'' +
                ", mufaj='" + mufaj + '\'' +
                ", kategoria=" + kategoria +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}
