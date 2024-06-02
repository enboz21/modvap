package hesap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hesap.para;

public class paraTest {

    @Test
    public void testHesaplamalar() {
        double topKazanc = 1000.0;
        double topMaliyet = 500.0;
        double faaliyetGiderleri = 200.0;
        double ozKaynaklar = 300.0;

        para p = new para(topKazanc, topMaliyet, faaliyetGiderleri, ozKaynaklar);

        assertEquals(p.getTop_kazanç(), topKazanc, 0.001);
        assertEquals(p.getTop_maliyet(), topMaliyet, 0.001);
        assertEquals(p.getFaliyet_giderleri(), faaliyetGiderleri, 0.001);
        assertEquals(p.getÖz_kaynaklar(), ozKaynaklar, 0.001);

        double beklenenNetKar = topKazanc - (topMaliyet + faaliyetGiderleri);
        assertEquals(p.getNet_kar(), beklenenNetKar, 0.001);

        double beklenenVerimlilik = p.getNet_kar() / p.getÖz_kaynaklar();
        assertEquals(p.getVerimlilik(), beklenenVerimlilik, 0.001);

        double beklenenFaaliyetVerimliligi = p.getNet_kar() / p.getFaliyet_giderleri();
        assertEquals(p.getFaliyet_verimliliği(), beklenenFaaliyetVerimliligi, 0.001);
    }
}