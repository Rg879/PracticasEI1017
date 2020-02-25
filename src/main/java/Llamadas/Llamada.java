package Llamadas;

import java.util.Calendar;

public class Llamada {

    private int telefono;
    private Calendar fecha;  //TODO: Mirar bien cómo va el tipo Calendar
    private Calendar horaInicio;
    private long duracionMiliSegundos;

    //TODO: mirar se añadir la tarifa aquí ==> NO, va en facturas.

    Llamada(int telefono, Calendar fecha, Calendar horaInicio, Calendar horaFin){

        this.telefono=telefono;
        this.fecha=fecha;
        this.horaInicio=horaInicio;
        this.duracionMiliSegundos= horaInicio.compareTo(horaFin); //TODO: mirar qué hacer (es más lógico que se le pase cuándo empieza y cuando acaba que el tiempo en segundos, pero se puede discutir.
        //TODO: Se debe comprobar que la hora sea correcta antes de que se la pasen (es decir horaFin >= horaInicio)
    }

    public Calendar getFecha() {
        return fecha;
    }

    public int getTelefono() { return telefono;}

    public Calendar getHoraInicio() { return horaInicio; }

    private long getDuracionSegundos() { return duracionMiliSegundos/1000; } //TODO: private o public?

    public long getDuracionMinutos(){return getDuracionSegundos()/60;}
}
