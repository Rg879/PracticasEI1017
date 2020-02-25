package Gestores;

import Clientes.Cliente;

import java.util.Map;
import java.util.Set;

public class GestionClientes {

    /*Atributos*/
    Map<String, Cliente> mapaClientes;

    /*Método para añadir nuevo cliente*/
    private void nuevoCliente(Cliente nuevoCliente){
        this.mapaClientes.put(nuevoCliente.getNif(), nuevoCliente);
    }

    /*Método para borrar nuevo cliente*/
    private boolean borrarCliente(String nifCliente){
        return this.mapaClientes.remove(nifCliente)!=null;
    }


    /*Cambiar tarifa*/
    private boolean cambiarTarifa(String nif, float nuevaTarifa){

        Cliente cliente= this.mapaClientes.get(nif);
        if(cliente == null) return false;
        cliente.setTarifa(nuevaTarifa);
        return true;
    }

    /*Recuperar datos a partir de su nif*/
    private Cliente recuperarDatos(String nif){
        return this.mapaClientes.get(nif);
    }

    /*devuelve un Set (conjunto) de todos los clientes*/
    private Set<String> listadoClientes(){
        return this.mapaClientes.keySet();
    }

}
