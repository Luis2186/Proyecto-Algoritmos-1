package Estructuras.Listas;

/**
 *
 * @author RC
 */
public interface ILista {

    //POS: Constructor, crea una lista vacía
    void Lista();
    
    //POS: Retorna true si la lista no tiene nodos
    boolean esVacia();
    
    //POS: Inserta un nodo al principio de la lista
    boolean agregarInicio(TDato n);

    //POS: Inserta un nodo al final de la lista
    boolean agregarFinal(TDato n);

    //POS: Borra el primer nodo
    boolean borrarInicio();

    //POS: Borra el último nodo
    boolean borrarFin();

    //POS: Muestra los datos de la lista
    void mostrar();

    //POS: Elimina todos los nodos de la lista
    void vaciar();
    
    //POS: Busca el nodo en la lista
    boolean buscarElemento(TDato n);
    
    public int eliminarRec(int pos);
    public void eliminarOcurrenciaRec(NodoLista aux,Object obj);
//    public boolean borrarElemento1(Object n);
    public boolean agregarFinalREC(NodoLista aux , TDato n);
    public void borrarOcurrencia(Object n);
    public boolean agregarOrd(TDato n);
}
