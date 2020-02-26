package Proyecto.Facturas;

import Proyecto.Gestion;
import Proyecto.GestionConListas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Clase que se ocupa de gestionar el Mapa de Factura, la estructura de datos donde relacionamos y almacenamos el NIF con la lista de Facturas del cliente
public class GestionFacturas implements Gestion {


    protected Map<String, List<Factura>> mapaDeGestion;
    //vector que asocia el código de factura (índice del vector) con el NIF del cliente al cual pertenece la factura.
    //Agiliza la recuperación de datos de factura a partir de su código.
    ArrayList<String> vectorCodigoNif;


    public List<Factura> recuperarDatos (String nif){
        return this.mapaDeGestion.get(nif); //TODO: Ojo, si no hay nada devuelve null !!!
    }


    //Método que, si da de alta la llamada (la añade a la lista de de llamadas del cliente) y si no puede (porque, por ejemplo, no está el cliente) devuelve False
    public boolean darDeAlta(String nif, Factura nuevoDato){


        //Si no está un cliente en la lista, se añade
        if (this.mapaDeGestion.get(nif)!=null){

            List<Factura> listaDatosAIntroducir= new LinkedList<>(); //Lista de llamadas vacías, se puede llenar con otro método.
            this.mapaDeGestion.put(nif,listaDatosAIntroducir);

        }

        return this.mapaDeGestion.get(nif).add(nuevoDato);

        /*
        //todo: comprobar si lo de arriba funciona; sino:
        if (this.mapaDeLlamadas.get(nif)!=null) anyadirCliente(nif);
        List<T> listaAuxiliar= this.mapaDeGestion.get(nif);
        listaAuxiliar.add(nuevoDato);
        listaDeLlamadas.put(nif, listaAuxiliar);
        return true;
        */
    }

    //No me parece el método más lógico, pero se podría dar el caso que se quisése borrar todos los datos de un cliente.
    @Override
    public boolean darDeBajaCliente(String nif) {

        if(mapaDeGestion.get(nif)==null)return false;
        mapaDeGestion.remove(nif);
        return true;
    }

    //por utilidad
    @Override
    public boolean contieneCliente(String nif) {
        return this.mapaDeGestion.containsKey(nif);
    }


    //Método que, a partir del código de factura, te recupera la factura en sí (con todos sus datos).
    public Factura recuperarDatos(int codigo){

        Factura facturaARecuperar=null;

        List<Factura> listaAuxiliar= this.mapaDeGestion.get(this.vectorCodigoNif.get(codigo));

        //Entre todas las facturas del cliente, se busca la que coincida con el código único
        for(Factura facturaAuxilair : listaAuxiliar){
            if(facturaAuxilair.getCodigoUnico()==codigo){
                facturaARecuperar=facturaAuxilair;
                break;
            }
        }
        return  facturaARecuperar; //TODO: Ojo, si no hay nada devuelve null !!!

    }

    public int proximoCodigoFacturaParaAsignar(){
        return this.vectorCodigoNif.size(); //size nº elementos, vector -> [0,size-1]
    }

}
