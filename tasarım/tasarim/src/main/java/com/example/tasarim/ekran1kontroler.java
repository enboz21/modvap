package com.example.tasarim;

import hesap.para;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class ekran1kontroler {
    private Path path;
    private boolean pasif = true;
    private double Öz_kaynaklar;
    double hissed;
    double t_tutar;
    double t_maliyet;

    @FXML
    private CheckBox tik;
    @FXML
    private TextField dosya_yolu;
    @FXML
    private Slider hisse;
    @FXML
    private TextField Özkaynaklar;
    @FXML
    private Label hiise_deyeri;

    @FXML
    protected void aktif() {
        if (pasif) {
          pasif=!pasif;
          hisse.setDisable(false);
          hiise_deyeri.setDisable(false);
        } else if (!pasif) {
            pasif=!pasif;
            hisse.setDisable(true);
            hiise_deyeri.setDisable(true);
        }
    }

    @FXML
    protected void setHisse() {
        hiise_deyeri.textProperty().bind((hisse.valueProperty().multiply(1)).asString());
    }

    @FXML
    protected void ana_tıklama() throws FileNotFoundException {
        String Öz=Özkaynaklar.getText();
        boolean sayı_deyil=false;
        for (int i = 0; i < Öz.length(); i++) {
            if (!((Öz.charAt(i)>='0')&&(Öz.charAt(i)<='9'))){
                sayı_deyil=true;
                break;
            }
        }
        if (sayı_deyil){
            Alert al=new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("hata");
            al.setHeaderText("harf");
            al.setContentText("yalnızca sayı girebilirsiniz");
            al.showAndWait();
        }
        else {
            Öz_kaynaklar=Double.valueOf(Öz);
            hissed=100.0;
            if (hisse.isCache()){
                hissed=Double.valueOf(hiise_deyeri.getText());
            }
            File f=new File(String.valueOf(path));
            Scanner k=new Scanner(f);
            boolean c=true;
            while (k.hasNext()){
                if (c){
                    c=false;
                    k.nextLine();
                }
                String[] par=k.nextLine().split(";");
                int a=par.length-1;
                try {
                    t_tutar += Double.valueOf(par[a]);
                }catch (Exception e){
                    String[] b=par[a].split(",");
                    String bb=b[0]+"."+b[1];
                    t_tutar += Double.valueOf(bb);
                }
                try {
                    t_maliyet += Double.valueOf(par[a - 1]);
                }catch (Exception e){
                    String[] b=par[a-1].split(",");
                    String bb=b[0]+"."+b[1];
                    t_maliyet += Double.valueOf(bb);
                }
            }
            para p=new para();

        }


    }

    @FXML
    protected void dosya_seçme() {
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));

        jfc.setFileFilter(new FileNameExtensionFilter("belge", "csv"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showOpenDialog(null);
        path = (Path) jfc.getSelectedFile().toPath();
        dosya_yolu.setText(path.toString());
    }
}