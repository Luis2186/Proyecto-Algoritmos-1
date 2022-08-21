/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */       
package Clases;
import Estructuras.Listas.Lista;
import java.util.Date;

/**
 *
 * @author lilp_
 */
public class Mensaje implements Comparable<Mensaje> {
    
    private static int incremento = 1 ;
    private int id ; 
    private Contacto numContactoOrigen;
    private Contacto numContactoDestino;
    private Date fecha;
    private Lista linea;       

    
    public Mensaje(){}
    
    public Mensaje(Contacto numContactoOrigen, Contacto numContactoDestino, Date fecha) {
        this.id = incremento++;
        this.numContactoOrigen = numContactoOrigen;
        this.numContactoDestino = numContactoDestino;
        this.fecha = fecha;
        this.linea = new Lista();
    }

    public static int getIncremento() {
        return incremento;
    }

    public static void setIncremento(int incremento) {
        Mensaje.incremento = incremento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contacto getNumContactoOrigen() {
        return numContactoOrigen;
    }

    public void setNumContactoOrigen(Contacto numContactoOrigen) {
        this.numContactoOrigen = numContactoOrigen;
    }

    public Contacto getNumContactoDestino() {
        return numContactoDestino;
    }

    public void setNumContactoDestino(Contacto numContactoDestino) {
        this.numContactoDestino = numContactoDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Lista getLinea() {
        return linea;
    }

    public void setLinea(Lista linea) {
        this.linea = linea;
    }

  @Override
    public String toString() {
    
    return "Identificador: " + this.id + "\n Contacto Origen : " + this.numContactoOrigen.toString() + " \n Contacto Destino: " +this.numContactoDestino.toString() + "\n Fecha : " + this.fecha;
    }
    
     @Override
     public boolean equals(Object obj) {
        if( obj !=null && obj instanceof Mensaje) {
            Mensaje m = (Mensaje) obj;
            return m.numContactoOrigen == this.numContactoOrigen && m.id == this.id; 
        } else {
            return false;
        }
    }
     
    @Override
    public int compareTo(Mensaje m) {
        return m.getFecha().compareTo(this.getFecha());
    }
       
}
