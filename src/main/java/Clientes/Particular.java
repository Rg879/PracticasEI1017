package Clientes;

public class Particular extends Cliente {

    /*Atributos*/
    private String apellidos;

    /*Constructor*/
    Particular(String nombre, String nif, int codigoPostal, String provincia, String poblacion, String correoElectronico, int dia, int mes, int anyo,float coste,  String apellidos)
    {
        super(nombre,nif, codigoPostal, provincia, poblacion, correoElectronico, dia, mes, anyo, coste);
        this.apellidos=apellidos;
    }

}
