package Proyecto.Clientes;

import java.util.Date;

public abstract class Cliente{

    /*Definición de Atributos*/
    protected String nombre;
    protected String nif;
    protected Direccion direccion;
    protected String correoElectronico;
    protected Date fechaDeAlta;
    protected Tarifa tarifa;

    /*Constructor*/
    Cliente(final String nombre, final String nif, final  Direccion direccion, final  String correoElectronico, final Date fecha, final Tarifa tarifa){
        this.nombre=nombre;
        this.nif=nif;
        this.direccion= direccion;
        this.correoElectronico= correoElectronico;
        this.fechaDeAlta = fecha;
        this.tarifa=tarifa;
    }

    /*Métodos*/
    public String getNif(){
        return this.nif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", nif='" + nif + '\'' +
                ", direccion=" + direccion +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", fechaDeAlta=" + fechaDeAlta +
                ", tarifa=" + tarifa +
                '}';
    }
}
