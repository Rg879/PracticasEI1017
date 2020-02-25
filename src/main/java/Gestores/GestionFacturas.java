package Gestores;

import Facturas.Factura;
import Llamadas.Llamada;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GestionFacturas {


    Map<String, List<Factura>> mapaDeFacturas;

    public List<Factura> listaLlamadasCliente (String nifCliente){
        return mapaDeFacturas.get(nifCliente); //TODO: Ojo, si no hay nada devuelve null !!!
    }

    //Método que devuelve TRUE si añade al cliente y FALSE si ya estaba (en cuyo caso, no lo añade)
    public boolean darDeAltaCliente(String nif){

        if (this.mapaDeFacturas.get(nif)!=null) return false;

        List<Factura> listaLlamadasCliente= new LinkedList<>(); //Lista de llamadas vacías, se puede llenar con otro método.
        this.mapaDeFacturas.put(nif,listaLlamadasCliente);

        return true;
    }

    //Método que, si da de alta la llamada (la añade a la lista de de llamadas del cliente) y si no puede (porque, por ejemplo, no está el cliente) devuelve False
    public boolean darDeAltaFactura(String nif, Factura nuevaFactura){


        if (this.mapaDeFacturas.get(nif)!=null) return false;

        return this.mapaDeFacturas.get(nif).add(nuevaFactura);

        /*
        //todo: comprobar si lo de arriba funciona; sino:
        if (this.listaDeFacturas.get(nif)!=null) return false;
        List<Llamada> listaAuxiliar= this.listaDeFacturas.get(nif);
        listaAuxiliar.add(nuevaFactura);
        listaDeLlamadas.put(nif, listaAuxiliar);
        return true;
        */
    }

    //Método que devuelve true si borra el cliente y false no puede borrarlo por cosas como, por ejemplo, si el cliente no está
    public boolean darDeBajaCliente(String nif){

        if (this.mapaDeFacturas.get(nif)!=null) return false;

        this.mapaDeFacturas.remove(nif);

        return true;
    }


}
