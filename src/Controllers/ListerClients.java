package Controllers;
import DBConn.Cnx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import models.ModelTableClient;
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
import models.ModelTableVoitures;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ListerClients implements Initializable {
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    @FXML
    private ImageView homeImg;
    @FXML
    private Cnx conn;
    @FXML
    private TextField tel;
    @FXML
    private TextField adresse;
    @FXML
    private TextField mdp;
    @FXML
    private TextField DateNaissance;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField etatCiv;
    @FXML
    private TextField id_client;
    @FXML
    private TextField cin ;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<ModelTableClient> tableclients;
    @FXML
    private TableColumn<ModelTableClient, Integer> col_id;
    @FXML
    private TableColumn<ModelTableClient, String> col_nom;
    @FXML
    private TableColumn<ModelTableClient, String> col_prenom;
    @FXML
    private TableColumn<ModelTableClient, String> col_age;
    @FXML
    private TableColumn<ModelTableClient, Integer> col_tel;
    @FXML
    private TableColumn<ModelTableClient, String> col_adr;
    @FXML
    private TableColumn<ModelTableClient, String> col_etat;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TableColumn<ModelTableClient, String> col_cin ;
    ObservableList<ModelTableClient> oblistClients = FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.conn = new Cnx();
            ResultSet rs = this.conn.DBcnx().createStatement().executeQuery("SELECT `id_client`, `prenom`, `nom`, `adresse`, `etatCiv`, `cin`, `DateNaissance`, `mdp`, `tel` FROM `tableclients`");

            while(rs.next()) {
                oblistClients.add(new ModelTableClient(rs.getInt("id_client"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("tel"),
                        rs.getString("adresse"),
                        rs.getString("etatCiv"),
                        rs.getString("DateNaissance"),
                        rs.getString("mdp"),
                        rs.getString("cin")
                        ));
            }
        } catch (SQLException var4) {
            Logger.getLogger(ListerClients.class.getName()).log(Level.SEVERE, (String)null, var4);
        }
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        col_adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etatCiv"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("DateNaissance"));
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        tableclients.setItems(oblistClients);
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
    private void ajouterClient(ActionEvent event) {
        String requete = "INSERT INTO tableclients (id_client, nom, prenom, DateNaissance, tel, adresse, mdp , cin , etatCiv) VALUES ('"
                + this.id_client.getText() + "','"
                + this.nom.getText() + "','"
                + this.prenom.getText() + "','"
                + this.DateNaissance.getText() + "','"
                + this.tel.getText() + "','"
                + this.adresse.getText() + "', '" + this.mdp.getText() + "' , '" +this.cin.getText() +"' , '" + this.etatCiv.getText() +  "');";

        try {
            PreparedStatement pst = conn.DBcnx().prepareStatement(requete);
            pst.executeUpdate(requete);
            System.out.println("Client ajouté avec succés !");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(" M&M Location");
            alert.setContentText("Client ajouté avec succés !");
            alert.showAndWait();
        } catch (SQLException var5) {
            System.out.println("Erreur d'ajout !");
        }
        tableclients.getItems().clear();
        try {
            conn = new Cnx();
            ResultSet rs = this.conn.DBcnx().createStatement().executeQuery
                    ("SELECT `id_client`, `prenom`, `nom`, `adresse`, `etatCiv`, `cin`, `DateNaissance`, `mdp`, `tel` FROM `tableclients`");
            while(rs.next()) {
                oblistClients.add(new ModelTableClient(rs.getInt("id_client"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("tel"),
                        rs.getString("adresse"),
                        rs.getString("etatCiv"),
                        rs.getString("DateNaissance"),
                        rs.getString("mdp"),
                        rs.getString("cin")
                        ));
            }
        } catch (SQLException var6) {
            Logger.getLogger(ListerClients.class.getName()).log(Level.SEVERE, (String)null, var6);
            System.out.println("errreur ha zebi");
        }
        this.col_id.setCellValueFactory(new PropertyValueFactory("id_client"));
        this.col_nom.setCellValueFactory(new PropertyValueFactory("nom"));
        this.col_prenom.setCellValueFactory(new PropertyValueFactory("prenom"));
        this.col_age.setCellValueFactory(new PropertyValueFactory("DateNaissance"));
        this.col_tel.setCellValueFactory(new PropertyValueFactory("tel"));
        this.col_adr.setCellValueFactory(new PropertyValueFactory("adresse"));
        this.col_cin.setCellValueFactory(new PropertyValueFactory("cin"));
        this.col_etat.setCellValueFactory(new PropertyValueFactory("etatCiv"));
        this.tableclients.setItems(this.oblistClients);
    }
    @FXML
    private void suprClient(ActionEvent event) {
        int x = tableclients.getSelectionModel().getSelectedItem().getId_client();
        tableclients.getItems().removeAll(tableclients.getSelectionModel().getSelectedItem());
        String requete3 = "DELETE FROM tableclients WHERE id_client =?";
        try {
            PreparedStatement pst = conn.DBcnx().prepareStatement(requete3);
            pst.setInt(1, x);
            pst.executeUpdate();
            System.out.println("client supprimé");
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
    @FXML
    private void modifier(ActionEvent e) throws IOException {
        int x = ((ModelTableClient) this.tableclients.getSelectionModel().getSelectedItem()).getId_client();
        System.out.println(x);
        try {
            String requete4 = "UPDATE tableclients SET id_client=?, nom=?, prenom=?, DateNaissance=?, tel=? ,adresse=? ,mdp=?,cin=?,etatCiv=? WHERE id_client=?";
            PreparedStatement pst = this.conn.DBcnx().prepareStatement(requete4);
            pst.setInt(1,Integer.parseInt(id_client.getText()));
            pst.setString(2,nom.getText());
            pst.setString(3,prenom.getText());
            pst.setString(4,DateNaissance.getText());
            pst.setInt(5,Integer.parseInt(tel.getText()));
            pst.setString(6,adresse.getText());
            pst.setString(7,mdp.getText());
            pst.setString(8,cin.getText());
            pst.setString(9,etatCiv.getText());
            pst.setInt(10,x);
            System.out.println("Client modifié !");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(" M&M Location");
            alert.setContentText("Client mofifié avec succés !");
            alert.showAndWait();
            pst.executeUpdate();
            pst.close();
        } catch (SQLException var5) {
            System.out.println("Erreur !");
        }
        this.col_id.setCellValueFactory(new PropertyValueFactory("id_client"));
        this.col_nom.setCellValueFactory(new PropertyValueFactory("nom"));
        this.col_prenom.setCellValueFactory(new PropertyValueFactory("prenom"));
        this.col_age.setCellValueFactory(new PropertyValueFactory("DateNaissance"));
        this.col_tel.setCellValueFactory(new PropertyValueFactory("tel"));
        this.col_adr.setCellValueFactory(new PropertyValueFactory("adresse"));
        this.col_cin.setCellValueFactory(new PropertyValueFactory("cin"));
        this.col_etat.setCellValueFactory(new PropertyValueFactory("etatCiv"));
        this.tableclients.setItems(this.oblistClients);
    }
}
