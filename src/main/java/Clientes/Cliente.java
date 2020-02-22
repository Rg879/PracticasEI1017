package Clientes;

import java.util.Calendar;

public abstract class Cliente{

    /*Definición de Atributos*/
    private String nombre;
    private String nif;
    private Direccion direccion;
    private String correoElectronico;
    private Calendar fechaDeAlta;
    private Tarifa tarifa;

    /*Constructor*/
    Cliente(final String nombre, final String nif, final  Direccion direccion, final  String correoElectronico, final  Calendar fecha, final Tarifa tarifa){
        this.nombre=nombre;
        this.nif=nif;
        this.direccion= direccion;
        this.correoElectronico= correoElectronico;
        this.fechaDeAlta = fecha;
        this.tarifa=tarifa;
    }

    /*Métodos*/
    protected void setTarifa(float coste){ //TODO: mirar si los try catch tienen sentido ahí.
        try{
            this.tarifa=new Tarifa(coste);
        }catch (Exception e){
            int pongoAlgoYaVeré; //hay que ver qué hacer.
        }
    }

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

    public Calendar getFecha() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }
}
