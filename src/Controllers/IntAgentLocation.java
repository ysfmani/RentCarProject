package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IntAgentLocation {
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
    private Button loue ;

    @FXML
    private void affTabVoitures(ActionEvent e) throws IOException {
        Stage gpat = new Stage();
        voitures.getScene().getWindow().hide();
        Parent root1 = FXMLLoader.load(getClass().getResource("/FXML/GererVoitures.fxml"));
        Scene scene = new Scene(root1);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }

    @FXML
    private void affTabClient(ActionEvent e) throws IOException {
        Stage gmed = new Stage();
        client.getScene().getWindow().hide();
        Parent root2 = FXMLLoader.load(getClass().getResource("/FXML/GererClient.fxml"));
        Scene scene = new Scene(root2);
        gmed.setScene(scene);
        gmed.show();
        gmed.setResizable(false);
    }
    @FXML
    private void affTabChauffeur(ActionEvent e) throws IOException {
        Stage gmed = new Stage();
        chauf.getScene().getWindow().hide();
        Parent root2 = FXMLLoader.load(getClass().getResource("/FXML/GererChauffeur.fxml"));
        Scene scene = new Scene(root2);
        gmed.setScene(scene);
        gmed.show();
        gmed.setResizable(false);
    }
    @FXML
    private void affTabAssurance(ActionEvent e) throws IOException {
        Stage gmed = new Stage();
        ass.getScene().getWindow().hide();
        Parent root2 = FXMLLoader.load(getClass().getResource("/FXML/GererAssurance.fxml"));
        Scene scene = new Scene(root2);
        gmed.setScene(scene);
        gmed.show();
        gmed.setResizable(false);
    }
    @FXML
    private void affTablouer(ActionEvent e) throws IOException {
        Stage gmed = new Stage();
        loue.getScene().getWindow().hide();
        Parent root2 = FXMLLoader.load(getClass().getResource("/FXML/IntLouer.fxml"));
        Scene scene = new Scene(root2);
        gmed.setScene(scene);
        gmed.show();
        gmed.setResizable(false);
    }


    /*
    @FXML
    private void affTabFact(ActionEvent e) throws IOException {
        Stage gpat = new Stage();
        this.fctrs.getScene().getWindow().hide();
        Parent root6 = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/GererFact.fxml"));
        Scene scene = new Scene(root6);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    */

    @FXML
    public void homee(ActionEvent e) throws IOException {
        Stage hm = new Stage();
        homeBtn.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(this.getClass().getResource("/FXML/Home.fxml"));
        Scene scene = new Scene(root);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }
}
