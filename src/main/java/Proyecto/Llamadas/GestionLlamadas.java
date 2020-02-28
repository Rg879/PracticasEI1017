package Proyecto.Llamadas;

import Proyecto.Gestion;
import Proyecto.GestionConListas;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//Clase que se ocupa de gestionar el Mapa de Llamadas, la estructura de datos donde relacionamos y almacenamos el NIF con todas las llamadas que ha hecho.
public class GestionLlamadas implements Gestion {

    protected Map<String, List<Llamada>> mapaDeGestion;

    /*Constructor*/
    public GestionLlamadas(){
        this.mapaDeGestion=new HashMap<>();
    }

    public List<Llamada> recuperarDatos (String nif){
        return this.mapaDeGestion.get(nif); //TODO: Ojo, si no hay nada devuelve null !!!
    }

    //Método que, si da de alta la llamada (la añade a la lista de de llamadas del cliente) y si no puede (porque, por ejemplo, no está el cliente) devuelve False
    public boolean darDeAlta(String nif, Llamada nuevoDato){


        //Si no está un cliente en la lista, se añade
        if (this.mapaDeGestion.get(nif)!=null) {
            List<Llamada> listaDatosAIntroducir = new LinkedList<>(); //Lista de llamadas vacías, se puede llenar con otro método.
            this.mapaDeGestion.put(nif, listaDatosAIntroducir);
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

    @Override
    public boolean darDeBajaCliente(String nif) {

        if(mapaDeGestion.get(nif)==null)return false;
        mapaDeGestion.remove(nif);
        return true;
    }

    @Override
    public boolean contieneCliente(String nif) {
        return this.mapaDeGestion.containsKey(nif);
    }


}
