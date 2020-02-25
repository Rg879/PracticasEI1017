package Gestores;

import Llamadas.Llamada;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GestionLlamadas {

    //String: NIF cliente; Llamada: a quién llama.
    Map<String, List<Llamada> > mapaDeLlamadas;

    //Método para tener un listado de todas las llamadas de un cliente.
    public List<Llamada> listaLlamadasCliente (String nifCliente){
        return mapaDeLlamadas.get(nifCliente); //TODO: Ojo, si no hay nada devuelve null !!!
    }

    //Método que devuelve TRUE si añade al cliente y FALSE si ya estaba (en cuyo caso, no lo añade)
    public boolean darDeAltaCliente(String nif){

        if (this.mapaDeLlamadas.get(nif)!=null) return false;

        List<Llamada> listaLlamadasCliente= new LinkedList<>(); //Lista de llamadas vacías, se puede llenar con otro método.
        this.mapaDeLlamadas.put(nif,listaLlamadasCliente);

        return true;
    }

    //Método que, si da de alta la llamada (la añade a la lista de de llamadas del cliente) y si no puede (porque, por ejemplo, no está el cliente) devuelve False
    public boolean darDeAltaLlamada(String nif, Llamada nuevaLlamada){


        if (this.mapaDeLlamadas.get(nif)!=null) return false;

        return this.mapaDeLlamadas.get(nif).add(nuevaLlamada);

        /*
        //todo: comprobar si lo de arriba funciona; sino:
        if (this.listaDeLlamadas.get(nif)!=null) return false;
        List<Llamada> listaAuxiliar= this.listaDeLlamadas.get(nif);
        listaAuxiliar.add(nuevaLlamada);
        listaDeLlamadas.put(nif, listaAuxiliar);
        return true;
        */
    }

    //Método que devuelve true si borra el cliente y false no puede borrarlo por cosas como, por ejemplo, si el cliente no está
    public boolean darDeBajaCliente(String nif){

        if (this.mapaDeLlamadas.get(nif)!=null) return false;

        this.mapaDeLlamadas.remove(nif);

        return true;
    }

}
