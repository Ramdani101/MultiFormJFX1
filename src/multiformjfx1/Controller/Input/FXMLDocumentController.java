/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package multiformjfx1.Controller.Input;

import multiformjfx1.Model.Harga.Model_harga;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import multiformjfx1.Controller.Output.FXML_outputController;
import multiformjfx1.Model.MultiformJFX1.MultiFormJFX1Model;

/**
 *
 * @author Ramdani
 */
public class FXMLDocumentController implements Initializable {
    
    public static Model_harga dtharga = new Model_harga();
    
    MultiFormJFX1Model dt = new MultiFormJFX1Model();
    
    @FXML
    private Label label;
    @FXML
    private TextField txtpembeli;
    @FXML
    private TextField txtluas;
    @FXML
    private ChoiceBox<String> chbjenis;
    @FXML
    private Button btnmodal;
    @FXML
    private Button btnmodel;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnubahharga;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chbjenis.setItems(FXCollections.observableArrayList(
        "Sederhana","Menengah","Mewah"));
        chbjenis.getSelectionModel().select(0); //supaya lgs pilihan awal
        dtharga.setHrsederhana(50000000);dtharga.setHrmenengah(100000000);
        dtharga.setHrmewah(500000000);dtharga.setHtsederhana(500000);
        dtharga.setHtmenengah(800000); dtharga.setHtmewah(2000000);

    }    

    @FXML
    private void modalklik(ActionEvent event) {
        
        if(txtluas.getText().isEmpty()){
            do{
                TextInputDialog tx=new TextInputDialog();                
                tx.setContentText("Masukkan luas tanah:");
                tx.setTitle("Input luas tanah");
                tx.showAndWait();
                txtluas.setText(tx.getResult());
            }while(txtluas.getText().isEmpty());
	} 

        
        dt.setLuas(Integer.parseInt(txtluas.getText()));
        dt.setPembeli(txtpembeli.getText());
        dt.setPilihJenis(chbjenis.getSelectionModel().getSelectedIndex());
        try{  FXMLLoader loader=new    
          FXMLLoader(getClass().getResource("/multiformjfx1/FXML/Output/FXML_output.fxml"));    
          Parent root = (Parent)loader.load();
//koding untuk mengirim data ke tampilan output
          FXML_outputController isidt=     
          (FXML_outputController)loader.getController();
          isidt.getdata(dt);
//membuat windows baru
          Scene scene = new Scene(root);
          Stage stg=new Stage();  
//koding untuk windows dialog / modal       
          stg.initModality(Modality.APPLICATION_MODAL);
          stg.setResizable(false);
          stg.setIconified(false);
          //koding untuk /menampilkan windows
          stg.setScene(scene);
          stg.show();
          }catch (IOException e){   e.printStackTrace();}
    }

    @FXML
    private void modelklik(ActionEvent event) {
        
         if(txtluas.getText().isEmpty()){
            ChoiceDialog<String> pilih=new ChoiceDialog<String>
            (chbjenis.getItems().get(0),  chbjenis.getItems());
            pilih.setContentText("Pilih jenis rumah:");            
            pilih.showAndWait();
            chbjenis.getSelectionModel().select(pilih.getResult());
            Alert al=new Alert(Alert.AlertType.ERROR, 
            "Masukkan luas tanah", ButtonType.OK);
            al.showAndWait();
            txtluas.requestFocus();
            }else{ 
            }

        
        dt.setLuas(Integer.parseInt(txtluas.getText()));
        dt.setPembeli(txtpembeli.getText());
        dt.setPilihJenis(chbjenis.getSelectionModel().getSelectedIndex());
        try{  FXMLLoader loader=new    
          FXMLLoader(getClass().getResource("/multiformjfx1/FXML/Output/FXML_output.fxml"));    
          Parent root = (Parent)loader.load();
//koding untuk mengirim data ke tampilan output
          FXML_outputController isidt=     
          (FXML_outputController)loader.getController();
          isidt.getdata(dt);
//membuat windows baru
          Scene scene = new Scene(root);
          Stage stg=new Stage();  
          //koding untuk /menampilkan windows
          stg.setScene(scene);
          stg.show();
          }catch (IOException e){   e.printStackTrace();}
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        txtpembeli.setText("");
        txtluas.setText("");
        txtpembeli.requestFocus();
        
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void ubahhargaklik(ActionEvent event) {
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/multiformjfx1/FXML.Ubah_Harga/FXML_ubahharga.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }   

    }
    
}
