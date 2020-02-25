package Proyecto.Clientes;

import java.util.Calendar;

public class Empresa extends Cliente {
    //Por ahora es exactamente igual
    /*Constructor*/
    public Empresa(final String nombre, final String nif, final Direccion direccion, final String correoElectronico, final Calendar fecha, final Tarifa tarifa){
        super(nombre,nif, direccion, correoElectronico, fecha, tarifa);
    }
}
