/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multiformjfx1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ramdani
 */
public class FXML_ubahhargaController implements Initializable {
    
    
    
    @FXML
    private TextField txthrsederhana;
    @FXML
    private TextField txthtsederhana;
    @FXML
    private TextField txthrmenengah;
    @FXML
    private TextField txthtmenengah;
    @FXML
    private TextField txthrmewah;
    @FXML
    private TextField txthtmewah;
    @FXML
    private Button btnok;
    @FXML
    private Button btnreset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okklik(ActionEvent event) {
        FXMLDocumentController.dtharga.setHrsederhana(Integer.parseInt
        (txthrsederhana.getText()));       FXMLDocumentController.dtharga.setHrmenengah(Integer.parseInt
        (txthrmenengah.getText()));FXMLDocumentController.dtharga.setHrmewah(Integer.parseInt
        (txthrmewah.getText()));FXMLDocumentController.dtharga.setHtsederhana(Integer.parseInt
        (txthtsederhana.getText()));FXMLDocumentController.dtharga.setHtmenengah(Integer.parseInt
        (txthtmenengah.getText())); FXMLDocumentController.dtharga.setHtmewah(Integer.parseInt
        (txthtmewah.getText()));
        btnok.getScene().getWindow().hide();

    }

    @FXML
    private void resetklik(ActionEvent event) {
        txthrsederhana.setText("50000000");
        txthrmenengah.setText("100000000");
        txthrmewah.setText("500000000");
        txthtsederhana.setText("500000");
        txthtmenengah.setText("800000");
        txthtmewah.setText("2000000"); 

    }
    
}
