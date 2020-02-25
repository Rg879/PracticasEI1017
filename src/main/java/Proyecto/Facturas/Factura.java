package Proyecto.Facturas;

import Proyecto.Clientes.Tarifa;

import java.util.Calendar;

public class Factura {

    /*Atributos*/
    private int codigoUnico;
    private Tarifa tarifa;
    private Calendar inicioPeriodo;
    private Calendar finPeriodo;
    private Calendar fechaEmision;
    private float importeFactura;


    /*Constructor*/
    Factura(final int codigoUnico, final Tarifa tarifa, final Calendar inicioPeriodo, final Calendar finPeriodo, final Calendar fechaEmision, final float importeFactura){
        this.codigoUnico=codigoUnico;
        this.tarifa=tarifa;
        this.fechaEmision=fechaEmision;
        this.inicioPeriodo=inicioPeriodo;
        this.finPeriodo=finPeriodo;
        this.importeFactura=importeFactura;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public Calendar getFinPeriodo() {
        return finPeriodo;
    }

    public Calendar getInicioPeriodo() {
        return inicioPeriodo;
    }

    public float getImporteFactura() {
        return importeFactura;
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

}

