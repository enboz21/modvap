package com.example.tasarim;

import hesap.para;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import kotlin.reflect.KParameter;

import java.io.IOException;

public class dy {

    @FXML
    private TextField faliyet_var;

    @FXML
    private TextField net_kar;

    @FXML
    private TextField sermaye;

    @FXML
    private TextField top_kazanç;

    @FXML
    private TextField top_maliyet;

    @FXML
    protected void tak() throws IOException {
        HelloApplication.deyiş("ekran1.fxml");
    }





    @FXML
    void initialize() {
        top_kazanç.setText(String.valueOf(p.getTop_kazanç()));
        top_maliyet.setText(String.valueOf(p.getTop_maliyet()));
        faliyet_var.setText(String.valueOf(p.getFaliyet_verimliliği()));
        net_kar.setText(String.valueOf(p.getNet_kar()));
    }

    para p=ekran1kontroler.n();


}