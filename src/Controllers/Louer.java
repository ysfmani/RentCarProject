package Controllers;

import DBConn.Cnx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.ModelTableVoitures;
import DBConn.Cnx;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
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
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Louer implements Initializable {
    @FXML
    private ImageView homeImg;

    @FXML
    private TextField Couleur;

    @FXML
    private TextField Model;

    @FXML
    private TextField Marque;

    @FXML
    private TextField prix;

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
    private TableColumn<ModelTableVoitures, String> col_TypeVoiture;
    @FXML
    private TableColumn<ModelTableVoitures, String> col_TypeCarburant;
    @FXML
    private TableColumn<ModelTableVoitures, Date> col_DateMiseCirculation;
    @FXML
    private TableColumn<ModelTableVoitures, Integer> col_prix;
    @FXML
    private TableColumn<ModelTableVoitures, String> col_Couleur;
    @FXML
    private TextField nmbrejours;

    @FXML
    private ComboBox typeasss ;

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
                this.oblistVoitures.add(new ModelTableVoitures(rs.getString("Immatriculation"), rs.getString("Marque"), rs.getString("Model"),   rs.getString("couleur"), rs.getInt("prix")));
            }
        } catch (SQLException var4) {
            Logger.getLogger(ListerVoitures.class.getName()).log(Level.SEVERE, (String)null, var4);
        }
        this.col_Immatriculation.setCellValueFactory(new PropertyValueFactory("Immatriculation"));
        this.Col_Marque.setCellValueFactory(new PropertyValueFactory("Marque"));
        this.col_Model.setCellValueFactory(new PropertyValueFactory("Model"));
        this.col_Couleur.setCellValueFactory(new PropertyValueFactory<>("couleur") );
        this.col_prix.setCellValueFactory(new PropertyValueFactory("prix"));
        this.tablevoitures.setItems(this.oblistVoitures);
    }
    @FXML
    private void LouerVoiture(ActionEvent event) {

    }
    @FXML
    private void imprimer(ActionEvent event) {
        String Immatri = tablevoitures.getSelectionModel().getSelectedItem().getImmatriculation();
        String marque = tablevoitures.getSelectionModel().getSelectedItem().getMarque();
        String model = tablevoitures.getSelectionModel().getSelectedItem().getModel();
        int prix = tablevoitures.getSelectionModel().getSelectedItem().getPrix();
        int sommetot =  Integer.parseInt(nmbrejours.getText())*prix;
        typeasss.getSelectionModel().getSelectedItem();


        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("Voiture N."+Immatri+".pdf"));
            document.open();

            Font f=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,24,Font.UNDERLINE));
            f.setColor(0,153,255);

            Font f2=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD));
            f2.setColor(0,0,0);
            Paragraph p1 = new Paragraph(" Recu de Location de Voiture numéro :  "+ Immatri ,f);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph p0 = new Paragraph("     ");
            Paragraph p2 = new Paragraph("____________________________________________________________________________");
            Paragraph p4 = new Paragraph("   -   Marque :   " +"          "+marque);
            Paragraph p12 = new Paragraph("   -   Model :   " +"          "+model);
            Paragraph p10 = new Paragraph("  -   nombre de jours:   "+"          "+ nmbrejours.getText());
            Paragraph p5 = new Paragraph("   -   Somme tot :  "+"          "+sommetot);
            Paragraph p11 = new Paragraph( "   -   Assurance :  "+"          "+typeasss.getSelectionModel().getSelectedItem());
            Paragraph p9 = new Paragraph("Bienvenue CHez M&M location ");
            p9.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(p0);
            document.add(p0);
            document.add(p1);
            document.add(p0);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p4);
            document.add(p0);
            document.add(p0);
            document.add(p12);
            document.add(p0);
            document.add(p0);
            document.add(p10);
            document.add(p0);
            document.add(p0);
            document.add(p11);
            document.add(p0);
            document.add(p0);
            document.add(p5);
            document.add(p0);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p9);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("location");
            alert.setContentText("La Facture ( "+ Immatri + " )  génerée avec succés !");
            alert.showAndWait();
        }
        catch(DocumentException | FileNotFoundException e){
            System.out.println(e);
        }
        document.close();
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
