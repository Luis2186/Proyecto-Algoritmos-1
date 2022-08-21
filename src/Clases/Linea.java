/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.Listas.Lista;

/**
 *
 * @author lilp_
 */
public class Linea {
    
    private Lista Palabras;

    public Linea(int maxPalabrasxLinea) {
        this.Palabras = new Lista() ;
        this.Palabras.setLimite(maxPalabrasxLinea);    
    }

    public Linea(Lista Palabras) {
        this.Palabras = Palabras;
    }

    public Lista getPalabras() {
        return Palabras;
    }

    public void setPalabras(Lista Palabras) {
        this.Palabras = Palabras;
    }
   
}
