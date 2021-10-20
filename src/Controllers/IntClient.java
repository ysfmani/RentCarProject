package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class IntClient {
    @FXML
    private Button homeBtn;
    @FXML
    private Button voitures;
    @FXML
    private Button client;
    @FXML
    private Button ass;
    @FXML
    private Button chauf;
    @FXML
    private Button fctrs;
    @FXML
    private Button louer ;

    @FXML
    private void affLouer(ActionEvent e) throws IOException {
        Stage gpat = new Stage();
        louer.getScene().getWindow().hide();
        Parent root1 = FXMLLoader.load(getClass().getResource("/FXML/IntLouer.fxml"));
        Scene scene = new Scene(root1);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    @FXML
    public void homee(ActionEvent e) throws IOException {
        Stage hm = new Stage();
        this.homeBtn.getScene().getWindow().hide();
        Parent root1 = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/Home.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }
}
