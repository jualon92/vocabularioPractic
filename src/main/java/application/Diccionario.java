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
//diccionaro esta compuesto por un hashmap con eps;aol a ingles
//y on un arraylist construido por los elementos Keys del hashmap
//una funcion random utilizara este arraylist para sacar una palabra Random mas adelante

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Diccionario {
    private HashMap<String,String> diccio;
    private ArrayList<String> lista;

    public Diccionario() {
        this.diccio = new HashMap(); // inicializo ambas
        this.lista = new ArrayList();
    }
    
    
    public void parNuevo(String pal, String tradu){ //preguntaba si estaba el value, no la key. pero pa1 es key.
        if (! (this.diccio.containsKey(pal)) ) { //si no la contiene, agrego en la lista para no rep
            
            this.lista.add(pal);
        }
        
        this.diccio.put(pal, tradu); // en un hashmap no hay repetidos
        
        
        
    }
    
    //iteracion de hashmap a arrayList.
  
    
    public String getValue(String key){
        return this.diccio.get(key);
    }
    /*
    public boolean estaRepe(String pkey, String pvalue){
        if (this.diccio.containsKey(pkey)){
            String vtradu = this.diccio.get(pkey);
            if (vtradu.equals(pvalue)){
                return true;
            }
        }
        return false;
    }
    */
    public boolean veri(String pkey, String pvalue){ // In: palabra, contra.  buscar que exista palabra,contra
        if (this.diccio.containsKey(pkey)){ //si existe key Hola. 
            String vtradu = this.diccio.get(pkey); // devuelve valor de hola (seria traduccion, hello)
            if (vtradu.equals(pvalue)){ // si el valor tambien coincide esta bien, Hello == Hello
                return true;
            }else{
                return false; //devuelve falso si no coincide
            }
        }
        return false; //si no lo contiene devuelve falso tambien
    }
    
    
    public String sacarPajilla(){
       Random random = new Random();
       
       int index = random.nextInt(this.lista.size());
       return this.lista.get(index);
       
    }
    
    
}
