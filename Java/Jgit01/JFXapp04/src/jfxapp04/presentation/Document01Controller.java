/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfxapp04.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Kantaus
 */
public class Document01Controller implements Initializable {
    @FXML
    private Label lblHello;
    @FXML
    private Font x1;
    @FXML
    private Button btnHello;

    @FXML
    private void btnHelloOnAction(ActionEvent event) {
        lblHello.setRotate(lblHello.getRotate() + 20);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
