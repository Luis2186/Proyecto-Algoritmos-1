/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author lilp_
 */
public class Palabra implements Comparable<Palabra> {
    
    String dato;

    public Palabra(String dato) {
        this.dato = dato;
    }
    
    @Override
    public String toString() {   
        return this.dato;
    }
    
     @Override
     public boolean equals(Object obj) {
        if( obj !=null && obj instanceof Palabra) {
            Palabra p = (Palabra) obj;
            return p.dato.compareTo(this.dato)==0; 
        } else {
            return false;
        }
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    @Override
    public int compareTo(Palabra o) {
        String p = (String) o.dato;
        String palabra= this.dato ; 

        return palabra.compareTo(p);
    }
     
     
}
