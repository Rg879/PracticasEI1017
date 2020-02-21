package Clientes;

public class Fecha {

    private int dia;
    private int mes;
    private int anyo;

    Fecha(int dia, int mes, int anyo) throws Exception{ // TODO: poner la excepción donde toque

        //Hay que comprobar que la fecha sea correcta
        int diaFinalMes;
        switch(mes){
            case 2:
                //Si Febrero es bisiesto o no
                if ( (anyo%4==0 && anyo%100!=0) || anyo%400==0) diaFinalMes=29;
                else diaFinalMes=28;
                break;
            case 4:     //Abril
            case 6:     //Junio
            case 9:     //Septiembre
            case 11:    //Noviembre
                diaFinalMes=30;
                break;
            default:    //Meses que acaban en 31
                diaFinalMes=31;
        }

        if(dia>diaFinalMes) throw new Exception("Fecha incorrecta.\n");

        this.dia=dia;
        this.mes=mes;
        this.anyo=anyo;
    }

    public int getAnyo() {return anyo;}
    public int getDia() {return dia;}
    public int getMes() {return mes;}

    @Override
    public String toString() {
        return "Fecha:"+ dia +"/" + mes +"/" + anyo;
    }
}
