package Proyecto.Llamadas;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//Clase que se ocupa de gestionar el Mapa de Llamadas, la estructura de datos donde relacionamos y almacenamos el NIF con todas las llamadas que ha hecho.
public class GestionLlamadas {

    //String: NIF cliente; Llamada: a quién llama.
    Map<String, List<Llamada> > mapaDeLlamadas;

    //Método para tener un listado de todas las llamadas de un cliente.
    public List<Llamada> listarLlamadasCliente (String nifCliente){
        return mapaDeLlamadas.get(nifCliente); //TODO: Ojo, si no hay nada devuelve null !!!
    }

    //Método que devuelve TRUE si añade al cliente y FALSE si ya estaba (en cuyo caso, no lo añade)
    private boolean anyadirCliente(String nif){

        if (this.mapaDeLlamadas.get(nif)!=null) return false;

        List<Llamada> listaLlamadasCliente= new LinkedList<>(); //Lista de llamadas vacías, se puede llenar con otro método.
        this.mapaDeLlamadas.put(nif,listaLlamadasCliente);

        return true;
    }

    //Método que, si da de alta la llamada (la añade a la lista de de llamadas del cliente) y si no puede (porque, por ejemplo, no está el cliente) devuelve False
    public boolean darDeAltaLlamada(String nif, Llamada nuevaLlamada){


        //Si no está un cliente en la lista, se añade
        if (this.mapaDeLlamadas.get(nif)!=null) anyadirCliente(nif);

        return this.mapaDeLlamadas.get(nif).add(nuevaLlamada);

        /*
        //todo: comprobar si lo de arriba funciona; sino:
        if (this.mapaDeLlamadas.get(nif)!=null) anyadirCliente(nif);
        List<Llamada> listaAuxiliar= this.listaDeLlamadas.get(nif);
        listaAuxiliar.add(nuevaLlamada);
        listaDeLlamadas.put(nif, listaAuxiliar);
        return true;
        */
    }


    /*Por si acaso lo queremos borrar de*/
    //Método que devuelve true si borra el cliente y false no puede borrarlo por cosas como, por ejemplo, si el cliente no está
    private boolean borrarCliente(String nif){

        if (this.mapaDeLlamadas.get(nif)!=null) return false;

        this.mapaDeLlamadas.remove(nif);

        return true;
    }

}
