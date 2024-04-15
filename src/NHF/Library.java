package NHF;

import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable{
    ArrayList<Kolcsonozheto> Konyvtar;
    boolean talalat = false;
    boolean sikeres_mentes_betoltes = false;

    public Library(ArrayList<Kolcsonozheto> konyvtar) {
        Konyvtar = konyvtar;
    }


    public void add_B(String k_c, String k_i, String k_m, String k_k, String k_l, String k_ki) {
        Konyv uj = new Konyv(k_i, k_ki, k_m, k_k, k_c, k_l);
        Konyvtar.add(uj);
    }

    public void add_F(String f_c, String f_r, String f_l, Hordozo h) {
        Filmografia uj = new Filmografia(f_r, h, f_c, f_l);
        Konyvtar.add(uj);
    }

    public void add_H(String szerkeszto, Nyelv nyelve, Tipus tipus, String c, String l) {
        Hirlap uj = new Hirlap(szerkeszto, nyelve, tipus, c, l);
        Konyvtar.add(uj);
    }

    public void torles(int ID, String torlendo_cim) {
        switch (ID) {
            case 0:
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 0 && Konyvtar.get(i).getCim().equals(torlendo_cim)) {
                        Konyvtar.remove(i);
                    }
                }
                return;
            case 1:
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 1 && Konyvtar.get(i).getCim().equals(torlendo_cim)) {
                        Konyvtar.remove(i);
                    }
                }
                return;
            case 2:
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 2 && Konyvtar.get(i).getCim().equals(torlendo_cim)) {
                        Konyvtar.remove(i);
                    }
                }
                return;
            default:
                break;
        }

    }

    public void kereses(int ID, String keresendo_cim) {

        switch (ID) {
            case 0:
                ArrayList<Konyv> kell_k = new ArrayList<>();
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 0 && Konyvtar.get(i).getCim().contains(keresendo_cim)) {
                        kell_k.add((Konyv) Konyvtar.get(i));
                        talalat = true;
                    }
                }

                KonyvFrame kf = new KonyvFrame(kell_k);
                kf.setVisible(true);
                break;

            case 1:
                ArrayList<Filmografia> kell_f = new ArrayList<>();
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 1 && Konyvtar.get(i).getCim().contains(keresendo_cim)) {
                        kell_f.add((Filmografia) Konyvtar.get(i));
                        talalat = true;
                    }
                }
                FilmFrame ff = new FilmFrame(kell_f);
                ff.setVisible(true);
                break;

            case 2:
                ArrayList<Hirlap> kell_h = new ArrayList<>();
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 2 && Konyvtar.get(i).getCim().contains(keresendo_cim)) {
                        kell_h.add((Hirlap) Konyvtar.get(i));
                        talalat = true;
                    }
                }
                HirlapFrame hf = new HirlapFrame(kell_h);
                hf.setVisible(true);
                break;

            default:
                break;

        }

    }

    public void kilistazas(int ID) {
        switch (ID) {
            case 0:
                ArrayList<Konyv> kell_k = new ArrayList<>();
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 0) {
                        kell_k.add((Konyv) Konyvtar.get(i));
                        talalat = true;
                    }
                }

                KonyvFrame kf = new KonyvFrame(kell_k);
                kf.setVisible(true);
                break;

            case 1:
                ArrayList<Filmografia> kell_f = new ArrayList<>();
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 1) {
                        kell_f.add((Filmografia) Konyvtar.get(i));
                        talalat = true;
                    }
                }
                FilmFrame ff = new FilmFrame(kell_f);
                ff.setVisible(true);
                break;

            case 2:
                ArrayList<Hirlap> kell_h = new ArrayList<>();
                for (int i = 0; i < Konyvtar.size(); i++) {
                    if (Konyvtar.get(i).getId() == 2) {
                        kell_h.add((Hirlap) Konyvtar.get(i));
                        talalat = true;
                    }
                }
                HirlapFrame hf = new HirlapFrame(kell_h);
                hf.setVisible(true);
                break;

            default:
                break;

        }

    }

    public void save(String hely_m) throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(hely_m + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(Konyvtar);
            out.close();
            sikeres_mentes_betoltes = true;
        } catch (IOException e) {
            System.out.println("Hiba a fáljbaírásnál.");
        }
    }

    public void load(File fájl) throws IOException{

            try {
                FileInputStream f = new FileInputStream(fájl);
                ObjectInputStream in = new ObjectInputStream(f);
                ArrayList<Kolcsonozheto> loaded = (ArrayList<Kolcsonozheto>)in.readObject();
                Konyvtar=loaded;
                in.close();
                sikeres_mentes_betoltes = true;
            }catch(Exception e)
            {
                System.out.println("Hiba a beolvasásnál.");
            }

    }

    public boolean ures_e(){
        return  Konyvtar.isEmpty();
    }
    public boolean getTalalat(){
        return talalat;
    }

    public boolean isSikeres_mentes_betoltes() {
        return sikeres_mentes_betoltes;
    }
}
