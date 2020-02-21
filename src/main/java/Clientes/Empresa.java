package Clientes;

public class Empresa extends Cliente {
    //Por ahora es exactamente igual
    /*Constructor*/
    Empresa(String nombre, String nif, Direccion direccion, String correoElectronico, Fecha fecha, Tarifa tarifa){
        super(nombre,nif, direccion, correoElectronico, fecha, tarifa);
    }
}
