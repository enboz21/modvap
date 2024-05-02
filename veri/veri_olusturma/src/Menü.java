public class Menü {
    static class hata extends Exception {
        public hata(String message) {
            super(message);
        }
    }

    class node {
        int num;
        String isim;

        public node(String isim) {
            this.isim = isim;
            num = sonayı();
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
    public void ekle(String isim) throws hata {
        node n = new node(isim);
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
    public String çek(int indis){
        return dizi[indis].isim;
    }
}
