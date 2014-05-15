/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfx8app01;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Kantaus
 */
public class JFX8app01 extends Application {
    
    private LocalDate ld;
    
    @Override
    public void start(Stage primaryStage) {
        
        Label lblHello = new Label("Hello");
        lblHello.setAlignment(Pos.CENTER_RIGHT);
        lblHello.setContentDisplay(ContentDisplay.LEFT);
        lblHello.setTextAlignment(TextAlignment.RIGHT);
        lblHello.setPrefSize(171, 32);
        lblHello.setLayoutX(14.0);
        lblHello.setLayoutY(14.0);
//        lblHello.prefHeight(32);
//        lblHello.prefWidth(171);
        lblHello.setFont(new Font(18.0));
        Button btnHello = new Button("Button");
        btnHello.setFont(new Font(18.0));
        btnHello.setLayoutX(195.0);
        btnHello.setLayoutY(14.0);
        btnHello.setMnemonicParsing(false);
        btnHello.setPrefHeight(32.0);
        btnHello.setPrefWidth(123.0);
        
        DatePicker dp = new DatePicker();
//        dp.setOnAction((ActionEvent event) -> {
//        });
        dp.setOnAction((ActionEvent e) -> {
            ld = dp.getValue();
            System.out.println(ld);
        });
        
//        AnchorPane root = new AnchorPane(lblHello);
        AnchorPane root = new AnchorPane(lblHello, dp, btnHello);
//        AnchorPane root = new AnchorPane(btnHello, lblHello);
        root.setPrefSize(600, 400);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction((ActionEvent event) -> {
//            System.out.println("Hello World!");
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
