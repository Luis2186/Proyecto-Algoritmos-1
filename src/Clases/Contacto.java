/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Objects;
import Estructuras.Listas.Lista;
/**
 *
 * @author lilp_
 */
public class Contacto {
    
    private int numContacto;
    private String nomContacto;
    private Lista mensaje;

    public Contacto(int numContacto, String nomContacto) {
        this.numContacto = numContacto;
        this.nomContacto = nomContacto;
        this.mensaje = new Lista();
    }

    public Lista getMensaje() {
        return mensaje;
    }

    public void setMensaje(Lista mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(int numContacto) {
        this.numContacto = numContacto;
    }

    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }


    
    @Override
    public boolean equals(Object obj) {
      if( obj !=null && obj instanceof Contacto) {
            Contacto c = (Contacto) obj;
            return c.numContacto == this.numContacto || this.nomContacto == c.nomContacto; 
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.numContacto;
        hash = 89 * hash + Objects.hashCode(this.nomContacto);
        return hash;
    }
    
    @Override
    public String toString() {
    return this.numContacto + "-" + this.nomContacto ;
    }    

}
