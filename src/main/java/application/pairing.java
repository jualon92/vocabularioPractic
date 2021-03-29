/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Juani
 */// quiero hacer la app del boton para pairin
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Parent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



public class pairing  {
    //referencia a diccionario, para agregar palabras.
    private Diccionario diccio;
    
    public pairing(Diccionario diccio){ // diccionario a utilizar.
        this.diccio = diccio;
    }
    
    //pairing,getview.  hace ventana de getview a enquistar
    public Parent getView(){
    Label labelPal = new Label("Palabra");
    
    TextField textPal = new TextField();
    Label labelTradu = new Label("Traduccion");
    TextField textTradu = new TextField();
    Button botonPares = new Button("Agregar nuevo par de palabras");
    Label mensaje = new Label(""); //mensaje invisible
    
    
    GridPane layout1 = new GridPane();
    layout1.add(labelPal, 0, 0);
    layout1.add(textPal, 0, 1);
    layout1.add(labelTradu,0,2);
    layout1.add(textTradu, 0, 3);
    layout1.add(botonPares, 0, 4);
    layout1.add(mensaje,0,5);
    
    layout1.setAlignment(Pos.CENTER); //css
    layout1.setVgap(10);
    layout1.setHgap(10);
    layout1.setPadding(new Insets(10,10,10,10)); // camara/ espacio de aire
    
    //comportamiento
    botonPares.setOnAction( (event) -> { 
        
        String vpal = textPal.getText();
        String vtradu = textTradu.getText(); 
        if (this.diccio.veri(vpal, vtradu)) {
            mensaje.setText("Par ya existe!");
            textTradu.clear();
            textPal.clear();
        }else{
            this.diccio.parNuevo(vpal, vtradu);
            mensaje.setText("palabra: " + vpal + "\ntraducc: " +  this.diccio.getValue(vpal));
            textTradu.clear();
            textPal.clear();
        }
    });
    
    return layout1;
    //ventana
        
    
    
    }
    
    
    
}

//como launcheo? desde arafue?