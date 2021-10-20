package Agence;

/*import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;*/
import DBConn.Cnx;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Agence extends Application {
    @Override
    public void start(Stage primaryStage)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
            Scene scene = new Scene(root,650,400);
            primaryStage.setTitle("AGENCE");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(true);
        } catch (IOException e) { }
    }

    public static void main(String[] args) {
        launch(args);
        /*Cnx cn = new Cnx();
        cn.DBcnx();*/
    }
}





