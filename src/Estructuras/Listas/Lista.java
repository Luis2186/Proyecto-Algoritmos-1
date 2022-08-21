package Estructuras.Listas;


public class Lista implements ILista {

    private NodoLista inicio;
    private NodoLista fin;
    private int limite;
    private int actual;

    //Constructor
    @Override
    public void Lista() {
        this.inicio = null;
        this.fin = null;
        this.actual = 0;
        this.limite = 0;
    }

    //Inicio
    public void setInicio(NodoLista i) {
        inicio = i;
    }

    public NodoLista getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoLista f) {
        fin = f;
    }

    public NodoLista getFin() {
        return fin;
    }

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public boolean agregarInicio(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            NodoLista nuevo = new NodoLista(n);
            nuevo.setSig(inicio);
            this.inicio = nuevo;
            if (this.fin == null)
            {
                this.fin = nuevo;
            }
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public boolean agregarFinal(TDato n) {
        
        if (puedoInsertar()) {            
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.agregarInicio(n);
            } else {
                this.actual++;
                NodoLista aux = this.inicio;
                while (aux.getSig() != null) {
                    aux = aux.getSig();
                }
                NodoLista nuevo = new NodoLista(n);
                aux.setSig(nuevo);
                this.fin = nuevo;  
                return true;
            }
        }
        return false;
    }
 @Override
     public boolean agregarFinalREC(NodoLista aux , TDato n) {
        if(this.esVacia()) {
            this.agregarInicio(n);
            return true;
        }
        if(aux.getSig()==null) {
            NodoLista nuevo = new NodoLista (n);
            aux.setSig(nuevo);
            this.fin = nuevo;
            this.actual++;
            return true;
        } else {
            return agregarFinalREC(aux.getSig() , n);
        }
        
    }
       
    //PRE:
    //POS: Borra el primer nodo
    public boolean borrarInicio() {
        
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSig();
            this.actual--;
        }
        return true;
    }

    //PRE:
    //POS: Borra el último nodo
    public boolean borrarFin() {
        
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoLista aux = this.inicio;
                while (aux.getSig().getSig() != null) {
                    aux = aux.getSig();
                }
                this.fin = aux;
                this.fin.setSig(null);
                this.actual--;
            }
        }
        return true;
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio != null) {
            borrarInicio();
        }
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("Lista es vacía");
        } else {
            NodoLista aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getDato().getO().toString());
                aux = aux.getSig();
            }
        }
    }

    /**
     * ***Otros Métodos (iterativos)****
     * 
     * @param n
     * @return 
     */
    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public boolean agregarOrd(TDato n) {
        
        if (puedoInsertar()) {
            
            //lista vacía o primer elemento es mayor o igual => agrego al ppio
            if (this.esVacia() || this.inicio.getDato().compareTo(n.getO()) <= 0) {
                this.agregarInicio(n);
                return true;
            }
            //último elemento es menor o igual => agrego al final
            if (this.fin.getDato().compareTo(n.getO()) > 0) {
                this.agregarFinal(n);
                return true;
            }
            NodoLista aux = this.inicio;
            while (aux.getSig() != null && aux.getSig().getDato().compareTo(n.getO()) >0) {
                aux = aux.getSig();
            }
            NodoLista nuevo = new NodoLista(n);
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
            this.actual++;
            return true;
        }
        return false;
    }
      
    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(Object obj) {  
        
       if(!this.esVacia()){
     
        if (inicio.getDato().getO().equals(obj) ){
            this.inicio = this.inicio.getSig();
            this.actual--;
            return true;
        } else {           
            NodoLista temporal,anterior;
            anterior= this.inicio;         
            temporal= this.inicio.getSig();
            
            while(temporal != null && !temporal.getDato().getO().equals(obj)){
                anterior= anterior.getSig();
                temporal= temporal.getSig();
            }
                 
            if(temporal != null){
                anterior.setSig(temporal.getSig());
                this.actual--;
                
                if(temporal==this.fin) {
                    this.fin=anterior;                                   
                }
                return true; 
            }
        }
   }   
   return false;
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            NodoLista aux = this.inicio;
            while (aux != null) {
                aux = aux.getSig();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public NodoLista obtenerElemento(Object n) {
        NodoLista aux = this.inicio;
        TDato dato = new TDato(n);
        while (aux != null && !aux.getDato().getO().equals(dato.getO()) ) {
            aux = aux.getSig();
        }
        //encontré dato o llegué al final
        return aux;
    }

    /**
     * *** Métodos RECURSIVOS ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoLista l) {
        if (l != null) {
            System.out.println(l.getDato());
            mostrarREC(l.getSig());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoLista l) {
        if (l != null) {
            mostrarInversoREC(l.getSig());
            System.out.println(l.getDato());
        }
    }

    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoLista l, Object n) {
        if (l != null) {
            if (l.getDato().compareTo(n) == 0) {
                return true;
            } else {
                return existeDatoREC(l.getSig(), n);
            }
        } else {
            return false;
        }
    }

    //PRE: Posicion de la lista
    //POS: Object en posicion i.
    public TDato datoEnPos(int i) {
        int contador = 0;
        if (i == 0) {
             return this.inicio.getDato();
        }
        NodoLista ptr = this.inicio;
        
        while (contador < i && ptr!=null) {
            ptr = ptr.getSig(); 
            contador++;
            
        }
        if(ptr != null){
        return ptr.getDato();
        } else {
          return null;
        }
    }

    /**
     * Si actual < a limite, inserto //PRE: -- //POS: True si actualmente no
     * paso el limite de la lista. @return T/F
     */
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }

    /**
     * @return the actual
     */
    public int getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(int actual) {
        this.actual = actual;
    }

    @Override
    public boolean buscarElemento(TDato n) {
        NodoLista aux=this.inicio;
        
        while(aux!=null) 
        {
            TDato tDatoAux = aux.getDato();  
            
            if(tDatoAux.equals(n.getO())) {
                return true;
            }
            aux=aux.getSig();
        }   
        return false ;    
    }
    
public void ingresarEnPos(int posicion, TDato n) {  ////////////////////////

    if(posicion>=0 && posicion<=this.cantElementos())
    {
        NodoLista nuevo = new NodoLista(n);
        if(posicion == 0){
            this.agregarInicio(n) ; 
        }
        else{
        this.actual++;
        NodoLista aux = this.inicio;

        for (int i = 0; i < (posicion-1); i++) {
            aux = aux.getSig();
        }

        NodoLista siguiente = aux.getSig();
        aux.setSig(nuevo);            
        nuevo.setSig(siguiente);
        
        aux=this.inicio;
        while(aux.getSig()!=null) {
        aux=aux.getSig();
        }
        this.fin=aux;
        }      
    }
}
         
public void eliminarEnPos(int posicion) {  
    NodoLista aux = this.inicio;
    int contPos=0;
    boolean borrado= false;
        
    if(!this.esVacia() && posicion < this.cantElementos() ){  
            
        if(posicion == 0){
            this.borrarInicio();
        } else if (this.cantElementos()-1 == posicion){
            this.borrarFin();
        } else {            
            while (aux != null && !borrado) {
                
                if(contPos==posicion-1){
                    aux.setSig(aux.getSig().getSig());
                    this.actual--;
                }   
                aux = aux.getSig();
                contPos++;           
            }     
        }
    }    
}  
@Override
public int eliminarRec(int largoLista){    
        
    if ( largoLista == 0) {
        this.setInicio(null);
        return actual=0;            
    } else {
        this.setInicio(inicio.getSig());
        return eliminarRec(largoLista - 1 ) ;
    }    
}

//@Override
//public int eliminarOcurrenciaRec(Object obj,int pos){    
//        
//    NodoLista aux= this.inicio;
//    TDato palabraTDato= new TDato(obj);  
//    
//    if ( pos == 0 ) { 
//        return 0;            
//    } else {
//        borrarElemento1(obj);                          
//        return eliminarOcurrenciaRec(obj,pos-1);
//    }    
//}

@Override
public void eliminarOcurrenciaRec(NodoLista aux,Object obj){    
   
    if(!this.esVacia() && aux != null){
     
        if (inicio.getDato().getO().equals(obj) ){
            this.inicio = this.inicio.getSig();
            this.actual--;
        } else {           
            NodoLista temporal,anterior;
            anterior= this.inicio;         
            temporal= this.inicio.getSig();
            
            if( temporal !=null && !temporal.getDato().getO().equals(obj) ){
                anterior= anterior.getSig();
                temporal= temporal.getSig();
            }
                 
            if(temporal != null && temporal.getDato().getO().equals(obj)){
                anterior.setSig(temporal.getSig());
                this.actual--;
                if(temporal==this.fin) {
                    this.fin=anterior;
                }
            }     
        }  
        eliminarOcurrenciaRec(aux.getSig(),obj);
    }     
}

//@Override
////public boolean borrarElemento1(Object obj) {
////        
////   if(!this.esVacia()){
////     
////        if (inicio.getDato().getO().equals(obj) ){
////            this.inicio = this.inicio.getSig();
////            this.actual--;
////            return true;
////        } else {           
////            NodoLista temporal,anterior;
////            anterior= this.inicio;         
////            temporal= this.inicio.getSig();
////            
////            while(temporal != null && !temporal.getDato().getO().equals(obj)){
////                anterior= anterior.getSig();
////                temporal= temporal.getSig();
////            }
////                 
////            if(temporal != null){
////                anterior.setSig(temporal.getSig());
////                this.actual--;
////                
////                if(temporal==this.fin) {
////                    this.fin=anterior;                                   
////                }
////                return true; 
////            }
////        }
////   }   
////   return false;
////}

 @Override
    public void borrarOcurrencia(Object n) {
        NodoLista aux = this.inicio ;
        while(aux!=null) {
            this.borrarElemento(n);
            aux=aux.getSig();
        }
    }
   
  
}
