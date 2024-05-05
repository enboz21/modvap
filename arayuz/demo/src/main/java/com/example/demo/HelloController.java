package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.io.File;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onHelloButtonClick() {
        JFileChooser jfc = new JFileChooser(".");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showOpenDialog(null);
        File f=jfc.getSelectedFile();
        String s= f.getName();
        welcomeText.setText("seçilen dosya "+s);
    }
}