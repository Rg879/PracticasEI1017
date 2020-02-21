package Clientes;

public class Particular extends Cliente {

    /*Atributos*/
    private String apellidos;

    /*Constructor*/
    Particular(String nombre, String nif, Direccion direccion, String correoElectronico, Fecha fecha, Tarifa tarifa,  String apellidos) {
        super(nombre,nif, direccion, correoElectronico, fecha, tarifa);
        this.apellidos=apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }
}
