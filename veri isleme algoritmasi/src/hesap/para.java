package hesap;

public class para {
    private double top_kazanç;
    private double top_maliyet;
    private double faliyet_giderleri;
    private double öz_kaynaklar;
    private double net_kar;
    private double verimlilik;
    private double faliyet_verimliliği;

    public para(double top_kazanç, double top_maliyet, double faliyet_giderleri, double öz_kaynaklar) {
        this.top_kazanç = top_kazanç;
        this.top_maliyet = top_maliyet;
        this.faliyet_giderleri = faliyet_giderleri;
        this.öz_kaynaklar = öz_kaynaklar;
        net_kar=top_kazanç-(top_maliyet+faliyet_giderleri);
        verimlilik=net_kar/öz_kaynaklar;
        faliyet_verimliliği=net_kar/faliyet_giderleri;
    }

    public double getFaliyet_verimliliği() {
        return faliyet_verimliliği;
    }

    public double getTop_kazanç() {
        return top_kazanç;
    }

    public double getTop_maliyet() {
        return top_maliyet;
    }

    public double getFaliyet_giderleri() {
        return faliyet_giderleri;
    }

    public double getÖz_kaynaklar() {
        return öz_kaynaklar;
    }

    public double getNet_kar() {
        return net_kar;
    }

    public double getVerimlilik() {
        return verimlilik;
    }
}
