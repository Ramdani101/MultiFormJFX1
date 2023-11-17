/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multiformjfx1.Controller.Output;

import multiformjfx1.Model.MultiformJFX1.MultiFormJFX1Model;
import multiformjfx1.Controller.Input.FXMLDocumentController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ramdani
 */
public class FXML_outputController implements Initializable {

    @FXML
    private Label lblpembeli;
    @FXML
    private Label lbljenisrumah;
    @FXML
    private Label lblhargarumah;
    @FXML
    private Label lblhasiltanah;
    @FXML
    private Label lblsubtotal;
    @FXML
    private Label lblpajak;
    @FXML
    private Label lbltotal;
    @FXML
    private Label lblhargatanah;
    @FXML
    private Label lblluastanah;
    @FXML
    private Button btnkembali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void kembaliklik(ActionEvent event) {
        btnkembali.getScene().getWindow().hide();;
    }

    public void getdata(MultiFormJFX1Model d) {
        int hrumah = 0, htanah = 0, pajak = 0;
        String jenis = "";
        switch (d.getPilihJenis()) {
            case 0:
                hrumah = FXMLDocumentController.dtharga.getHrsederhana();
                htanah = FXMLDocumentController.dtharga.getHtsederhana();
                jenis = "Sederhana";
                pajak = 0;
                break;
            case 1:
                hrumah = FXMLDocumentController.dtharga.getHrmenengah();
                htanah = FXMLDocumentController.dtharga.getHtmenengah();
                jenis = "Menengah";
                pajak = 0;
                break;
            case 2:
                hrumah = FXMLDocumentController.dtharga.getHrmewah();
                htanah = FXMLDocumentController.dtharga.getHtmewah();
                jenis = "Mewah";
                pajak = (int) Math.round(hrumah * 0.1);
                break;
            default:
                jenis = "tidak ada";
                hrumah = 0;
                htanah = 0;
                pajak = 0;
        }

        int hasiltanah = htanah * d.getLuas();
        int sub = hasiltanah + hrumah;
        int total = sub + pajak;

        lblpembeli.setText(d.getPembeli());
        lbljenisrumah.setText(jenis);
        lblhargarumah.setText(String.valueOf(hrumah));
        lblluastanah.setText(String.valueOf(d.getLuas()));
        lblhargatanah.setText(String.valueOf(htanah));
        lblhasiltanah.setText(String.valueOf(hasiltanah));
        lblsubtotal.setText(String.valueOf(sub));
        lblpajak.setText(String.valueOf(pajak));
        lbltotal.setText(String.valueOf(total));

    }

}
