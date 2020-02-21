package Llamadas;

import Clientes.Fecha;

import java.sql.Time;

public class Llamada {

    //TODO: utilizar un tipo específico de java para la hora.
    private int telefono;
    private Fecha fecha;
    private Time horaInicio;
    private long duracionSegundos;

    //TODO: mirar se añadir la tarifa aquí ==> NO, va en facturas.

    Llamada(int telefono, Fecha fecha, Time horaInicio, Time horaFinal){

        this.telefono=telefono;
        this.fecha=fecha;
        this.horaInicio=horaInicio;
        this.duracionSegundos= horaFinal-horaInicio; //TODO: mirar qué hacer (es más lógico que se le pase cuándo empieza y cuando acaba que el tiempo en segundos, pero se puede discutir.
    }

    public Fecha getFecha() {
        return fecha;
    }

    public int getTelefono() { return telefono;}

    public Time getHora() { return hora; }

    public long getDuracionSegundos() { return duracionSegundos; }
}
