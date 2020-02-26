package Proyecto.Facturas;

import Proyecto.Clientes.Tarifa;

import java.util.Date;

public class Factura {

    /*Atributos*/
    private int codigoUnico;
    private Tarifa tarifa;
    private Date inicioPeriodo;
    private Date finPeriodo;
    private Date fechaEmision;
    private float importeFactura;


    /*Constructor*/
    public Factura(final int codigoUnico, final Tarifa tarifa, final Date inicioPeriodo, final Date finPeriodo, final Date fechaEmision, final float importeFactura){
        this.codigoUnico=codigoUnico;
        this.tarifa=tarifa;
        this.fechaEmision=fechaEmision;
        this.inicioPeriodo=inicioPeriodo;
        this.finPeriodo=finPeriodo;
        this.importeFactura=importeFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFinPeriodo() {
        return finPeriodo;
    }

    public Date getInicioPeriodo() {
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

    @Override
    public String toString() {
        return "Factura{" +
                "código de la factura=" + codigoUnico +
                ", tarifa=" + tarifa +
                ", inicio del periodo=" + inicioPeriodo +
                ", fin del periodo=" + finPeriodo +
                ", fecha de emision=" + fechaEmision +
                ", importe total de la factura=" + importeFactura +
                '}';
    }
}

