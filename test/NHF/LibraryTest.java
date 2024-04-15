package NHF;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {
    Library konyvtar;
    @Before
    public void setUp() throws Exception {
        konyvtar = new Library(new ArrayList<>());
    }

    @Test
    public void add_delete_f(){
        konyvtar.add_F("Szerelem","Molnár Botond" , "Kamu szöveg...",Hordozo.SSD);
        Assert.assertFalse(konyvtar.ures_e());

        konyvtar.torles(1,"Szerelem");
        Assert.assertTrue(konyvtar.ures_e());
    }

    @Test
    public void add_delete_b(){
        konyvtar.add_B("Menekvés a BME elől","Molnár Botond" , "Thriller", "Ifijúsági","Jó ez az egyetem...", "Globe");
        Assert.assertFalse(konyvtar.ures_e());

        konyvtar.torles(0,"Menekvés a BME elől");
        Assert.assertTrue(konyvtar.ures_e());
    }

    @Test
    public void add_delete_h(){
        konyvtar.add_H("Molnár Botond" , Nyelv.MAGYAR,Tipus.NAPI, "Mérnökök", "Jó annak lenni");
        Assert.assertFalse(konyvtar.ures_e());

        konyvtar.torles(2,"Mérnökök");
        Assert.assertTrue(konyvtar.ures_e());
    }

    @Test
    public void keres(){
        konyvtar.add_H("Molnár Botond" , Nyelv.MAGYAR,Tipus.NAPI, "Mérnökök", "Jó annak lenni");
        konyvtar.kereses(2, "Mérnökök");
        Assert.assertTrue(konyvtar.getTalalat());
    }

    @Test
    public void kilist(){
        konyvtar.add_H("Molnár Botond" , Nyelv.MAGYAR,Tipus.NAPI, "Mérnökök", "Jó annak lenni");
        konyvtar.kilistazas(2);
        Assert.assertTrue(konyvtar.getTalalat());
    }

    @Test
    public void save() throws IOException {
        konyvtar.save("hello");
        Assert.assertTrue(konyvtar.isSikeres_mentes_betoltes());
    }
    
}