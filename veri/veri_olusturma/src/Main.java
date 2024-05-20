import jdk.dynalink.beans.StaticClass;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    static class yapı {
        String time;
        LocalDateTime realtimes;
        String isim;
        String tutar;
        String maliyet;

        public yapı(String isim, String time, String tutar, String maliyet, LocalDateTime realtimes) {
            this.time = time;
            this.isim = isim;
            this.tutar = tutar;
            this.maliyet = maliyet;
            this.realtimes = realtimes;
        }
    }

    LocalDate l = LocalDate.of(2009, 3, 1);
    static LocalDateTime vakit = LocalDateTime.of(2009, 03, 1, 10, 00);
    static LocalDateTime kop;
    static Menü m;
    static yapı[] dizi;

    public Main(int kaç) throws Menü.hata {
        kop=vakit;
        kop=kop.plusMonths(1);
        String dizi1[] = {"mercimek çorbası", "ezogelin çorbası", "yayla çorbası", "bulgur pilavı", "pirinç pilavı", "kuru fasülye", "kavurma", "lahmacun", "adana kebap", "tavuk şiş"};
        double tutar[] = {30, 30.5, 30, 35, 40, 60, 85.35, 15, 54, 85};
        double maliyet[] = {20, 25.5, 15, 30, 35, 45.4, 73, 6, 37, 66,};
        m = new Menü(dizi1.length);

        for (int i = 0; i < dizi1.length; i++) {
            m.ekle(dizi1[i], tutar[i], maliyet[i]);
        }
        System.out.println(System.getProperty("user.home"));
        File f = new File(System.getProperty("user.home") + "/Desktop/" + l.plusDays(kaç) + ".csv");
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
            bw.write("tarih;zaman;yemek ismi;maliyet;tutar\n");
            yapı[] a = kütle();
            int i = 0;
            while (a[i].realtimes.getMonthValue()<kop.getMonthValue()) {
                if (a[i].realtimes.getHour() < 21) {
                    bw.write(a[i].realtimes.toLocalDate()+";"+a[i].realtimes.toLocalTime() + ";" + a[i].isim + ";" + a[i].maliyet + ";" + a[i].tutar + "\n");

                }
                i++;
            }
            vakit=kop;
            bw.close();
        } catch (IOException e) {
            System.out.println("yazma hatası");
            throw new RuntimeException(e);
        }

    }

    public static void zaman() {
        Random r = new Random();
        int ren = r.nextInt(15, 35);
        vakit = vakit.plusMinutes(ren);
    }

    public static yapı[] kütle() {
        dizi = new yapı[3000];
        Random r = new Random();
        for (int i = 0; i < dizi.length; i++) {
            zaman();
            String s = vakit.toString();
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
            dizi[i] = new yapı(m.çeks(ren), s, ss, sss, vakit);
        }
        return dizi;
    }

    static int ağırlık(LocalDateTime vakit) {
        Random r = new Random();
        int ren = 0;
        if (vakit.getHour() <= 21) {
            int[] ağır = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
            ren = r.nextInt(ağır.length - 1);

            ren = ağır[ren];
        } else {
            int[] ağır = {0, 1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
            ren = r.nextInt(10);
            ren = ağır[ren];
        }
        return ren;
    }
}
