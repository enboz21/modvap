package hesap;
public class Main {
    public static void main(String[] args) {
        double top_kazanç=170.53;
        double top_maliyet=84.10;
        double faliyet_giderleri=15;
        double öz_kaynaklar=20;
        para p=new para(top_kazanç,top_maliyet,faliyet_giderleri,öz_kaynaklar);
        System.out.println(p.getVerimlilik());
        System.out.println(p.getFaliyet_verimliliği());
    }
}