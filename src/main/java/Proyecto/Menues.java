package Proyecto;

import Proyecto.Clientes.*;
import Proyecto.Facturas.GestionFacturas;
import Proyecto.Llamadas.GestionLlamadas;
import Proyecto.Llamadas.Llamada;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

//El objetivo de esta clase es la que recibirá todos los datos y se encargará de crear los objetos correspondientes y enviárselo a las gestiones correspondiente
public class Menues {

    //TODO: ¿Sería esto correcto? ya que, de esta forma, con cada ejecución tendríamos un objeto nuevo (sería mejor que los datos se guardaran en un fichero)
    GestionClientes conjuntoDatosClientes= new GestionClientes(); //"conjunto datos" porque no es una base de datos, pero prácticamente hace su función
    GestionFacturas conjuntoDatosFacturas= new GestionFacturas();
    GestionLlamadas conjuntoDatosLlamadas= new GestionLlamadas();

    String mensajeEntradaErronea="La opción escogida es incorrecta; porfavor, seleccione una correcta:";
    String mensajeGenericoEntradaOpciones ="Por favor, introduzca por teclado el número de una de las siguientes opciones:"; //Es importante saludar y, en general, ser educado.
    String mensajePeticionNif="Introduzca el NIF: \n"; //Hay muchas opciones que piden el NIF.
    String exitoOperacion="Operación realizada con exito. \n";
    String fOperacion="Error : el cliente no existe. \n"; /*Por ahora estaría esta opción*/

    //Petición "eterna" de una entrada; el fin de esta "eternidad" llega tecleando una de las opciones correctas.
    private int menuOpciones(String mensajeInicial, String opciones, int min, int max){

        int opcion;
        System.out.println(mensajeInicial);

        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println(opciones);
            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                if (max < opcion || opcion < min)
                    System.out.println(mensajeEntradaErronea);
                else break;

            } else {
                System.out.println(mensajeEntradaErronea);
            }
        }
        entrada.close();
        return opcion;
    }

    //Se piden muchas veces el NIF.
    private String peticionNif(String mensajePeticionNif){
        Scanner sc=new Scanner(System.in);
        System.out.print(mensajePeticionNif);
        String nif=sc.next();
        sc.close();
        return nif;
    }

    //El menú principal, desde aquí se llaman al resto de menus de gestión
    public void menuPrincipal () {

        boolean continuarTrabajando=true;
        int min=0;
        int max=3;
        System.out.println("Saludos,");

        String opciones= "1.-Gestión de Clientes\n2.-Gestión de Facturas\n3.-Gestión de Llamadas\n0.-Salir";
        String despedida="Hasta la vista";

        while(continuarTrabajando) {
            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, min, max)) {

                //Queda más limpio así
                case 1: //Gestión de clientes.

                    menuClientes();

                    break;
                case 2: //Gestión de facturas.

                    menuFacturas();

                    break;
                case 3: //Gestion de llamadas

                    menuLlamadas();

                    break;
                default: //Salir del programa
                    continuarTrabajando=false;
            }

            if(continuarTrabajando){
                String continuar="¿Desea continuar trabajando?";
                String opcionesContinuar="1.-Sí\n0.-No";
                int s=1, n=0;
                if(menuOpciones(continuar,opcionesContinuar,s,n)==n) continuarTrabajando=false;
            }
        }
        System.out.println(despedida);
    }


    //Conjunto de métodos menú desde los que se gestionan las distintas estructuras de datos importantes
    private void menuClientes(){
        boolean continuarEnElMenu=true;
        String menuActual="\n\n----Menú de Gestión de Clientes----\n\n";
        String subMenuActual="---";
        String opciones= "1.-Dar de alta un cliente.\n2.-Dar de baja un cliente.\n3.-Cambiar la tarifa de un cliente.\n4.- Recuperar los datos de un cliente a partir de su NIF.\n\n0.- Volver al menu anterior.";
        int minimo=0;
        int maximo=4;

        Scanner sc;
        String nif;
        String peticionTarifa="Introduzca la tarifa del nuevo cliente: \n";
        float costeTarifa;
        Tarifa tarifa;

        while(continuarEnElMenu){
            System.out.print(menuActual);

            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, minimo, maximo) ){

                case 1:
                    subMenuActual=subMenuActual+"Dar de alta un cliente---\n";
                    System.out.print(subMenuActual);
                    Cliente nuevoCliente=null;
                    //Petición de los datos para hacer un nuevo cliente.
                    String peticionNombre="Introduzca nombre: \n";
                    String nombre;
                    String peticionApellido="Introduzca el apellido: \n";
                    String apellidos;

                    String peticionCodPostal="Intruduza el codigo postal: \n";
                    int codPostal;
                    String peticionProvincia="Introduzca la provincia: \n";
                    String provincia;
                    String peticionPoblacion="Introduzca la poblacion: \n";
                    String poblacion;
                    String peticionCorreo="Introduzca el correo electrónico: \n";
                    String correo;
                    String peticionFechaDeAlta="Introduzca la fecha de alta: \n"; //TODO: ¿Hay que introducirla manualmente, o suponer que és el día que se introducen los datos?
                    Calendar fechaDeAlta;
                    String peticionDia="Introduzca el día de alta: \n";
                    int dia;
                    String peticionMes="Introduzca el mes de alta: \n";
                    int mes;
                    String peticionAño="Introduzca el año de alta: \n";
                    int anyo;

                    Scanner datosCliente= new Scanner(System.in);

                    //Todo: suponer que la gente no es buena y nos va a introducir valores incorrectos
                    System.out.print(peticionNombre);
                    nombre=datosCliente.next();

                    nif= peticionNif(mensajePeticionNif);

                    System.out.print(peticionCodPostal);
                    codPostal=datosCliente.nextInt();

                    System.out.print(peticionProvincia);
                    provincia=datosCliente.next();

                    System.out.print(peticionPoblacion);
                    poblacion=datosCliente.next();

                    //Creación de la dirección
                    Direccion direccionCliente= new Direccion(codPostal, provincia, poblacion);

                    System.out.print(peticionCorreo);
                    correo=datosCliente.next();

                    //Si no hay que poner la fecha actual como fecha de alta:
                    System.out.print(peticionDia);
                    dia=datosCliente.nextInt();

                    System.out.print(peticionMes);
                    mes=datosCliente.nextInt();

                    System.out.print(peticionAño);
                    anyo=datosCliente.nextInt();

                    //Creación de la fecha
                    fechaDeAlta.set(anyo,mes,dia); //TODO: mirarse BIEN como va calendar o escoger otra.

                    while(true) {
                        System.out.print(peticionTarifa);
                        costeTarifa = datosCliente.nextFloat();
                        if(costeTarifa<0){
                            String tarifaIncorrecta="Error: La tarifa debe ser mayor a 0€";
                        }else break;
                    }
                    tarifa= new Tarifa(costeTarifa);

                    String preguntaCliente= "¿Qué tipo de cliente es";
                    String opcionesTipoCliente= "1.-Empresa\n2.-Particular";
                    int numeroOpcionesCliente=2;

                    //Donde se introducen las opciones especiales por ser cliente.
                    int tipoCliente=menuOpciones(preguntaCliente, opcionesTipoCliente,1,numeroOpcionesCliente);
                    switch (tipoCliente) {
                        case 1: //Empresa
                            //Por ahora no hay nada en especial por añadir una empresa
                            nuevoCliente=new Empresa(nombre, nif, direccionCliente, correo, fechaDeAlta, tarifa);
                            break;
                        case 2: //Particular
                            System.out.print(peticionApellido);
                            apellidos=datosCliente.next();
                            nuevoCliente=new Particular(nombre, nif, direccionCliente, correo, fechaDeAlta, tarifa, apellidos);
                            break;
                    }

                    //Donde de verdad se añade al cliente:
                    conjuntoDatosClientes.darDeAltaCliente(nuevoCliente);
                    System.out.print(exitoOperacion);

                    datosCliente.close();
                    break;
                case 2: //Dar de baja un cliente
                    String sBorrado;
                    subMenuActual=subMenuActual+"Dar de baja un cliente---\n";
                    System.out.print(subMenuActual);

                    nif=peticionNif(mensajePeticionNif);

                    if(this.conjuntoDatosClientes.darDeBajaCliente(nif) ) sBorrado=exitoOperacion; //Exito al borrar
                    else sBorrado=fOperacion; //Fallo al borrar.

                    System.out.print(sBorrado);

                    break;
                case 3://Cambiar la tarifa de un cliente
                    subMenuActual=subMenuActual+"Cambiar la tarifa de un cliente---\n";
                    System.out.print(subMenuActual);

                    nif=peticionNif(mensajePeticionNif);

                    sc=new Scanner(System.in);
                    while(true) {
                        System.out.print(peticionTarifa);
                        costeTarifa = sc.nextFloat();
                        if(costeTarifa<0){
                            String tarifaIncorrecta="Error: La tarifa debe ser mayor a 0€";
                        }else break;
                    }
                    tarifa= new Tarifa(costeTarifa);

                    if(this.conjuntoDatosClientes.cambiarTarifa(nif, tarifa)) System.out.print(exitoOperacion);
                    else System.out.print(fOperacion);

                    sc.close();
                    break;
                case 4://Recuperar los datos de un cliente a partir de su NIF
                    subMenuActual=subMenuActual+"Recuperar datos de un cliente a partir de su NIF---\n";
                    System.out.print(subMenuActual);

                    nif=peticionNif(mensajePeticionNif);

                    Cliente datosRecuperadosCliente=this.conjuntoDatosClientes.recuperarDatos(nif);

                    if(datosRecuperadosCliente!=null) {
                        System.out.print(exitoOperacion);
                        String datosRecuperadosClienteString=datosRecuperadosCliente.toString();
                        //Voy a suponer que, por ahora, los quiere mostrar por pantalla
                        System.out.print(datosRecuperadosClienteString);
                    }
                    else
                        System.out.print(fOperacion);

                    break;
                default://Volver al menu anterior.
                        continuarEnElMenu=false;
                    break;
            }

            if(continuarEnElMenu){
                String continuar="¿Desea continuar realizando operaciones de Gestión de Clientes?";
                String opcionesContinuar="1.-Sí\n0.-No";
                int s=1, n=0;
                if(menuOpciones(continuar,opcionesContinuar,s,n)==n) continuarEnElMenu=false;
            }
        }
    }


    private void menuFacturas(){
        boolean continuarEnElMenu=true;
        String menuActual="\n\n----Menú de Gestión de Facturas----\n\n";
        String opciones= "1.-Dar de alta una factura.\n2.-Recuperar los datos de la factura a partir de su código.\n3.- Recuperar todas las facturas de un cliente a partir de su NIF.\n\n0.- Volver al menu anterior.";
        int minimo=0;
        int maximo=3;

        while(continuarEnElMenu) {
            System.out.print(menuActual);
            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, minimo, maximo)) {

                case 1: //Dar de alta una factura
                    //TODO!!
                    break;
                case 2: //Recuperar los datos de la factura a partir del código de factura
                    //TODO!!
                    break;
                case 3: //Recuperar todas las facturas a partir del NIF
                    //TODO!!
                    break;
                default: //Volver al menu anterior
                    continuarEnElMenu=false;
                    break;

            }

            if(continuarEnElMenu){
                String continuar="¿Desea continuar realizando operaciones de Gestión de Facturas?";
                String opcionesContinuar="1.-Sí\n0.-No";
                int s=1, n=0;
                if(menuOpciones(continuar,opcionesContinuar,s,n)==n) continuarEnElMenu=false;
            }
        }
    }

    private void menuLlamadas(){

        boolean continuarEnElMenu=true;
        String menuActual="\n\n----Menú de Gestión de Llamadas----\n\n";
        String opciones= "1.-Dar de alta un llamada.\n2.-Listar las llamadas de un cliente a partir de su NIF.\n\n0.-Volver al menu anterior.";
        int minimo=0;
        int maximo=2;

        while(continuarEnElMenu) {
            System.out.print(menuActual);
            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, minimo, maximo)) {

                case 1: //Dar de alta una llamada

                    //TODO!!
                    break;
                case 2: //Listar las llamadas de un cliente a partire de su NIF

                    String nif= peticionNif(mensajePeticionNif);

                    List<Llamada> listaLlamadaas=this.conjuntoDatosLlamadas.listarLlamadasCliente(nif);
                    if(listaLlamadaas==null) System.out.print(fOperacion);
                    else{
                        System.out.print(exitoOperacion);

                        //Voy a suponer que se quieren mostrar por pantalla el listado de llamadas
                        for(Llamada llamada : listaLlamadaas){
                            System.out.print(llamada.toString());
                        }
                    }

                    break;
                default: //Volver al menú anterior
                    continuarEnElMenu=false;
                    break;
            }

            if(continuarEnElMenu){
                String continuar="¿Desea continuar realizando operaciones de Gestión de Llamadas?";
                String opcionesContinuar="1.-Sí\n0.-No";
                int s=1, n=0;
                if(menuOpciones(continuar,opcionesContinuar,s,n)==n) continuarEnElMenu=false;
            }
        }
    }

}
