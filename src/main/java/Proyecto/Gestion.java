package Proyecto;

public interface Gestion /*<T, U>*/{

    //True si se elimina al cliente , False si no existia
    boolean darDeBajaCliente(String nif);

    //True si lo contiene, false si no.
    boolean contieneCliente(String nif);

    /* TODO: ver como hacerlo bien, ya que GestionClientes trabaja con String y Clientes, y el resto, con String y List<Factura>, y con String y List<Llamadas>
    U recuperarDatos(String nif);

    void darDeAlta(String nif, T cosaADarDeAlta);
    */

}
