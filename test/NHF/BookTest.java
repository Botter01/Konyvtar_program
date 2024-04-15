package NHF;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
    Konyv proba;

    @Before
    public void beallit(){
        proba = new Konyv("Molnár Botond", "Alexandria", "Krimi", "Ifijúsági", "Gyilkosság a Schönherzben", "Kamu szöveg...");
    }
    @Test
    public void setup(){
        Assert.assertEquals("Molnár Botond", proba.getIro());
        Assert.assertEquals("Alexandria", proba.getKiado());
        Assert.assertEquals("Krimi", proba.getMufaj());
        Assert.assertEquals("Ifijúsági", proba.getKategoria());
        Assert.assertEquals("Gyilkosság a Schönherzben", proba.getCim());
        Assert.assertEquals("Kamu szöveg...", proba.getLeiras());
        Assert.assertTrue(!proba.isKolcsonozve_van());
        Assert.assertEquals(0,proba.getId());

    }

    @Test
    public void setters(){
        proba.setIro("proba1");
        proba.setKiado("proba2");
        proba.setMufaj("proba3");
        proba.setKategoria("proba4");
        proba.setCim("proba5");
        proba.setLeiras("proba6");
        Assert.assertEquals("proba1", proba.getIro());
        Assert.assertEquals("proba2", proba.getKiado());
        Assert.assertEquals("proba3", proba.getMufaj());
        Assert.assertEquals("proba4", proba.getKategoria());
        Assert.assertEquals("proba5", proba.getCim());
        Assert.assertEquals("proba6", proba.getLeiras());
    }

}