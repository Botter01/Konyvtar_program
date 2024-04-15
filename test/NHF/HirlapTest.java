package NHF;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HirlapTest {
    Hirlap proba;

    @Before
    public void beallit(){
        proba = new Hirlap("Molnár Botond", Nyelv.ANGOL, Tipus.HAVI, "IT", "Kamu szöveg...");
    }

    @Test
    public void setup() {
        Assert.assertEquals("Molnár Botond", proba.getSzerkeszto());
        Assert.assertEquals(Nyelv.ANGOL, proba.getNyelve());
        Assert.assertEquals(Tipus.HAVI, proba.getTipus());
        Assert.assertEquals("IT", proba.getCim());
        Assert.assertEquals("Kamu szöveg...", proba.getLeiras());
        Assert.assertTrue(!proba.isKolcsonozve_van());
        Assert.assertEquals(2,proba.getId());
    }

    @Test
    public void setters(){
        proba.setSzerkeszto("proba1");
        proba.setNyelve(Nyelv.NÉMET);
        proba.setTipus(Tipus.HETI);
        proba.setCim("proba5");
        proba.setLeiras("proba6");
        Assert.assertEquals("proba1", proba.getSzerkeszto());
        Assert.assertEquals(Nyelv.NÉMET, proba.getNyelve());
        Assert.assertEquals(Tipus.HETI, proba.getTipus());
        Assert.assertEquals("proba5", proba.getCim());
        Assert.assertEquals("proba6", proba.getLeiras());
    }
}