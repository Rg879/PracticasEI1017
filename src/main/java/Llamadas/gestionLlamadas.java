package Llamadas;

import java.util.List;
import java.util.Map;

public class gestionLlamadas {

    //String: NIF cliente; Llamada: a quién llama.
    Map<String, List<Llamada> > listaDeLlamadas;

    //Método para tener un listado de todas las llamadas de un cliente.
    public List<Llamada> listaLlamadasCliente (String nifCliente){
        return listaDeLlamadas.get(nifCliente); //TODO: Ojo, si no hay nada devuelve null !!!
    }
}
