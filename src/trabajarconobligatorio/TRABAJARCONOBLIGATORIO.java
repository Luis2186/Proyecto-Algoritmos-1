package trabajarconobligatorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class TRABAJARCONOBLIGATORIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodeprueba1(obl, p); // juego de prueba ejemplo
    }

    public static void juegodeprueba1(Obligatorio obl, Prueba p) throws ParseException{
//        Escriba su juego de prueba aqui

//      FUNCIONALIDADES PRINCIPALES

//      2.1. Crear Sistema de Mensajes  
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");

//      2.2. Destruir Sistema de Mensajes  
//        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");

//      2.3 Crear Contacto
        p.ver(obl.agregarContacto(1, "Juan Perez").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
        p.ver(obl.agregarContacto(1, "Juan Perez").resultado, Retorno.Resultado.ERROR, "se intenta agregar contacto Juan Perez que ya existe"); // Error Mismo ID
        p.ver(obl.agregarContacto(2, "Juan Perez").resultado, Retorno.Resultado.ERROR, "se intenta agregar contacto Juan Perez que ya existe"); // Error Mismo Nombre
        p.ver(obl.agregarContacto(2, "Luis Lopez").resultado, Retorno.Resultado.OK, "se agrega contacto Luis Lopez");
        p.ver(obl.agregarContacto(3, "Natalia Gonzales").resultado, Retorno.Resultado.OK, "se agrega contacto Natalia Gonzales");
        p.ver(obl.agregarContacto(4, "Austin Power").resultado, Retorno.Resultado.OK, "se agrega contacto Austin Power");
        p.ver(obl.agregarContacto(5, "Judith Stiling").resultado, Retorno.Resultado.OK, "se agrega contacto Judith Stiling ");        
        obl.getListaContactos().mostrar();        
//        
//      2.4 Eliminar Contacto       
//      p.ver(obl.eliminarContacto(1).resultado, Retorno.Resultado.OK, "se elimina contacto Juan Perez del sistema");
//      p.ver(obl.eliminarContacto(2).resultado, Retorno.Resultado.OK, "se elimina contacto Luis Lopez del sistema");
//      p.ver(obl.eliminarContacto(3).resultado, Retorno.Resultado.OK, "se elimina contacto Natalia Gonzales del sistema");
//      p.ver(obl.eliminarContacto(4).resultado, Retorno.Resultado.OK, "se elimina contacto Austin Power del sistema");
//      p.ver(obl.eliminarContacto(5).resultado, Retorno.Resultado.OK, "se elimina contacto Judith Stiling del sistema");      
//      obl.getListaContactos().mostrar();
//        
//      System.out.println();
//      System.out.println();
//       
//       
//      2.5 Agregar Mensaje 

//      Definimos una fecha        
      Date fecha=new Date();
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

      fecha=formato.parse("25/03/2022");
      
      p.ver(obl.agregarMensaje(1, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega el mensaje --");
      p.ver(obl.agregarMensaje(1, 4, fecha).resultado, Retorno.Resultado.OK, "Se agrega el mensaje --");
      p.ver(obl.agregarMensaje(1, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega el mensaje --");
      p.ver(obl.agregarMensaje(2, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega el mensaje --");
      p.ver(obl.agregarMensaje(4, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega el mensaje --");
      p.ver(obl.agregarMensaje(2, 1, fecha).resultado, Retorno.Resultado.OK, "Se agrega el mensaje --");
  
      obl.MostrarMensaje(1);
      obl.MostrarMensaje(2);
      obl.MostrarMensaje(4);
           
//      2.6. Eliminar Mensaje       
//      p.ver(obl.eliminarMensaje(1,2).resultado, Retorno.Resultado.OK, "Se Elimina el mensaje Conctaco Origen 1, IdMensaje : 2");
//      obl.MostrarMensaje(1);

//      OPERACIONESS RELATIVAS A LOS MENSAJES
                
//      3.1 Imprime el texto por pantalla.      
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//        
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra3").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra4").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje Id 1");
                    
//      3.2 Inserta una nueva línea vacía al final del texto del mensaje.

//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje Id 1");
                    
//      3.3 Inserta una nueva línea vacía en la posición indicada.
       
      p.ver(obl.insertarLineaEnPosicion(4, 5 ,1).resultado, Retorno.Resultado.OK, "Ingresar una linea en la posicion");
      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Ingresar una palabra en una linea");        
      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");        
      p.ver(obl.insertarLineaEnPosicion(4, 5 ,1).resultado, Retorno.Resultado.OK, "Ingresar una linea en la posicion");
      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
      
//      3.4 Borra la línea en la posición indicada.
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Ingresar una palabra en una linea");
//      p.ver(obl.imprimirTexto(4,5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.borrarLinea(4,5,1).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.imprimirTexto(4,5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");

//      3.5. Borra todas las líneas del texto.

//      p.ver(obl.borrarTodo(4,5) .resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");

//      3.6 Borra todas las ocurrencias de una palabra en el texto.
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 2 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); //Revisar el orden cuando hace el desplazamiento hacia la fila posterior
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); 
//      p.ver(obl.insertarLineaEnPosicion(4, 5 ,2).resultado, Retorno.Resultado.OK, "Ingresar una linea en la posicion");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.borrarOcurrenciasPalabraEnTexto(4, 5, "Palabra2").resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");

//      3.7 Inserta una palabra en una línea.

//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 2 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); //Revisar el orden cuando hace el desplazamiento hacia la fila posterior
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra3").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.insertarPalabraYDesplazar(4, 5 , 2 , 2 ,"Palabra4").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.insertarPalabraYDesplazar(4, 5 , 2 , 3 ,"Palabra5").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
      
//      3.8 Inserta una palabra en una línea y desplaza a la siguiente si es necesario. 

//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 2 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); 
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra3").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.insertarPalabraYDesplazar(4, 5 , 2 , 2 ,"Palabra4").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.insertarPalabraYDesplazar(4, 5 , 2 , 3 ,"Palabra5").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");

//      3.9 Borra la palabra en la posición indicada

//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 2 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); 
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra3").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.borrarPalabra(4, 5, 2, 1).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 3 , 1 ,"Palabra3").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");   
//      p.ver(obl.borrarPalabra(4, 5, 2, 1).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.borrarPalabra(4, 5, 2, 1).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
    
//      3.10 Borra todas las ocurrencias de una palabra en la línea indicada.

//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 2 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); 
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.borrarOcurrenciasPalabraEnLinea(4, 5, 2, "Palabra2").resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Imprime texto en pantalla Mensaje 5");

//      3.11 Imprime la línea por pantalla.
//
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.imprimirLinea(4, 5, 2).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra1").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 2 ,"Palabra2").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea "); 
//      p.ver(obl.imprimirLinea(4, 5, 2).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");

//      OPERACIONES RELATIVAS AL DICCIONARIO   

//      3.12 Agrega una palabra al diccionario

//      p.ver(obl.ingresarPalabraDiccionario("HOJA").resultado, Retorno.Resultado.OK, "Se ingresa la palabra Hoja al Diccionario");
//      p.ver(obl.ingresarPalabraDiccionario("Hojalata").resultado, Retorno.Resultado.OK, "Se ingresa la palabra Hojalata al Diccionario");
//      p.ver(obl.ingresarPalabraDiccionario("Bosque").resultado, Retorno.Resultado.OK, "Se ingresa la palabra Bosque al Diccionario");
//      p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "");    
   
//      3.13 - 3.14 Agrega una palabra al diccionario y la muestra

//      p.ver(obl.borrarPalabraDiccionario("Hoja").resultado, Retorno.Resultado.OK, "");    
//      p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "");

//      3.14 Muestra las palabras del diccionario alfabéticamente.

//      3.15 Muestra las palabras del texto que no se encuentran en el diccionario

//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//      p.ver(obl.insertarLinea(4, 5).resultado, Retorno.Resultado.OK, "Inserta linea en Id Msj : 5 y contacto 4");
//     
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 1 ,"Palabra21").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 2 , 2 ,"Palabra22").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 1 ,"Palabra11").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 2 ,"Palabra12").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 1 , 3 ,"Palabra13").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//     
//      p.ver(obl.insertarPalabraEnLinea(4, 5 , 3 , 1 ,"Palabra31").resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      p.ver(obl.imprimirTexto(4, 5).resultado, Retorno.Resultado.OK, "Insertar una palabra en una linea ");
//      
//      p.ver(obl.ingresarPalabraDiccionario("Palabra12").resultado, Retorno.Resultado.OK, "Se ingresa la palabra Hoja al Diccionario");
//      p.ver(obl.ingresarPalabraDiccionario("Palabra21").resultado, Retorno.Resultado.OK, "Se ingresa la palabra Hojalata al Diccionario");
//      p.ver(obl.ingresarPalabraDiccionario("Palabra22").resultado, Retorno.Resultado.OK, "Se ingresa la palabra Bosque al Diccionario");  
//      p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Imprimir texto incorrecto que no se encuentre en el diccionario");
      
//      4.1. Muestra la cantidad de mensajes enviados por un contacto

//      fecha=formato.parse("25/03/2022");
//       -------------------------------

//      p.ver(obl.agregarMensaje(1, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Juan para Luis en  fecha 25/03/2022 ");
//      p.ver(obl.agregarMensaje(1, 4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Juan para Austin en  fecha 25/03/2022");
//      p.ver(obl.agregarMensaje(1, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Juan para Natalia en  fecha 25/03/2022");
//      p.ver(obl.agregarMensaje(2, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Luis para Natalia en  fecha 25/03/2022");   
//      p.ver(obl.agregarMensaje(2, 1, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Luis para Juan en  fecha 25/03/2022");
//      p.ver(obl.agregarMensaje(4, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Austin para Natalia en  fecha 25/03/2022");
//  
//      obl.MostrarMensaje(1);
//      obl.MostrarMensaje(2);
//      obl.MostrarMensaje(4);
//      
//      p.ver(obl.agregarMensaje(4,3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Austin para Natalia en  fecha 25/03/2022 ");
//      p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje de Luis para Austin en  fecha 25/03/2022 ");
//      p.ver(obl.insertarLineaEnPosicion(4, 3, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//      p.ver(obl.insertarLineaEnPosicion(2, 3, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//      p.ver(obl.insertarPalabraEnLinea(2, 3,1,1,"Estoy").resultado, Retorno.Resultado.OK,"Se agrega palabra Estoy linea 1 mensaje 2");
//      p.ver(obl.insertarPalabraEnLinea(2, 3,1,2,"estacionando").resultado, Retorno.Resultado.OK,"Se agrega palabra estacionando linea 1 mensaje 2");
//        
//  
//        
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje   para Maria en fecha 25/03/2022 ");
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  para Maria en fecha 25/03/2022");
//         Agregamos lineas al mensaje 2 de Maria
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
//        
//         Agregamos palabras al mensaje 2 de maria en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(2, 2,1,1,"Hola").resultado, Retorno.Resultado.OK,"Se agrega palabra Hola linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,1,2,"Maria").resultado, Retorno.Resultado.OK,"Se agrega palabra Maria linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraYDesplazar(2, 2, 1, 3, "llamo").resultado,Retorno.Resultado.OK,"Se agrega palabra llamo a mensaje 2 linea 1 de maria");
//        p.ver(obl.insertarPalabraYDesplazar(2, 2, 1, 3, "Te").resultado,Retorno.Resultado.OK,"Se agrega palabra Te a mensaje 2 linea 1 de maria");
//        p.ver(obl.insertarPalabraYDesplazar(2, 2, 2, 2, "y salimos").resultado,Retorno.Resultado.OK,"Se agrega palabra Te a mensaje 2 linea 1 de maria");
//                
//        
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,1,"Te").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,2,"LLamo").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");        






//      JUEGO DE PRUEBAS PROFESOR
//
//        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
//        p.ver(obl.agregarContacto(1, "Carlos Perez").resultado, Retorno.Resultado.OK, "se agrega contacto Carlos Perez al sistema");
//        p.ver(obl.agregarContacto(1, "Carlos Perez").resultado, Retorno.Resultado.ERROR, "se intenta agregar contacto Carlos Perez que ya existe");
//        p.ver(obl.eliminarContacto(1).resultado, Retorno.Resultado.OK, "se elimina contacto Carlos Perez del sistema");
//       
//        p.ver(obl.agregarContacto(1, "Juan").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        p.ver(obl.agregarContacto(2, "Pedro").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        p.ver(obl.agregarContacto(3, "Ana").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        p.ver(obl.agregarContacto(4, "Maria").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        obl.getListaContactos().mostrar();
//         ----------------------
//         Mostramos contactos
//            obl.getListaContactos().mostrar();  
//        -----------------------    
//        
//        // definimos una fecha        
//        Date fecha=new Date();
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//  
//       -------------------------------
///*        fecha=formato.parse("23/03/2022");*/
//       --------------------------------
//         Agregamos 3 mensajes a contacto Pedro que Existe
//        p.ver(obl.agregarMensaje(2,1, fecha).resultado, Retorno.Resultado.OK, "Se agrega primer mensaje para Pedro ");
//        p.ver(obl.agregarMensaje(2,1, fecha).resultado, Retorno.Resultado.OK, "Se agrega segundo mensaje para Pedro ");
//        p.ver(obl.agregarMensaje(2,1, fecha).resultado, Retorno.Resultado.OK, "Se agrega tercer  mensaje para Pedro ");
//        obl.MostrarMensaje(2);
//        
//         Agregamos 3 mensajes a contacto 8 que NO Existe
//        p.ver(obl.agregarMensaje(5,2, fecha).resultado, Retorno.Resultado.OK, "Se agrega mensaje a contacto inexistente ");
//
//        
//         Agregamos lineas al mensaje 2 de pedro
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 2 de Pedro");
//        
//         Agregamos palabras al mensaje 2 de pedro en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(2, 2,1,1,"Hola").resultado, Retorno.Resultado.OK,"Se agrega palabra Hola linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,1,2,"Pedro").resultado, Retorno.Resultado.OK,"Se agrega palabra Pedro linea 1 mensaje 2");
// 
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,1,"Te").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,2,"LLamo").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,3,"En").resultado, Retorno.Resultado.OK,"Se agrega palabra Llamo linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,3,1,"5min").resultado, Retorno.Resultado.OK,"Se agrega palabra 5min linea 3 mensaje 2");
//      
//         Imprimimos mensaje 2 de pedro
//        p.ver(obl.imprimirTexto(2, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Pedro");
//        
//        p.ver(obl.insertarPalabraYDesplazar(2, 2,2,2,"puedo").resultado, Retorno.Resultado.OK,"Se agrega palabra puedo en linea 2 mensaje 2 posicion 2");
//        
//         Imprimimos mensaje 2 de pedro
//        p.ver(obl.imprimirTexto(2, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Pedro");
//        
//        p.ver(obl.borrarPalabra(2,2, 2, 2).resultado, Retorno.Resultado.ERROR, "Se elimina palabra pos 2 de mensaje 2 linea 2 de pedro");
//
//         Imprimimos mensaje 2 de pedro
//        p.ver(obl.imprimirTexto(2, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Pedro");
//       
//       -------------------------------        
//        fecha=formato.parse("24/03/2022");
//       -------------------------------
//       
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  4 para Pedro en  fecha 24/03/2022 ");
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 5 para Pedro en  fecha 24/03/2022 ");
//        
//        Agregamos lineas al mensaje 1 de pedro
//        p.ver(obl.insertarLineaEnPosicion(2, 1, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(2, 1, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(2, 1, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 2 de Pedro");
//
//         Agregamos palabras al mensaje 1 de pedro en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(2, 1,1,1,"Voy").resultado, Retorno.Resultado.OK,"Se agrega palabra voy linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 1,1,2,"llegando").resultado, Retorno.Resultado.OK,"Se agrega palabra llegando linea 1 mensaje 2");
//         
//        
//        p.ver(obl.agregarMensaje(2,3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  4 para Ana en fecha 24/03/2022 ");
//        p.ver(obl.agregarMensaje(2,3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 5 para Ana en fecha 24/03/2022");
//       
//       -------------------------------        
//        fecha=formato.parse("25/03/2022");
//       -------------------------------
//       
//        p.ver(obl.agregarMensaje(2,2, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje para Pedro en  fecha 25/03/2022 ");
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje para Maria en  fecha 25/03/2022 ");
//        p.ver(obl.insertarLineaEnPosicion(2, 3, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarPalabraEnLinea(2, 3,1,1,"Estoy").resultado, Retorno.Resultado.OK,"Se agrega palabra Estoy linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 3,1,2,"estacionando").resultado, Retorno.Resultado.OK,"Se agrega palabra estacionando linea 1 mensaje 2");
//        
//  
//        
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje   para Maria en fecha 25/03/2022 ");
//        p.ver(obl.agregarMensaje(2,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  para Maria en fecha 25/03/2022");
//         Agregamos lineas al mensaje 2 de Maria
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(2, 2, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
//        
//         Agregamos palabras al mensaje 2 de maria en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(2, 2,1,1,"Hola").resultado, Retorno.Resultado.OK,"Se agrega palabra Hola linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,1,2,"Maria").resultado, Retorno.Resultado.OK,"Se agrega palabra Maria linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraYDesplazar(2, 2, 1, 3, "llamo").resultado,Retorno.Resultado.OK,"Se agrega palabra llamo a mensaje 2 linea 1 de maria");
//        p.ver(obl.insertarPalabraYDesplazar(2, 2, 1, 3, "Te").resultado,Retorno.Resultado.OK,"Se agrega palabra Te a mensaje 2 linea 1 de maria");
//        p.ver(obl.insertarPalabraYDesplazar(2, 2, 2, 2, "y salimos").resultado,Retorno.Resultado.OK,"Se agrega palabra Te a mensaje 2 linea 1 de maria");
//                
//        
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,1,"Te").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(2, 2,2,2,"LLamo").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
//       
//        p.ver(obl.cantidadDeMensajes(2).resultado,Retorno.Resultado.OK,"Mensajes de pedro");
//                
//        p.ver(obl.ingresarPalabraDiccionario("hola").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("Estacionando").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("llegando").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("Te").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("Estoy").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
//        
//        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "palabras del diccionario");
//        p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Palabras que no estan en el diccionario");
//       
//       p.ver(obl.cantidadDeMensajes(1).resultado, Retorno.Resultado.OK, "Mensajes de juan"); 
//       p.ver(obl.cantidadDeMensajes(2).resultado, Retorno.Resultado.OK, "Mensajes de Pedro"); 
//       p.ver(obl.cantidadDeMensajes(3).resultado, Retorno.Resultado.OK, "Mensajes de Ana");
//       p.ver(obl.cantidadDeMensajes(4).resultado, Retorno.Resultado.OK, "Mensajes de Maria");
//       
//        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, " sistema eliminado");
//
//
//        p.ver(obl.cantidadDeMensajes(4).resultado, Retorno.Resultado.OK, " ");



       
      p.imprimirResultadosPrueba();
    }
}
