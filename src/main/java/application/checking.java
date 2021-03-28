/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Juani
 */
//esta capa tiene una palabra y devueve la traduccion? me parece
import javafx.scene.Parent;
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
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class checking {
    private Diccionario diccio;
            
    public checking(Diccionario diccio){ //toma objeto diccionario para verificar
        this.diccio = diccio;
    }
    
    
    public Parent getView(){ // creo vista a devolver
        
        String vpalabra = diccio.sacarPajilla();
        Label orden = new Label("Traducir palabra:  " + vpalabra );
        TextField ingreso = new TextField();
        Button check = new Button("Check");
        Label correcto = new Label("correcto!");
        Label incorrecto = new Label("incorrecto!");
        Label mensaje = new Label("");
        
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(10);
        layout.setVgap(10);
        
        layout.add(orden, 0, 0);
        layout.add(ingreso, 0, 1);
        layout.add(check, 0, 2);
        layout.add(mensaje, 0, 3);
        //funcionalidad de boton
        check.setOnAction( (event) ->  {
            // 1. buscar traduccion de vpalabra
            
            String vtradu = ingreso.getText(); // primer iteracion, agarro texto
            if (diccio.veri(vpalabra, vtradu)){
                mensaje.setText("Correcto");
                ingreso.clear(); //limpio por ser correcto
                
                String vnueva = diccio.sacarPajilla(); // es correcto, busco nueva pajilla
                orden.setText("Traducir palabra " + vnueva); //cambio por nueva pajilla
                
                
            }else{
                mensaje.setText("Incorrecto, la traduccion correcta es: " + diccio.getValue(vpalabra));
                ingreso.clear();
            }
            
        });
        return layout;
    }
 
    
    
}
