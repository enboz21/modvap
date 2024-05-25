package com.example.tasarim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    static FXMLLoader fxmlLoader;
    static Scene scene;
    static Stage stagee;
    public static void deyiş(String ekran) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(ekran));
        scene = new Scene(fxmlLoader.load());
        stagee=stagee;
        stagee.setScene(scene);

        stagee.setResizable(false);
        stagee.show();
    }
    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(a));
        scene = new Scene(fxmlLoader.load());
        stagee=stage;
        stage.setScene(scene);

        stage.setResizable(false);
        stage.show();
    }
    static String a;
    public static void main(String[] args) {
        a="ekran1.fxml";
        launch();
    }
}

/*
private void deyişim( String ekran, boolean a) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource(ekran));
        Stage st=(Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene sc=new Scene(root);
        st.setScene(sc);
        st.setResizable(a);
        st.show();
    }
 */