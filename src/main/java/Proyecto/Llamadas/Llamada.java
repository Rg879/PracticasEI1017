package Proyecto.Llamadas;

import java.util.Date;

public class Llamada {

    private long telefono;  //con int creo que se queda corto para llamadas al extranjero.
    private Date fechaLlamada;  //fecha + hora
    private Date fechaFin;  //puede resultar más cómodo guardarse éste dato que recalcularlo más adelante.
    private long duracionMinutos;

    //TODO: mirar se añadir la tarifa aquí ==> NO, va en facturas.

    public Llamada(long telefono, Date fecha, Date fechaFin){

        this.telefono=telefono;
        this.fechaLlamada=fecha;
        //la duración se obtiene de la "resta" de la hora de inicio la de fin.
        this.duracionMinutos= fechaLlamada.compareTo(fechaFin); //TODO: comprobar si éste compareTo lo hace con una resta, sino, hacer la resta

    }

    public Date getFecha() {
        return fechaLlamada;
    }

    public long getTelefono() { return telefono;}

        public long getDuracionMinutos() { return duracionMinutos;  }

    @Override
    public String toString() {
        return "Llamada{" +
                "telefono=" + telefono +
                ", fecha de la llamada=" + fechaLlamada +
                ", duracion en minutos=" + duracionMinutos +
                '}';
    }
}
