package NHF;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilmografiaTest {
    Filmografia proba;
    @Before
    public void beallit(){
        proba = new Filmografia("Molnár Botond", Hordozo.SSD, "Szerelem", "Kamu szöveg...");
    }

    @Test
    public void setup() {
        Assert.assertEquals("Molnár Botond", proba.getRendezo());
        Assert.assertEquals(Hordozo.SSD, proba.getHordozo());
        Assert.assertEquals("Szerelem", proba.getCim());
        Assert.assertEquals("Kamu szöveg...", proba.getLeiras());
        Assert.assertTrue(!proba.isKolcsonozve_van());
        Assert.assertEquals(1,proba.getId());
    }

    @Test
    public void setters(){
        proba.setRendezo("proba1");
        proba.setHordozo(Hordozo.HDD);
        proba.setCim("proba5");
        proba.setLeiras("proba6");
        Assert.assertEquals("proba1", proba.getRendezo());
        Assert.assertEquals(Hordozo.HDD, proba.getHordozo());
        Assert.assertEquals("proba5", proba.getCim());
        Assert.assertEquals("proba6", proba.getLeiras());
    }
}