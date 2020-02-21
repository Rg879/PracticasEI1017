package Llamadas;

import Clientes.Fecha;
import Clientes.Hora;

public class Llamadas {

    //TODO: utilizar un tipo específico de java para la hora.
    private int telefono;
    private Fecha fecha;
    private Hora hora;
    private long duracionSegundos;

    //TODO: mirar se añadir la tarifa aquí

    Llamadas(int telefono, Fecha fecha, Hora hora, long duracionSegundos){

        this.telefono=telefono;
        this.fecha=fecha;
        this.hora=hora;
        this.duracionSegundos= duracionSegundos;
    }

    public Fecha getFecha() {
        return fecha;
    }


}
