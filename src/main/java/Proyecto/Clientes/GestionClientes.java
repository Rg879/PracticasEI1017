package Proyecto.Clientes;

import Proyecto.Gestion;

import java.util.Map;
import java.util.Set;


//Clase que se ocupa de gestionar el Mapa de Clientes, la estructura de datos donde relacionamos y almacenamos el NIF con el Objeto Cliente
public class GestionClientes implements Gestion {

    /*Atributos*/
    Map<String, Cliente> mapaClientes;

    /*Método para añadir nuevo cliente*/
    public void darDeAltaCliente(Cliente nuevoCliente){
        this.mapaClientes.put(nuevoCliente.getNif(), nuevoCliente);
    }

    /*Método para borrar nuevo cliente*/
    @Override
    public boolean darDeBajaCliente(String nifCliente){
        return this.mapaClientes.remove(nifCliente)!=null;
    }

    @Override
    public boolean contieneCliente(String nif) {
        return this.mapaClientes.containsKey(nif);
    }


    /*Cambiar tarifa*/
    public boolean cambiarTarifa(String nif, Tarifa nuevaTarifa){

        Cliente cliente= this.mapaClientes.get(nif);
        if(cliente == null) return false;

        cliente.tarifa=nuevaTarifa;

        return true;
    }

    /*Recuperar datos a partir de su nif*/
    public Cliente recuperarDatos(String nif){
        return this.mapaClientes.get(nif);
    } //Si no existe el nif, devuelve null

    /*devuelve un Set (conjunto) de todos los clientes*/
    private Set<String> listadoClientes(){
        return this.mapaClientes.keySet();
    }

}
