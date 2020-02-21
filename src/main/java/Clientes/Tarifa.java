package Clientes;

public class Tarifa {

    private float coste;

    Tarifa(float coste) throws Exception{ // TODO: poner la excepción donde toque

        if(coste<0) throw new Exception("Error: el coste de la tarifa no puede ser negativo.\n");
        this.coste= coste;
    }

    public float getCoste() {
        return coste;
    }
}
