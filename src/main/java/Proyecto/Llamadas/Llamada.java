package Proyecto.Llamadas;

import java.util.Calendar;

public class Llamada {

    private int telefono;
    private Calendar fechaLlamada;  //TODO: Mirar bien cómo va el tipo Calendar
    private Calendar horaInicio;
    private long duracionMinutos;

    //TODO: mirar se añadir la tarifa aquí ==> NO, va en facturas.

    Llamada(int telefono, Calendar fecha, Calendar horaInicio, Calendar horaFin){

        this.telefono=telefono;
        this.fechaLlamada=fecha;
        this.horaInicio=horaInicio;
        //Lo devuelve en milisegundos==> milisegundos a segundos-->variableSeg=variableMili/1000-->variableMin=variableSeg/60=variableMili/60000
        this.duracionMinutos= horaInicio.compareTo(horaFin)/60000; //TODO: mirar qué hacer (es más lógico que se le pase cuándo empieza y cuando acaba que el tiempo en segundos, pero se puede discutir.
        //TODO: Se debe comprobar que la hora sea correcta antes de que se la pasen (es decir horaFin >= horaInicio)
    }

    public Calendar getFecha() {
        return fechaLlamada;
    }

    public int getTelefono() { return telefono;}

    public Calendar getHoraInicio() { return horaInicio; }

    public long getDuracionMinutos() { return duracionMinutos;  }

    @Override
    public String toString() {
        return "Llamada{" +
                "telefono=" + telefono +
                ", fecha de la llamada=" + fechaLlamada +
                ", hora de inicio=" + horaInicio +
                ", duracion en minutos=" + duracionMinutos +
                '}';
    }
}
