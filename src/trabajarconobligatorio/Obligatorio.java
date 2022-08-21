package trabajarconobligatorio;

import java.util.Date;
import Clases.Contacto;
import Clases.Linea;
import Clases.Mensaje;
import Clases.Palabra;
import Estructuras.Listas.Lista;
import Estructuras.Listas.NodoLista;
import Estructuras.Listas.TDato;
import java.util.Locale;

/**
 *
 * @author Rafael
 */
public class Obligatorio implements IObligatorio {

    private Lista listaContactos ;
    private Lista diccionario ;
    private int maxPalabras; 
    
    public Lista getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(Lista listaContactos) {
        this.listaContactos = listaContactos;
    }
    
    public Lista getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Lista diccionario) {
        this.diccionario = diccionario;
    }
    
     
    @Override
    public Retorno crearSistemaMensajes(int MAX_CANT_PALABRAS_X_LINEA) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        this.listaContactos= new Lista();
        this.diccionario= new Lista();
        this.maxPalabras=MAX_CANT_PALABRAS_X_LINEA;        
        
        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        this.listaContactos= null;
        this.diccionario= null;
        this.maxPalabras=0;
        
        return ret;
    }

    @Override
    public Retorno agregarContacto(int numContacto, String nomContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        
        Contacto contacto = new Contacto(numContacto , nomContacto);
        TDato datoContacto = new TDato(contacto);
        
        if (!this.listaContactos.buscarElemento(datoContacto))
        {
            ret.valorbooleano = this.listaContactos.agregarFinal(datoContacto);
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        
        return ret;
    }

    @Override
    public Retorno eliminarContacto(int numContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Contacto conctacto = new Contacto(numContacto , null);    
        TDato conBus= new TDato(conctacto);
        
        if(listaContactos.buscarElemento(conBus)){
            ret.valorbooleano=this.listaContactos.borrarElemento(conctacto);
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }

    @Override
    public Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        if(this.listaContactos != null){
            Contacto conOrigen = new Contacto (numContactoOrigen , null);
            Contacto conDestino = new Contacto (numContactoDestino , null);

            NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);
            NodoLista cDestino = this.listaContactos.obtenerElemento(conDestino);

            if (cOrigen != null && cDestino !=null) {           
                Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();
                Contacto contactoDestino = (Contacto) cDestino.getDato().getO();  

                Mensaje mNuevo = new Mensaje( contactoOrigen, contactoDestino , fecha) ;
                TDato datoNuevo= new TDato(mNuevo);
                contactoOrigen.getMensaje().agregarFinal(datoNuevo);        
            } else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        }else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        return ret;
    }

    @Override
    public Retorno eliminarMensaje(int numContactoOrigen, int numMensaje) { //
        Retorno ret = new Retorno(Retorno.Resultado.OK); 
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);        
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
        
        if(cOrigen != null && menBuscado != null){
            Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();                
            ret.valorbooleano=contactoOrigen.getMensaje().borrarElemento(menBuscado);
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }      
        return ret;
    }

    @Override
    public Retorno imprimirTexto(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);       
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);         
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);    
        
        if(menBuscado!=null && cOrigen != null){
     
            if( !menBuscado.getLinea().esVacia()) {

                for(int i = 0; i < menBuscado.getLinea().cantElementos(); i++){

                TDato c = (TDato) menBuscado.getLinea().datoEnPos(i);
                Linea li = (Linea) c.getO();
                System.out.print(i+1 + ": ");

                    for(int a = 0; a < li.getPalabras().cantElementos(); a++){
                        TDato s = li.getPalabras().datoEnPos(a); 
                        Palabra p = (Palabra) s.getO();
                        System.out.print( p.toString() + "  ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("¡El Texto se encuentra vacio!");
            }     
        }else {
            System.out.println("¡No existe el mensaje!");
            ret = new Retorno(Retorno.Resultado.ERROR); 
        }
        return ret;
    }

    @Override
    public Retorno insertarLinea(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
        
        if(menBuscado != null){
            Linea ingresoLinea = new Linea(this.maxPalabras) ;
            TDato nuevaL = new TDato(ingresoLinea);              
            ret.valorbooleano=menBuscado.getLinea().agregarFinalREC(menBuscado.getLinea().getInicio(),nuevaL);
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }
      
    @Override
    public Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
       
        if(menBuscado!=null){
            
        Linea ingresoLinea = new Linea(this.maxPalabras);
        TDato nuevaLinea= new TDato(ingresoLinea); 

            if(posicionLinea >=1 && posicionLinea <= menBuscado.getLinea().cantElementos()+1 ) {
                menBuscado.getLinea().ingresarEnPos(posicionLinea-1,nuevaLinea);            
            } else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }      
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }

    @Override
    public Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
        
        if(menBuscado != null && posicionLinea >=1 && posicionLinea <= menBuscado.getLinea().cantElementos() )
        {
            TDato lineaBus= menBuscado.getLinea().datoEnPos(posicionLinea-1);
            
            if(menBuscado.getLinea().buscarElemento(lineaBus)){ 
                menBuscado.getLinea().eliminarEnPos(posicionLinea-1);                
            }else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }

    @Override
    public Retorno borrarTodo(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
      
        if(menBuscado != null) {
             menBuscado.getLinea().eliminarRec(menBuscado.getLinea().cantElementos());
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        
        return ret;
    }
    
    @Override
    public Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);        
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
       
        if(menBuscado != null){
            Palabra palabraBuscada= new Palabra(palabraABorrar);
            TDato PalBus= new TDato(palabraBuscada);                      
            for(int i=0; i < menBuscado.getLinea().cantElementos(); i++){
                TDato datoLinea = menBuscado.getLinea().datoEnPos(i); // busca la palabra en la posicion -1 debido a que se sumo 1 en imprimir texto
                Linea lineaEncontrada = (Linea)datoLinea.getO();  
                
                if(lineaEncontrada.getPalabras().buscarElemento(PalBus)){
                    lineaEncontrada.getPalabras().eliminarOcurrenciaRec(lineaEncontrada.getPalabras().getInicio(), palabraBuscada);
                } else {
                    ret = new Retorno(Retorno.Resultado.ERROR);
                }
            }
        }else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }       
        return ret;
    }

    @Override
    public Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
             
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);      
        Mensaje menBuscado= buscarMensaje(numContactoOrigen,numMensaje);
        
        if(cOrigen != null && menBuscado !=null){
            
            Contacto conBuscado= (Contacto) cOrigen.getDato().getO();     
            NodoLista nodoMensaje=conBuscado.getMensaje().obtenerElemento(menBuscado);
            
            if(nodoMensaje!= null){
                Mensaje men= (Mensaje) nodoMensaje.getDato().getO();
                TDato linea = men.getLinea().datoEnPos(posicionLinea-1); // busca la palabra en la posicion -1 debido a que se sumo 1 en imprimir texto
                
                if(linea != null) {
                     Linea linBuscada = (Linea) linea.getO();
                     
                     if(linBuscada.getPalabras().puedoInsertar()){
                        Palabra ingresarPalabra= new Palabra(palabraAIngresar.trim());
                        TDato palabra= new TDato(ingresarPalabra); 
                        
                        if(posicionPalabra >=1 && posicionPalabra <= linBuscada.getPalabras().cantElementos() +1){
                            linBuscada.getPalabras().ingresarEnPos(posicionPalabra-1,palabra);          
                        } else {
                            ret = new Retorno(Retorno.Resultado.ERROR);
                        }
                     } else{
                         System.out.println("El maximo de palabras permitido es :" + linBuscada.getPalabras().getLimite());
                         ret = new Retorno(Retorno.Resultado.ERROR);
                     }
                } else {
                    ret = new Retorno(Retorno.Resultado.ERROR);
                }                     
            }           
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }         
        return ret;
}

@Override
public Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
    Retorno ret = new Retorno(Retorno.Resultado.OK);

    Mensaje mensajeBuscado = buscarMensaje(numContactoOrigen,numMensaje);
    Palabra nuevaP= new Palabra(palabraAIngresar); 
    TDato nuevaPalabra=new TDato(nuevaP);

    if(mensajeBuscado != null ){       
        TDato plinea=mensajeBuscado.getLinea().datoEnPos(posicionLinea-1);

        if(plinea !=null){   

            Linea lineaBuscada= (Linea) plinea.getO();

            if(lineaBuscada.getPalabras().puedoInsertar()){
                lineaBuscada.getPalabras().ingresarEnPos(posicionPalabra-1,nuevaPalabra);
            } else {
                NodoLista ultimo = null ;
                NodoLista anterior= null;
                int cElementosLista= mensajeBuscado.getLinea().cantElementos()-1;

                for(int i=posicionLinea-1; i<=mensajeBuscado.getLinea().cantElementos()-1; i++){           
                    plinea=mensajeBuscado.getLinea().datoEnPos(i);

                    if(plinea != null && posicionPalabra >=1 && posicionPalabra <= lineaBuscada.getPalabras().cantElementos() +1){
                        
                        lineaBuscada= (Linea) plinea.getO();

                        if(!lineaBuscada.getPalabras().puedoInsertar() && i == cElementosLista) {
                            Linea liBus = new Linea(this.maxPalabras) ;
                            TDato agregarLinea= new TDato(liBus);
                            mensajeBuscado.getLinea().agregarFinal(agregarLinea);
                        }

                        if (i== posicionLinea -1) {
                            ultimo= lineaBuscada.getPalabras().getFin(); 
                            lineaBuscada.getPalabras().borrarFin();
                            lineaBuscada.getPalabras().ingresarEnPos(posicionPalabra-1,nuevaPalabra);
                        }

                        if(lineaBuscada.getPalabras().puedoInsertar() && i> posicionLinea -1) {
                            lineaBuscada.getPalabras().agregarInicio(ultimo.getDato());
                        } else if (!lineaBuscada.getPalabras().puedoInsertar() && i>posicionLinea -1) {
                            anterior = lineaBuscada.getPalabras().getFin(); 
                            lineaBuscada.getPalabras().borrarFin();
                            lineaBuscada.getPalabras().agregarInicio(ultimo.getDato());
                            ultimo=anterior;
                        }                                 
                    } else {
                        ret = new Retorno(Retorno.Resultado.ERROR);
                    }      
                }
            }
        }        
    } else {
        ret = new Retorno(Retorno.Resultado.ERROR);
    }            
    return ret;
}

    @Override
    public Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Mensaje mensajeBuscado = buscarMensaje(numContactoOrigen,numMensaje);
        
        if(mensajeBuscado!=null) {
            TDato linBus = mensajeBuscado.getLinea().datoEnPos(posicionLinea-1);
            
            if(linBus !=null) {
                     Linea lineaActual = (Linea) linBus.getO();     
                     lineaActual.getPalabras().eliminarEnPos(posicionPalabra-1);
            } else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
            
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }    
        
        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Mensaje mensajeBuscado = buscarMensaje(numContactoOrigen,numMensaje);
        
        if(mensajeBuscado!=null) {
            TDato linBus = mensajeBuscado.getLinea().datoEnPos(posicionLinea-1);
            
            if(linBus !=null) {
                     Linea lineaActual = (Linea) linBus.getO(); 
                     Palabra palBuscada= new Palabra(palabraABorrar);
                     lineaActual.getPalabras().borrarOcurrencia(palBuscada);
            } else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }                            
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }              

        return ret;
    }

    @Override
    public Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Mensaje mensajeBuscado = buscarMensaje(numContactoOrigen,numMensaje);
        
        if(mensajeBuscado!=null) {
            TDato linBus = mensajeBuscado.getLinea().datoEnPos(posicionLinea-1);
            
            if(linBus !=null) {
                Linea liBus = (Linea) linBus.getO(); 
                    
                System.out.print( posicionLinea + " : ");

                for(int i=0; i<liBus.getPalabras().cantElementos(); i++){
                      TDato lineaBus = liBus.getPalabras().datoEnPos(i); 
                      Palabra p = (Palabra) lineaBus.getO();
                      System.out.print( p.toString() + "  ");
                } 
               System.out.println();              
            } else {
                ret = new Retorno(Retorno.Resultado.ERROR);
            }      
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }      
        return ret;
    }

    @Override
    public Retorno ingresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        String pa= FormatearPalabra(palabraAIngresar); // se formatea la palabra, para hacer el ordenamiento correctamente.
   
        String formatoPal= FormatearPalabra(pa).trim();  
        Palabra palIngreso=new Palabra(formatoPal);
        TDato pIng= new TDato(palIngreso);
        
        if(!this.diccionario.buscarElemento(pIng)) {
            this.diccionario.agregarOrd(pIng);
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }        
        return ret;
    }
    
    // Pre: La lista esta ordenada alfabeticamente.
    @Override
    public Retorno imprimirDiccionario() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        diccionario.mostrar();
        return ret;
    }

     @Override
    public Retorno borrarPalabraDiccionario(String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        String formatoPal= FormatearPalabra(palabraABorrar); // se formatea la palabra, para hacer el ordenamiento correctamente.
        Palabra borrarPal = new Palabra(formatoPal);
        TDato palEliminar= new TDato(borrarPal);
        
        if(this.diccionario.buscarElemento(palEliminar)) {
           this.diccionario.borrarElemento(borrarPal); 
        }else {
            ret = new Retorno(Retorno.Resultado.ERROR);
        }

        return ret;
    }
     
    @Override
    public Retorno ImprimirTextoIncorrecto() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        int a,b,c,d;      
        
        for(a=0; a < listaContactos.cantElementos();a++){
            TDato conBus = this.listaContactos.datoEnPos(a);
            if(conBus!=null){
                Contacto contactoBus= (Contacto) conBus.getO();
                
                for(b=0; b <= contactoBus.getMensaje().cantElementos()-1;b++){
                    TDato menBus = contactoBus.getMensaje().datoEnPos(b);
                    
                    if(menBus!=null){
                        Mensaje mensajeBus= (Mensaje) menBus.getO(); 
                        String nomDestino= mensajeBus.getNumContactoDestino().toString();
                        nomDestino= nomDestino.substring(2, nomDestino.length());
                        System.out.println( "--------------------------------------------------------------------------");
                        System.out.println( "Id Msj : "+mensajeBus.getId());
                        System.out.println( "Nombre Contacto de Origen: " + contactoBus.getNomContacto()+ " ");
                        System.out.println( "Nombre Contacto de Destino: " + nomDestino + " ");
                        System.out.println( "Palabras que no se encuentran en el diccionario:  ");
                        System.out.println();
                        if(mensajeBus.getLinea().cantElementos() !=0){
                            
                            for(c=0; c < mensajeBus.getLinea().cantElementos();c++){        
                                TDato linBus= mensajeBus.getLinea().datoEnPos(c);
                                Linea lineaBus = (Linea) linBus.getO();
                                System.out.print(c+1 + ": ");
                                
                                for(d=0 ; d < lineaBus.getPalabras().cantElementos(); d++){   
                                    TDato palBus= lineaBus.getPalabras().datoEnPos(d);
                                    Palabra palabraBus= (Palabra) palBus.getO();
                                    String palabraformateada= palabraBus.getDato();      
                                    
                                    if(!diccionario.buscarElemento(palBus)){
                                        System.out.print( palabraformateada + "  ");
                                    }     
                                }        
                                System.out.println();   
                            } 
                            System.out.println();
                        } else {                       
                            System.out.println( "¡¡Texto vacio!!");
                            System.out.println();
                        }
                    }
                }
            }  
        }
        return ret;
    }

    @Override
    public Retorno cantidadDeMensajes(int numContactoOrigen) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        
        if(this.listaContactos != null){
            NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);
            Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();
            
            Lista contactosDestino=ContactosDestino(numContactoOrigen);
            Lista fechasOrdenadas=fechasOrd(numContactoOrigen);
 
            int filas= contactosDestino.cantElementos();
            int columnas=fechasOrdenadas.cantElementos();
            
            int [][] matrizCon=new int[filas][columnas];  
        
            for(int i = 0; i < contactoOrigen.getMensaje().cantElementos()-1 ;i++){
                
                TDato NodoMensaje= contactoOrigen.getMensaje().datoEnPos(i);
                Mensaje m = (Mensaje) NodoMensaje.getO();
                
                if(i<=1){
                 System.out.println(m.getNumContactoDestino().getNomContacto());
                } else {
                    
                }
                
                for(int a=0 ;a<filas;a++){
                    
                    String NombreContacto = (String)contactosDestino.datoEnPos(i).getO();
                    
                    for(int x=0 ; x<columnas ; x++) 
                    {  
                          Date fechaComparar = (Date) fechasOrdenadas.datoEnPos(x).getO();
            
                           if(fechaComparar.compareTo(m.getFecha())==0 && NombreContacto.equals(m.getNumContactoDestino().getNomContacto())) {
                             matrizCon[i][x] ++; 
                            }
                    }          
                }      
            }
        }
        return ret;
    }

      public String mostrarmatriz(int[][] m ,Lista filasContactos , Lista columnasFecha ) {
        String  ret = "";
        int filas=m.length;
        int columnas=m[0].length;
        ret = "\n";
        
         for(int a=0 ;a<columnas;a++) {
             Date fechaComparar = (Date)columnasFecha.datoEnPos(a).getO();
             ret+= fechaComparar.toString() + "  ";
         }
         
        ret=ret+"\n";
         
        for(int i=0 ;i<filas;i++) {
            String NombreContacto = (String)filasContactos.datoEnPos(i).getO();
            ret+=NombreContacto;
            for(int j=0 ; j<columnas ; j++) 
            {
                ret=ret+"      "+m[i][j]+"    ";
            }
            ret=ret+"\n";
        }
        
        return ret ;
    }
    
    
    public Lista fechasOrd(int numContactoOrigen)
    {
        Lista fechasOrdenadas= new Lista();
        
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);
        Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();
        int a= 1;
        
        for(int i = 0; i < contactoOrigen.getMensaje().cantElementos()-1;i++){
            TDato men= contactoOrigen.getMensaje().datoEnPos(i);
            Mensaje menB=(Mensaje) men.getO();
            TDato menComparar= contactoOrigen.getMensaje().datoEnPos(a);
            Mensaje menB1=(Mensaje) menComparar.getO();
            TDato agregarFecha=new TDato(menB.getFecha());
            
            if (!menB.getFecha().equals(menB1.getFecha())) {
                fechasOrdenadas.agregarOrd(agregarFecha);                
            }
            a++;  
        }
        
        return fechasOrdenadas;
    }
    
      public Lista ContactosDestino(int numContactoOrigen)
    {
        Lista contactosDestino= new Lista();
        
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);
        
        if(cOrigen != null){     
            Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();      

            for(int i = 0; i < contactoOrigen.getMensaje().cantElementos()-1;i++){
                TDato men= contactoOrigen.getMensaje().datoEnPos(i);
                
                if(men != null) {     
                    Mensaje menB=(Mensaje) men.getO();
                    String conDestino= menB.getNumContactoDestino().getNomContacto();
                    TDato nombreDestino= new TDato(conDestino);
                    contactosDestino.agregarOrd(nombreDestino);   
                }
            }
        }
        
        return contactosDestino;
    }
    
    
    
    
    
    //Auxiliares
    
    private Mensaje buscarMensaje(int numContactoOrigen, int numMensaje) {   
        Mensaje menEncontrado= null;
        Contacto conOrigen = new Contacto (numContactoOrigen , null);
        
        if(this.listaContactos != null){
        NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);
             
            if(cOrigen !=null){
                Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();
                Mensaje menBuscado= new Mensaje(contactoOrigen,null,null);  
                menBuscado.setId(numMensaje);
                NodoLista mensaje = contactoOrigen.getMensaje().obtenerElemento(menBuscado);
                    
                if(mensaje != null){
                    menEncontrado = (Mensaje) mensaje.getDato().getO();
                }  
            }
        }
        return menEncontrado;
    }
    
 public void MostrarMensaje(int numContactoOrigen) {    
    Contacto conOrigen = new Contacto (numContactoOrigen , null);
    NodoLista cOrigen = this.listaContactos.obtenerElemento(conOrigen);
        
        if(cOrigen!=null) {
             Contacto contactoOrigen = (Contacto) cOrigen.getDato().getO();            
             contactoOrigen.getMensaje().mostrar();       
        }
}

    private String FormatearPalabra(String palabra){      
        String palFormato= palabra.toUpperCase().charAt(0) + palabra.substring(1, palabra.length() ).toLowerCase();
       return palFormato;
    }
    
    
}
