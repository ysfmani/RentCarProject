package Controllers;
                import DBConn.Cnx;
                import java.io.IOException;
                import java.net.URL;
                import java.sql.PreparedStatement;
                import java.sql.ResultSet;
                import java.sql.SQLException;
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
                import javafx.scene.control.*;
                import javafx.scene.control.Alert.AlertType;
                import javafx.scene.control.cell.PropertyValueFactory;
                import javafx.scene.image.ImageView;
                import javafx.stage.Stage;
                import models.ModelTableVoitures;
                import javafx.scene.control.Button;
                import javafx.scene.control.TableColumn;
                import javafx.scene.control.TableView;
                import javafx.scene.control.TextField;
public class ListerVoitures implements Initializable {
        @FXML
        private ImageView homeImg;

        @FXML
        private TextField Couleur;

        @FXML
        private TextField Model;

        @FXML
        private TextField Marque;

        @FXML
        private TextField Prix;

        @FXML
        private TextField Immatriculation;
        @FXML
        private Button ajouter;
        @FXML
        private TableView<ModelTableVoitures> tablevoitures;
        @FXML
        private TableColumn<ModelTableVoitures, String> col_Immatriculation;
        @FXML
        private TableColumn<ModelTableVoitures, String> Col_Marque;
        @FXML
        private TableColumn<ModelTableVoitures, String> col_Model;
        @FXML
        private TableColumn<ModelTableVoitures, Integer> col_prix;
        @FXML
        private TableColumn<ModelTableVoitures, String> col_Couleur;
        @FXML
        private Button supprimer;
        @FXML
        private Button modifier;
        @FXML

    ObservableList<ModelTableVoitures> oblistVoitures = FXCollections.observableArrayList();
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    private Cnx conn;
       public void initialize(URL location, ResourceBundle resources) {
        try {
            this.conn = new Cnx();
            ResultSet rs = this.conn.DBcnx().createStatement().executeQuery("SELECT `Immatriculation`, `Marque`, `Model`, `Couleur`, `Prix` FROM `tablevoitures`");

            while(rs.next()) {
                this.oblistVoitures.add(new ModelTableVoitures(rs.getString("Immatriculation"), rs.getString("Marque"), rs.getString("Model"),   rs.getString("couleur"), rs.getInt("Prix")));
            }
        } catch (SQLException var4) {
            Logger.getLogger(ListerVoitures.class.getName()).log(Level.SEVERE, (String)null, var4);
        }
        this.col_Immatriculation.setCellValueFactory(new PropertyValueFactory("Immatriculation"));
        this.Col_Marque.setCellValueFactory(new PropertyValueFactory("Marque"));
        this.col_Model.setCellValueFactory(new PropertyValueFactory("Model"));
        this.col_Couleur.setCellValueFactory(new PropertyValueFactory<>("couleur") );
        this.col_prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        this.tablevoitures.setItems(this.oblistVoitures);
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
    private void ajouterVoiture(ActionEvent event) {
        String requete = "INSERT INTO tablevoitures (Immatriculation, Marque, couleur, Model, Prix) " +
                "VALUES ('" + this.Immatriculation.getText() + "','" +
                this.Marque.getText() + "','" +
                this.Model.getText() + "','" +
                this.Couleur.getText() + "','" +
                this.Prix.getText() + "');";
        System.out.println(Immatriculation.getText() );
        System.out.println(Couleur.getText() );
        System.out.println(Prix.getText() );

        try {
            PreparedStatement pst = this.conn.DBcnx().prepareStatement(requete);
            pst.executeUpdate(requete);
            System.out.println("voiture ajouté avec succés !");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(" M&M Location");
            alert.setContentText("Voiture ajouté avec succés !");
            alert.showAndWait();
        } catch (SQLException var5) {
            System.out.println("Erreur d'ajout !");
        }
        this.tablevoitures.getItems().clear();
        try {
            this.conn = new Cnx();
            ResultSet rs = this.conn.DBcnx().createStatement().executeQuery("SELECT Immatriculation, Marque, couleur, Model, Prix FROM tablevoitures");

            while(rs.next()) {
                this.oblistVoitures.add(new ModelTableVoitures(rs.getString("Immatriculation"), rs.getString("Marque"), rs.getString("Model"),  rs.getString("couleur"),  rs.getInt("Prix")));
            }
        } catch (SQLException var6) {
            Logger.getLogger(ListerVoitures.class.getName()).log(Level.SEVERE, (String)null, var6);
        }
        this.col_Immatriculation.setCellValueFactory(new PropertyValueFactory("Immatriculation"));
        this.Col_Marque.setCellValueFactory(new PropertyValueFactory("Marque"));
        this.col_Couleur.setCellValueFactory(new PropertyValueFactory<>("couleur") );
        this.col_Model.setCellValueFactory(new PropertyValueFactory("Model"));
        this.col_prix.setCellValueFactory(new PropertyValueFactory("Prix"));
        this.tablevoitures.setItems(this.oblistVoitures);
      //  this.sendmail();
    }
    @FXML
    private void suprVoiture(ActionEvent event) {
        String x = ((ModelTableVoitures)this.tablevoitures.getSelectionModel().getSelectedItem()).getImmatriculation();
        this.tablevoitures.getItems().removeAll(tablevoitures.getSelectionModel().getSelectedItem());
        String requete3 = "DELETE FROM tablevoitures WHERE Immatriculation =?";

        try {
            PreparedStatement pst = this.conn.DBcnx().prepareStatement(requete3);
            pst.setString(1,x);
            pst.executeUpdate();
            System.out.println("Voiture supprimé");
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
        String x = ((ModelTableVoitures) this.tablevoitures.getSelectionModel().getSelectedItem()).getImmatriculation();
        System.out.println(x);
        try {
            String requete4 = "UPDATE tablevoitures SET Immatriculation=?, Marque=?, couleur=?, Model=?, Prix=? WHERE Immatriculation=?";
            PreparedStatement pst = this.conn.DBcnx().prepareStatement(requete4);
            pst.setString(1,Immatriculation.getText());
            System.out.println(Immatriculation.getText());
            pst.setString(2,Marque.getText());
            pst.setString(3,Couleur.getText());
            pst.setString(4,Model.getText());
            pst.setInt(5,Integer.parseInt(Prix.getText()));
            pst.setString(6,x);
            System.out.println("voiture modifié !");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(" M&M Location");
            alert.setContentText("Voiture mofifié avec succés !");
            alert.showAndWait();
            pst.executeUpdate();
            pst.close();
      } catch (SQLException var5) {
        System.out.println("Erreur !");
        }
        this.col_Immatriculation.setCellValueFactory(new PropertyValueFactory("Immatriculation"));
        this.Col_Marque.setCellValueFactory(new PropertyValueFactory("Marque"));
        this.col_Model.setCellValueFactory(new PropertyValueFactory("Model"));
        this.col_Couleur.setCellValueFactory(new PropertyValueFactory<>("couleur") );
        this.col_prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        this.tablevoitures.setItems(this.oblistVoitures);
        }



}
