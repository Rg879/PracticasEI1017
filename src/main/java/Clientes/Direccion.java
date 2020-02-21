package Clientes;

/*Por temas de compatibilidad y de lógica, he hecho esta clase totalmente independiente.*/

public class Direccion {

    /*Atributos*/
    int codigoPostal;
    String provincia;
    String poblacion;

    /*Constructor*/
    Direccion(final int codigoPostal, final String provincia, final String poblacion) {
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    /*getters*/
    public int getCodigoPostal() {return codigoPostal;}
    public String getPoblacion() {return poblacion;}
    public String getProvincia() {return provincia;}

}
