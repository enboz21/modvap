public class Menü {
    static class hata extends Exception {
        public hata(String message) {
            super(message);
        }
    }

    class node {
        int num;
        String isim;
        double tutar;
        double maliyet;
        public node(String isim,double tutar,double maliyet) {
            this.isim = isim;
            num = sonayı();
            this.tutar=tutar;
            this.maliyet=maliyet;
        }
    }

    int boyut;
    int num = 1;
    node[] dizi;
    int indis;

    Menü(int boyut) {
        this.boyut = boyut;
        dizi = new node[boyut];
        indis = 0;
    }

    /**
     * otomatik sayı ataması
     *
     * @return
     */
    private int sonayı() {
        num += 1;
        return num - 1;
    }

    /**
     * doluluğu kontrol eder
     * doluysa true döndürür
     *
     * @return
     */
    public boolean dolumu() {
        return indis > boyut;
    }

    /**
     * menüye ekleme işlemi yapar
     *
     * @param isim
     * @throws hata
     */
    public void ekle(String isim,double tutar,double maliyet) throws hata {
        node n = new node(isim,tutar,maliyet);
        if (!dolumu()) {
            dizi[indis] = n;
            indis += 1;
        } else throw new hata("dizi dolu");
    }

    /**
     * verileri gösterir
     */
    public void göster() {
        for (int i = 0; i < indis; i++) {
            System.out.print(dizi[i].num + "  ");
            System.out.println(dizi[i].isim);
        }

    }
    public String çeks(int indis){
        return dizi[indis].isim;
    }
    public double çekf(int indis){
        return dizi[indis].tutar;
    }
    public double çekm(int indis){
        return dizi[indis].maliyet;
    }
}
