package Clientes;

public abstract class Cliente{

    /*Definición de Atributos*/
    private String nombre;
    private String nif;
    private Direccion direccion;
    private String correoElectronico;
    private Fecha fechaDeAlta;
    private Tarifa tarifa;

    private class Direccion {

        int codigoPostal;
        String provincia;
        String poblacion;

        Direccion(final int codigoPostal, final String provincia, final String poblacion) {
            this.codigoPostal = codigoPostal;
            this.provincia = provincia;
            this.poblacion = poblacion;
        }

        private int getCodigoPostal() {return codigoPostal;}
        private String getPoblacion() {return poblacion;}
        public String getProvincia() {return provincia;}
    }


    /*Constructor*/
    Cliente(final String nombre, final String nif, final  Direccion direccion, final  String correoElectronico, final  Fecha fecha, final Tarifa tarifa){
        this.nombre=nombre;
        this.nif=nif;
        this.direccion= direccion; //TODO: que nos pasen la dirección mejor.
        this.correoElectronico= correoElectronico;
        this.fechaDeAlta = fecha;
        this.tarifa=tarifa;
    }

    /*Métodos*/
    protected void setTarifa(float coste){ //TODO: no tiene sentido que esté aquí
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

    public Fecha getFecha() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }
}
