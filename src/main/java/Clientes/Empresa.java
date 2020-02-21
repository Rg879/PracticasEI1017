package Clientes;

public class Empresa extends Cliente {
    //Por ahora es exactamente igual
    /*Constructor*/
    Empresa(String nombre, String nif, int codigoPostal, String provincia, String poblacion, String correoElectronico, int dia, int mes, int anyo, float coste){
        super(nombre,nif, codigoPostal, provincia, poblacion, correoElectronico, dia, mes, anyo, coste);
    }
}
