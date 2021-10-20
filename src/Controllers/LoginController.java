package Controllers;

import DBConn.Cnx;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    private TextField login;
    @FXML
    private PasswordField pswd;
    @FXML
    private Button homeBtn;
    @FXML
    private Button client;
    @FXML
    private Button med;
    @FXML
    private Button agent;
    @FXML
    private Button inf;
    @FXML
    private Button admBtn;
    @FXML
    private Button clientbutton;
    @FXML
    private ImageView logo;
    private Cnx conn;
    private PreparedStatement pst;

    public LoginController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.conn = new Cnx();
    }

    @FXML
    public void loginActionAdm(ActionEvent e) throws IOException {
        String q1 = "SELECT * FROM agent WHERE id=? AND mdp=?";

        try {
            this.pst = this.conn.DBcnx().prepareStatement(q1);
            this.pst.setString(1, this.login.getText());
            this.pst.setString(2, this.pswd.getText());
            ResultSet rs = this.pst.executeQuery();

            int count;
            for(count = 0; rs.next(); ++count) {
            }

            if (count == 1) {
                System.out.println("Connexion agent avec succés");
                Stage logp = new Stage();
                admBtn.getScene().getWindow().hide();
                Parent rootA ;
                rootA = FXMLLoader.load(getClass().getResource("/FXML/IntAgentLocation.fxml"));
                Scene scene = new Scene(rootA);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText((String)null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
        } catch (SQLException var16) {
        } finally {
            try {
                this.conn.DBcnx().close();
            } catch (SQLException var15) {
            }

        }

    }


    @FXML
    public void loginActionClient(ActionEvent e) throws IOException {
        String q1 = "SELECT * FROM tableclients WHERE id_client=? AND mdp=?";

        try {
            this.pst = this.conn.DBcnx().prepareStatement(q1);
            this.pst.setString(1, this.login.getText());
            this.pst.setString(2, this.pswd.getText());
            ResultSet rs = this.pst.executeQuery();

            int count;
            for(count = 0; rs.next(); ++count) {
            }

            if (count == 1) {
                System.out.println("Connexion Client avec succés");
                Stage logp = new Stage();
                clientbutton.getScene().getWindow().hide();
                Parent rootP ;
                rootP = FXMLLoader.load(getClass().getResource("/FXML/IntClient.fxml"));
                Scene scene = new Scene(rootP);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText((String)null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
        } catch (SQLException var16) {
        } finally {
            try {
                this.conn.DBcnx().close();
            } catch (SQLException var15) {
            }
        }
    }
    @FXML
    public void loginAgent(ActionEvent e) throws IOException {
        Stage logp = new Stage();
        agent.getScene().getWindow().hide();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/LoginAgentLocation.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }
    @FXML
    public void loginClient(ActionEvent e) throws IOException {
        Stage logp = new Stage();
        client.getScene().getWindow().hide();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/LoginClient.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
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
