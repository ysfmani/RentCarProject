package Controllers;
import DBConn.Cnx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import models.ModelAssurance;
import models.ModelAssurance;
import DBConn.Cnx;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListerAssurance implements Initializable {
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    @FXML
    private ImageView homeImg;
    @FXML
    private Cnx conn;

        @FXML
        private TextField NomAssurance;

        @FXML
        private TextField id_assurance;

        @FXML
        private TextField DateD;

        @FXML
        private ComboBox<ModelAssurance> Type;

        @FXML
        private Button ajouter;

        @FXML
        private Button supprimer;

        @FXML
        private TextField DateF;

        @FXML
        private TableView<ModelAssurance> tableassurance;

        @FXML
        private TableColumn<ModelAssurance, Integer> col_id;

        @FXML
        private TableColumn<ModelAssurance, String> col_nom;

        @FXML
        private TableColumn<ModelAssurance, String> col_type;

        @FXML
        private TableColumn<ModelAssurance, String> col_DateD;

        @FXML
        private TableColumn<ModelAssurance, String> col_DateF;
        ObservableList<ModelAssurance> oblistassurance = FXCollections.observableArrayList();
       public void initialize(URL location, ResourceBundle resources) {
        try {
            this.conn = new Cnx();
            ResultSet rs = this.conn.DBcnx().createStatement().executeQuery(
                    "SELECT `id_assurance`, `NomAssurance`, `Type`, `DateD`, `DateF` FROM `tableassurance`");

            while(rs.next()) {
                oblistassurance.add(new ModelAssurance(rs.getInt("id_assurance"),
                        rs.getString("NomAssurance"),
                        rs.getString("Type"),
                        rs.getString("DateD"),
                        rs.getString("DateF") ));
            }
        } catch (SQLException var4) {
            Logger.getLogger(ListerAssurance.class.getName()).log(Level.SEVERE, (String)null, var4);
        }
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("NomAssurance"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        col_DateD.setCellValueFactory(new PropertyValueFactory<>("DateD"));
        col_DateF.setCellValueFactory(new PropertyValueFactory<>("DateF"));
        tableassurance.setItems(oblistassurance);
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

    @FXML
    private void ajouterAssurance(ActionEvent event) {
        String requete ="INSERT INTO tableassurance (id_assurance  , NomAssurance , Type , DateD , DateF) VALUES ('"
                + this.id_assurance.getText() + "','"
                + this.NomAssurance.getText() + "','" 
                + this.Type.getSelectionModel().getSelectedItem() + "','"
                + this.DateD.getText() + "','"
                + this.DateF.getText()+  "');";
        System.out.println(Type.getItems());
        try {
            PreparedStatement pst = conn.DBcnx().prepareStatement(requete);
            pst.executeUpdate(requete);
            System.out.println("Assurance ajouté avec succés !");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(" M&M Location");
            alert.setContentText("Assurance ajouté avec succés !");
            alert.showAndWait();
        } catch (SQLException var5) {
            System.out.println("ERREUR !");
        }
        tableassurance.getItems().clear();
        try {
            conn = new Cnx();
            ResultSet rs = this.conn.DBcnx().createStatement().executeQuery
                    ("SELECT `id_assurance`, `NomAssurance`, `Type`, `DateD`, `DateF` FROM `tableassurance`");
            while(rs.next()) {
                oblistassurance.add(new ModelAssurance(rs.getInt("id_assurance"),
                        rs.getString("NomAssurance"),
                        rs.getString("Type"),
                        rs.getString("DateD"),
                        rs.getString("DateF")

                ));
            }
        } catch (SQLException var6) {
            Logger.getLogger(ListerAssurance.class.getName()).log(Level.SEVERE, (String)null, var6);
            System.out.println("erreur");
        }
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_assurance"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("NomAssurance"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        col_DateD.setCellValueFactory(new PropertyValueFactory<>("DateD"));
        col_DateF.setCellValueFactory(new PropertyValueFactory<>("DateF"));
        this.tableassurance.setItems(this.oblistassurance);
    }
    @FXML
    private void suprassurance(ActionEvent event) {
        int x = tableassurance.getSelectionModel().getSelectedItem().getId_assurance();
        tableassurance.getItems().removeAll(tableassurance.getSelectionModel().getSelectedItem());
        String requete3 = "DELETE FROM tableassurance WHERE id_assurance =?";
        try {
            PreparedStatement pst = conn.DBcnx().prepareStatement(requete3);
            pst.setInt(1, x);
            pst.executeUpdate();
            System.out.println("Assurance supprimé");
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
        }
    }
    @FXML
    private void interAdm(ActionEvent e) throws IOException {
        Stage gpat = new Stage();
        this.ret.getScene().getWindow().hide();
        Parent root2 = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/IntAgentLocation.fxml"));
        Scene scene = new Scene(root2);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }

}



