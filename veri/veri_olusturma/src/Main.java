import jdk.dynalink.beans.StaticClass;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Main {
    static class yapı {
        String time;
        double realtimes;
        String isim;
        String tutar;
        String maliyet;
        public yapı(String isim, String time, String tutar,String maliyet, double realtimes) {
            this.time = time;
            this.isim = isim;
            this.tutar = tutar;
            this.maliyet=maliyet;
            this.realtimes = realtimes;
        }
    }
    LocalDate l= LocalDate.of(2009, 3, 1);
    static double vakit = 8.00;
    static Menü m;
    static yapı[] dizi;

    public Main(int kaç) throws Menü.hata {
        vakit = 8.00;
        String dizi1[] = {"mercimek çorbası", "ezogelin çorbası", "yayla çorbası", "bulgur pilavı", "pirinç pilavı", "kuru fasülye", "kavurma", "lahmacun", "adana kebap", "tavuk şiş"};
        double tutar[] = {30, 30.5, 30, 35, 40, 60, 85.35, 15, 54, 85};
        double maliyet[] = {20, 25.5, 15, 30, 35, 45.4, 73, 6, 37, 66,};
        m = new Menü(dizi1.length);

        for (int i = 0; i < dizi1.length; i++) {
            m.ekle(dizi1[i], tutar[i],maliyet[i]);
        }
        System.out.println(System.getProperty("user.home"));
        File f = new File(System.getProperty("user.home") + "/Masaüstü/" + l.plusDays(kaç) + ".csv");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println();
                throw new RuntimeException(e);
            }
        } else {

        }


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("zaman;yemek ismi;maliyet;tutar\n");
            yapı[] a = kütle();
            int i = 0;
            while (a[i].realtimes < 21.30) {
                bw.write(a[i].time + ";" + a[i].isim + ";" +a[i].maliyet+";"+ a[i].tutar + "\n");
                i++;
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("yazma hatası");
            throw new RuntimeException(e);
        }

    }

    public static void zaman() {
        Random r = new Random();
        double a = r.nextDouble(0.00, 0.05);
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

    public static yapı[] kütle() {
        dizi = new yapı[500];
        Random r = new Random();
        for (int i = 0; i < dizi.length; i++) {
            zaman();
            int sil = (int) vakit;
            int say = (int) (vakit * 100);
            int sayp = say - (sil * 100);
            String s = String.valueOf(sil) + ":" + String.valueOf(sayp) + ":00";
            int ren = ağırlık(vakit);
            double b = (m.çekf(ren));
            int sill = (int) b;
            int sayy = (int) (b * 100);
            int saypp = sayy - (sill * 100);
            String ss = String.valueOf(sill) + "," + String.valueOf(saypp);
             b = (m.çekm(ren));
             sill = (int) b;
             sayy = (int) (b * 100);
             saypp = sayy - (sill * 100);
            String sss = String.valueOf(sill) + "," + String.valueOf(saypp);
            dizi[i] = new yapı(m.çeks(ren), s, ss,sss, vakit);
        }
        return dizi;
    }

    static int ağırlık(double vakit) {
        Random r = new Random();
        int ren = 0;
        if (vakit < 12.00) {
            int[] ağır = {0,0,0,1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
            ren = r.nextInt(10);

            ren = ağır[ren];
        } else {
            int[] ağır = {0,1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
            ren = r.nextInt(10);
            ren = ağır[ren];
        }
        return ren;
    }
}
