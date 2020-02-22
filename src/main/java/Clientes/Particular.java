package Clientes;

import java.util.Calendar;

public class Particular extends Cliente {

    /*Atributos*/
    private String apellidos;

    /*Constructor*/
    Particular(final String nombre, final String nif, final Direccion direccion, final String correoElectronico, final Calendar fecha, final Tarifa tarifa, final  String apellidos) {
        super(nombre,nif, direccion, correoElectronico, fecha, tarifa);
        this.apellidos=apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }
}
