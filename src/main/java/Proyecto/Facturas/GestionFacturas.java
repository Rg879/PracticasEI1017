package Proyecto.Facturas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Clase que se ocupa de gestionar el Mapa de Factura, la estructura de datos donde relacionamos y almacenamos el NIF con la lista de Facturas del cliente
public class GestionFacturas {


    Map<String, List<Factura>> mapaDeFacturas;
    //vector que asocia el código de factura (índice del vector) con el NIF del cliente al cual pertenece la factura.
    //Agiliza la recuperación de datos de factura a partir de su código.
    ArrayList<String> vectorCodigoNif;

    public List<Factura> listaFacturasCliente (String nifCliente){
        return mapaDeFacturas.get(nifCliente); //TODO: Ojo, si no hay nada devuelve null !!!
    }

    //Método que devuelve TRUE si añade al cliente y FALSE si ya estaba (en cuyo caso, no lo añade)
    private boolean anyadirCliente(String nif){

        if (this.mapaDeFacturas.get(nif)!=null) return false; //No debería devolverlo nunca.

        List<Factura> listaFacturasCliente= new LinkedList<>(); //Lista de llamadas vacías, se puede llenar con otro método.
        this.mapaDeFacturas.put(nif,listaFacturasCliente);

        return true;
    }

    //Método que, si da de alta la llamada (la añade a la lista de de llamadas del cliente) y si no puede (porque, por ejemplo, no está el cliente) devuelve False
    public boolean darDeAltaFactura(String nif, Factura nuevaFactura){


        if (this.mapaDeFacturas.get(nif)!=null) anyadirCliente(nif);
        //TODO: añadir aquí el cálculo del importe.

        //Necesario para la implementación de "recuperarDatosFactura"
        this.vectorCodigoNif.add( nuevaFactura.getCodigoUnico(), nif);

        return this.mapaDeFacturas.get(nif).add(nuevaFactura);

        /*
        //todo: comprobar si lo de arriba funciona; sino:
        if (this.mapaDeFacturas.get(nif)!=null) anyadirCliente(nif);
        List<Llamada> listaAuxiliar= this.listaDeFacturas.get(nif);
        listaAuxiliar.add(nuevaFactura);
        listaDeLlamadas.put(nif, listaAuxiliar);
        return true;
        */
    }

    //Puede ser útil, aunque no lo pida
    public List<Factura> recuperarListaFacturas(String nif){
        return this.mapaDeFacturas.get(nif); //TODO: Ojo, si no hay nada devuelve null !!!
    }


    //Método que, a partir del código de factura, te recupera la factura en sí (con todos sus datos).
    public Factura recuperarDatosFactura(int codigo){

        Factura facturaARecuperar=null;

        List<Factura> listaAuxiliar= this.mapaDeFacturas.get(this.vectorCodigoNif.get(codigo));

        //Entre todas las facturas del cliente, se busca la que coincida con el código único
        for(Factura facturaAuxilair : listaAuxiliar){
            if(facturaAuxilair.getCodigoUnico()==codigo){
                facturaARecuperar=facturaAuxilair;
                break;
            }
        }
        return  facturaARecuperar; //TODO: Ojo, si no hay nada devuelve null !!!

    }

    //Método que devuelve true si borra el cliente y false no puede borrarlo por cosas como, por ejemplo, si el cliente no está
    //Este método es "provisional" a la espera de ver qué nos pide el enunciado del ejercicio.
    //Serviría para borrar todos los datos de de facturas de un cliente (generalmente, una empresa no se quiere hacer)
    private boolean borrarFacturasCliente(String nif){

        if (this.mapaDeFacturas.get(nif)!=null) return false;

        this.mapaDeFacturas.remove(nif);

        return true;
    }


}
