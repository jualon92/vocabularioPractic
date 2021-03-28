package application;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;


public class VocabularyPracticeApplication extends Application {
    private Diccionario diccio;
    
    //constructor
  //  @Override
   // public void init(){
   //     this.diccio = new Diccionario(); // inicializo nuevo ddicio, crea hashmap y arraylist
  //  }
    
    @Override
    public void start(Stage teatro) throws Exception{
        Diccionario diccio = new Diccionario(); // crea obj diccio
        
        Button opcionExpa = new Button("Expandir Diccionario");
        Button opcionPracti = new Button("Practicar");
        Label contador = new Label("");
        BorderPane layoutSuper = new BorderPane(); //layout superpuesto, impreso arriba de todo
        
        HBox linea = new HBox();
        linea.setPadding(new Insets(10,10,10,10));
        linea.setSpacing(10);
        
        HBox lineaDer = new HBox();
        lineaDer.setPadding(new Insets(10,10,10,10));
        lineaDer.setSpacing(10);
        
        linea.getChildren().addAll(opcionExpa,opcionPracti); //agrego botones a linea
        layoutSuper.setTop(linea); // agrego linea a layout parte de arriba
        
      //  layout.setTop(linea);
        
        
        
        //creo sub views
        checking vistachekeo = new checking(diccio); // inic ambas escenas
        pairing vistapares = new pairing(diccio);
       
        //--- 
        layoutSuper.setCenter(vistapares.getView()); // comienza con vista pares
        
        Scene escenaNeut = new Scene(layoutSuper, 400, 300); // creo escena con size
        
        opcionExpa.setOnAction( (event) -> {  // agrego func a botones para cambiar a escenas
            //cambio view
            layoutSuper.setCenter(vistapares.getView()); //parent tiene getView
            // pongo en el medio de layoutSuper a otro taskPane
        });
        
        opcionPracti.setOnAction( (event) -> { 
            layoutSuper.setCenter(vistachekeo.getView()); //chequea la palabra
            //devuelve todo perfecto
            
        });
        
       
      
        teatro.setScene(escenaNeut);
        teatro.show();
        
        
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}  
    
    
    
    

