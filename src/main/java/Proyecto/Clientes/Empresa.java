package Proyecto.Clientes;

import java.util.Date;

public class Empresa extends Cliente {
    //Por ahora es exactamente igual
    /*Constructor*/
    public Empresa(final String nombre, final String nif, final Direccion direccion, final String correoElectronico, final Date fecha, final Tarifa tarifa){
        super(nombre,nif, direccion, correoElectronico, fecha, tarifa);
    }
}
