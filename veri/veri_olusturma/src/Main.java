import jdk.dynalink.beans.StaticClass;

import java.io.*;
import java.util.Random;

public class Main {
    static class yapı{
        String time;
        String isim;
        public yapı(String isim,String time){
            this.time=time;
            this.isim=isim;
        }
    }
    static double vakit = 8.00;
    static Menü m;
    static yapı[] dizi;
    public static void main(String[] args) throws Menü.hata {
        String dizi1[] = {"mercimek çorbası", "ezogelin çorbası", "yayla çorbası","bulgur pilavı", "pirinç pilavı", "kuru fasülye","kavurma","lahmacun","adana kebap", "tavuk şiş", "lahmacun"};
        m = new Menü(dizi1.length);

        for (int i = 0; i < dizi1.length; i++) {
            m.ekle(dizi1[i]);
        }
        System.out.println(System.getProperty("user.home"));
        File f=new File(System.getProperty("user.home")+"/Masaüstü/yeniDosya.csv");
        if (!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println();
                throw new RuntimeException(e);
            }
        }



        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(f));
            bw.write("zaman;");
            bw.write("yemek ismi\n");
            yapı[] a=kütle();
            for (int i = 0; i < a.length; i++) {
                bw.write(a[i].time+";"+a[i].isim+"\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("yazma hatası");
            throw new RuntimeException(e);
        }

    }

    public static void zaman() {
        Random r = new Random();
        double a = r.nextDouble(0.00, 0.10);
        System.out.println(a);
        vakit += a;
        int b = (int) vakit;
        double c = vakit - b;
        c = c * 100;
        if (c >= 60) {
            vakit += 1;
            vakit -= 0.60;
        }
        vakit = vakit * 100;
        int va = (int) vakit;
        vakit = va;
        vakit = vakit / 100;
    }
    public static yapı[] kütle(){
        dizi=new yapı[200];
        Random r=new Random();
        for (int i = 0; i < dizi.length; i++) {
            zaman();
            int sil=(int)vakit;
            int say=(int)(vakit*100);
            int sayp=say-(sil*100);
            String s=String.valueOf(sil)+":"+String.valueOf(sayp);
            dizi[i] =new yapı(m.çek(r.nextInt(m.boyut)),s);
        }
        return dizi;
    }
}
