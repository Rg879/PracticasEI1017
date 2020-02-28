package Proyecto;

import Proyecto.Clientes.*;
import Proyecto.Facturas.Factura;
import Proyecto.Facturas.GestionFacturas;
import Proyecto.Llamadas.GestionLlamadas;
import Proyecto.Llamadas.Llamada;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

//El objetivo de esta clase es la que recibirá todos los datos y se encargará de crear los objetos correspondientes y enviárselo a las gestiones correspondiente
public class MenuEnDesarrollo {

    //TODO: ¿Sería esto correcto? ya que, de esta forma, con cada ejecución tendríamos un objeto nuevo (sería mejor que los datos se guardaran en un fichero)
    GestionClientes conjuntoDatosClientes= new GestionClientes(); //"conjunto datos" porque no es una base de datos, pero prácticamente hace su función
    GestionFacturas conjuntoDatosFacturas= new GestionFacturas();
    GestionLlamadas conjuntoDatosLlamadas= new GestionLlamadas();

    final String mensajeEntradaErronea="La opción escogida es incorrecta; porfavor, seleccione una correcta:";
    final String mensajeGenericoEntradaOpciones ="Por favor, introduzca por teclado el número de una de las siguientes opciones:"; //Es importante saludar y, en general, ser educado.
    final String mensajeDatoIncorrecto="El dato introducido es incorrecto, por favor, introduza un valor válido: ";
    final String mensajePeticionNif="Introduzca el NIF: \n"; //Hay muchas opciones que piden el NIF.
    final String exitoOperacion="Operación realizada con exito. \n";
    final String fOperacion="Error : el cliente no existe. \n"; /*Por ahora estaría esta opción*/
    final String strIntroduzca="Introduza ";
    final String peticionCodigo=strIntroduzca+"el codigo: \n";
    final String peticionTelefono=strIntroduzca+"el teléfono: \n";
    final String strElClienteNoExiste="El cliente no existe.\n";

     /*
    *
    *
    MÉTODOS PRINCIPALES
    *
    *
    */

    //El menú principal, desde aquí se llaman al resto de menus de gestión
    public MenuEnDesarrollo() {

        boolean continuarTrabajando=true;
        int min=0;
        int max=3;
        System.out.println("Saludos,");

        String opciones= "1.-Gestión de Clientes\n2.-Gestión de Facturas\n3.-Gestión de Llamadas\n0.-Salir";
        String despedida="Hasta la vista";

        while(continuarTrabajando) {
            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, min, max)) {

                //Queda más limpio así
                case 0: //Salir del programa

                    continuarTrabajando=false;

                    break;
                case 1: //Gestión de clientes.

                    menuClientes();

                    break;
                case 2: //Gestión de facturas.

                    menuFacturas();

                    break;
                case 3: //Gestion de llamadas

                    menuLlamadas();

                    break;

            }

            if(continuarTrabajando) continuarTrabajando=continuarOperaciones();
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

                case 0://Volver al menu anterior.
                    continuarEnElMenu=false;
                    break;

                case 1: // Dar de alta cliente
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
                    //TODO: ¿Hay que introducir la fecha manualmente, o suponer que és el día que se introducen los datos?
                    String peticionFechaDeAlta="Introduzca la fecha de alta: \n";
                    Date fechaDeAlta;


                    sc= new Scanner(System.in);

                    System.out.print(peticionNombre);
                    nombre=sc.nextLine();

                    nif= peticionNif(mensajePeticionNif);

                    System.out.print(peticionCodPostal);
                    codPostal=sc.nextInt();
                    sc.nextLine();//Todo [3]: ver si hay alguna alternativa a hacer esta chapuza.

                    System.out.print(peticionProvincia);
                    provincia=sc.nextLine();

                    System.out.print(peticionPoblacion);
                    poblacion=sc.nextLine();

                    //Creación de la dirección
                    Direccion direccionCliente= new Direccion(codPostal, provincia, poblacion);

                    System.out.print(peticionCorreo);
                    correo=sc.nextLine();

                    //Si no hay que poner la fecha actual como fecha de alta:
                    fechaDeAlta= peticionFechaYHora(false);

                    while(true) {
                        System.out.print(peticionTarifa);
                        costeTarifa = sc.nextFloat();
                        sc.nextLine(); //Todo [3]: ver si hay alguna alternativa a hacer esta chapuza.
                        if(costeTarifa<0){
                            String tarifaIncorrecta="Error: La tarifa debe ser mayor a 0€\n";
                            System.out.print(tarifaIncorrecta);
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
                            apellidos=sc.nextLine();
                            nuevoCliente=new Particular(nombre, nif, direccionCliente, correo, fechaDeAlta, tarifa, apellidos);
                            break;
                    }

                    //Donde de verdad se añade al cliente:
                    conjuntoDatosClientes.darDeAltaCliente(nuevoCliente);
                    System.out.print(exitoOperacion);

                    sc.close();
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

                    if(nif!=null) {

                        sc = new Scanner(System.in);
                        while (true) {
                            System.out.print(peticionTarifa);
                            costeTarifa = sc.nextFloat();
                            sc.nextLine();
                            if (costeTarifa < 0) {
                                String tarifaIncorrecta = "Error: La tarifa debe ser mayor a 0€\n";
                                System.out.print(tarifaIncorrecta);
                            } else break;
                        }
                        sc.close();
                        tarifa = new Tarifa(costeTarifa);

                        if (this.conjuntoDatosClientes.cambiarTarifa(nif, tarifa)) System.out.print(exitoOperacion);
                        else System.out.print(fOperacion);
                    }
                    break;
                case 4://Recuperar los datos de un cliente a partir de su NIF
                    subMenuActual=subMenuActual+"Recuperar datos de un cliente a partir de su NIF---\n";
                    System.out.print(subMenuActual);

                    nif=comprobacionNif(this.conjuntoDatosClientes);

                    if(nif!=null) {
                        Cliente datosRecuperadosCliente = this.conjuntoDatosClientes.recuperarDatos(nif);

                        if (datosRecuperadosCliente != null) {
                            System.out.print(exitoOperacion);
                            String datosRecuperadosClienteString = datosRecuperadosCliente.toString();
                            //Voy a suponer que, por ahora, los quiere mostrar por pantalla
                            System.out.print(datosRecuperadosClienteString);

                        } else System.out.print(fOperacion);
                    }
                    break;
            }
            if(continuarEnElMenu) continuarEnElMenu=continuarOperaciones();

        }
    }


    private void menuFacturas(){
        boolean continuarEnElMenu=true;
        String menuActual="\n\n----Menú de Gestión de Facturas----\n\n";
        String opciones= "1.-Dar de alta una factura.\n2.-Recuperar los datos de la factura a partir de su código.\n3.- Recuperar todas las facturas de un cliente a partir de su NIF.\n\n0.- Volver al menu anterior.";
        int minimo=0;
        int maximo=3;
        String nif;

        while(continuarEnElMenu) {
            System.out.print(menuActual);
            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, minimo, maximo)) {

                case 0: //Volver al menu anterior
                    continuarEnElMenu = false;
                    break;
                case 1: //Dar de alta una factura

                    //Comprobar que el cliente existe
                    nif = comprobacionNif(this.conjuntoDatosClientes);

                    //Si el cliente existe
                    if (nif != null) {
                        int codigoUnico = this.conjuntoDatosFacturas.proximoCodigoFacturaParaAsignar();
                        //Si el cliente existe:
                        //Obtener su tarifa de los datos del cliente:
                        Tarifa tarifa = this.conjuntoDatosClientes.recuperarDatos(nif).getTarifa();
                        //pedir el resto de datos:
                        Date inicioPeriodo = peticionFechaYHora(false);
                        //Debe uno asegurarse de que no sea la gente despistada (vamos a pensar bien de la gente) y meta sin querer los datos incorrectamente:
                        Date finPeriodo;
                        while (true) {
                            finPeriodo = peticionFechaYHora(false);
                            if (finPeriodo.compareTo(inicioPeriodo) < 0) {
                                System.out.print("Error: la fecha introducida debe ser posterior a " + inicioPeriodo.toString());
                            } else break;
                        }
                        Date fechaEmision = peticionFechaYHora(false);

                        //Una vez obtenidos los datos, tiene que buscar en las llamadas entre en el inicio de Periodo y de fin de periodo los minutos llamados y calcular el importe de factura.
                        float importeFactura = 0;

                        for (Llamada llamada : this.conjuntoDatosLlamadas.recuperarDatos(nif)) {
                            importeFactura += tarifa.getCoste() * llamada.getDuracionMinutos();
                        }

                        this.conjuntoDatosFacturas.darDeAlta(nif, new Factura(codigoUnico, tarifa, inicioPeriodo, finPeriodo, fechaEmision, importeFactura));
                    }
                    break;
                case 2: //Recuperar los datos de la factura a partir del código de factura

                    Scanner sc = new Scanner(System.in);
                    System.out.print(peticionCodigo);
                    int codigo = sc.nextInt();
                    sc.close();

                    Factura facturaRecuperada = this.conjuntoDatosFacturas.recuperarFactura(codigo);

                    //Si, por alguna cosa (como, por ejemplo, se borrara el nif tras comprobar que existe, pero antes de obtener la factura):
                    if (facturaRecuperada == null) {
                        System.out.print(fOperacion + "No existe factura con ese código.\n");
                    } else {
                        System.out.print(exitoOperacion);
                        //voy a suponer que se quiere mostrar por pantalla:
                        System.out.print(facturaRecuperada.toString());
                    }

                    break;
                case 3: //Recuperar todas las facturas a partir del NIF

                    //Que tenga almenos una factura = condición necesaria para recuperarla
                    nif = comprobacionNif(this.conjuntoDatosFacturas);

                    List<Factura> listaFacturasRecuperada = this.conjuntoDatosFacturas.recuperarDatos(nif);

                    //Si, por alguna cosa (como, por ejemplo, se borrara el nif tras comprobar que existe, pero antes de obtener la factura):
                    if (listaFacturasRecuperada == null) System.out.print(fOperacion);
                    else {
                        System.out.print(exitoOperacion);
                        //voy a suponer que se quiere mostrar por pantalla:
                        for (Factura factura : listaFacturasRecuperada) {
                            System.out.print(factura.toString());
                        }
                    }
                    break;
            }

            if (continuarEnElMenu) continuarEnElMenu = continuarOperaciones();

        }
    }

    private void menuLlamadas(){

        boolean continuarEnElMenu=true;
        String menuActual="\n\n----Menú de Gestión de Llamadas----\n\n";
        String opciones= "1.-Dar de alta un llamada.\n2.-Listar las llamadas de un cliente a partir de su NIF.\n\n0.-Volver al menu anterior.";
        int minimo=0;
        int maximo=2;
        String nif;

        while(continuarEnElMenu) {
            System.out.print(menuActual);
            switch (menuOpciones(mensajeGenericoEntradaOpciones, opciones, minimo, maximo)) {
                case 1: //Dar de alta una llamada


                    //para dar de alta la llamada, debe existir el cliente en la lista de clientes
                    nif=comprobacionNif(this.conjuntoDatosClientes);

                    if(nif!=null) {
                        //Petición del teléfono:
                        long telefono = entradaEnteroCorrecta(peticionTelefono, 0, Long.MAX_VALUE);

                        //Petición de la Fecha de la llamada
                        Date fechaLlamada = peticionFechaYHora(true);

                        //Petición de la fecha de la finalización de la llamada.
                        Date fechaFinLlamada= peticionFechaYHora(true);

                        this.conjuntoDatosLlamadas.darDeAlta(nif, new Llamada(telefono, fechaLlamada,fechaFinLlamada));
                    }
                    break;
                case 2: //Listar las llamadas de un cliente a partire de su NIF

                    //Para listar las llamadas de un cliente, deben existir llamadas (si no existe cliente ==> no existen llamadas)
                    nif=comprobacionNif(this.conjuntoDatosLlamadas); //TODO:Mirar, porque la salida por pantalla puede no ser la deseada.
                    if(nif!=null) {

                        List<Llamada> listaLlamadaas = this.conjuntoDatosLlamadas.recuperarDatos(nif);
                        if (listaLlamadaas == null) System.out.print(fOperacion);
                        else {
                            System.out.print(exitoOperacion);

                            //Voy a suponer que se quieren mostrar por pantalla el listado de llamadas
                            for (Llamada llamada : listaLlamadaas) {
                                System.out.print(llamada.toString());
                            }
                        }
                    }
                    break;
                case 0: //Volver al menú anterior
                    continuarEnElMenu=false;
                    break;
            }

            if(continuarEnElMenu) continuarEnElMenu=continuarOperaciones();

        }
    }

    /*
    *
    *
    MÉTODOS AUXILIARES
    *
    *
    */

    //TODO: Mirar porqué no permite volver a coger nuevos datos por teclado.
    //Petición "eterna" de una entrada; el fin de esta "eternidad" llega tecleando una de las opciones correctas.
    private int menuOpciones(String mensajeInicial, String opciones, int min, int max){

        int opcion;
        System.out.println(mensajeInicial);

        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println(opciones);
            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine();
                if (max >= opcion && opcion >= min)
                    break;
                else System.out.println(mensajeEntradaErronea);

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
        String nif=sc.nextLine();
        sc.close();
        return nif;
    }

    //método genérico que comprueba en la tabla correcta si está el nif (en cuyo caso, lo devuelve)
    private String comprobacionNif (Gestion tipoDeGestion){

        boolean seguirBuscando=true;
        String nif=null;
        while(seguirBuscando){
            nif = peticionNif(mensajePeticionNif);

            //Si no existe el cliente, no podrá recuperar los datos ==> devuelve null
            if(tipoDeGestion.contieneCliente(nif)) nif=null;

            if(nif==null){//nif no encontrado en ningún menú
                String op= "¿Qué desea hacer?\n1.- Volver introducir NIF\n0.- Salir de gestión del menu de gestión actual\n"; //TODO si se dan más casos, elegir un nombre mejor, subirlo arriba para que se pueda usar donde sea y ponerlo como "final"
                if(menuOpciones(strElClienteNoExiste, op, 0,1)==0) seguirBuscando=false;
                //Si no quiere volver a buscar el nif, saldrá del bucle, y como se ha reasignado a null, devolverá null.
            }
        }
        return nif;
    }

    //Puesto que hay bastantes peticiones de fecha; método de petición genérico que, de paso, fuerce la introducción de los datos válidos.
    //Puesto que el tipo Date también admite horas, pero no siempre queremos meter una fecha nueva he realizado esta implementación.
    private Date peticionFechaYHora(boolean horaNecesaria){

        int dia, mes, anyo;
        int min, max;
        Date fechaFinal;
        final String strIntroduzca="Introduza ";
        final String peticionDia=strIntroduzca+"el día: \n";
        final String peticionMes=strIntroduzca+"el mes: \n";
        final String peticionAnyo =strIntroduzca+"el año: \n";
        final String peticionHora=strIntroduzca+"la hora: \n";
        final String peticionMinuto=strIntroduzca+"el minuto: \n";
        final String peticionSegundo=strIntroduzca+"los segundos: \n";

        //petición año
        min = 1854; //No tiene sentido que exista una compañia telefónica antes de la invención del teléfono
        max = Integer.MAX_VALUE; //Si no me equivoco, el valor máximo de int.
        anyo = entradaEnteroCorrecta(peticionAnyo, min, max);

        //petición mes
        min = 1;
        max = 12;
        mes = entradaEnteroCorrecta(peticionMes, min, max);
        //petición día
        switch (mes) {
            case 2: //Febrero
                max = 28;
                if (anyo % 4 == 0 && anyo % 100 != 0 && anyo % 400 == 0) //bisiesto
                    max = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11: //Abril, Junio, Septiembre y Noviembre
                max = 30;
                break;
            default:
                max = 31;
                break;
        }
        dia = entradaEnteroCorrecta(peticionDia, min, max);

        fechaFinal=new Date(anyo, mes, dia);

        //Si la hora es necesaria, se añade también la hora
        if(horaNecesaria){
            int hora=entradaEnteroCorrecta(peticionHora,0,24);
            int minuto=entradaEnteroCorrecta(peticionMinuto,0,60);
            int segundo=entradaEnteroCorrecta(peticionSegundo,0,60);
            fechaFinal= new Date(anyo-1900,mes,dia,hora,minuto,segundo); //la implementación de Date es rara.
        }

        return fechaFinal;
    }


    //método genérico para comprobar que el dato que se le pasa por teclado es correcto.
    private int entradaEnteroCorrecta(String mensajePeticion, int min, long max) {

        int dato;
        System.out.print(mensajePeticion);
        while (true) {
            Scanner sc = new Scanner(System.in);
            dato = sc.nextInt();
            sc.nextLine();
            if (min <= dato && dato <= max) {
                break;
            }else System.out.format(mensajeDatoIncorrecto+"valor mínimo= %d, valor máximo: %d \n", min, max);
        }
        return dato;
    }


    private boolean continuarOperaciones (){
        String continuar="¿Desea continuar realizando operaciones de Gestión de Clientes?";
        String opcionesContinuar="1.-Sí\n0.-No";
        if(menuOpciones(continuar,opcionesContinuar,0,1)==0) return false;
        return true;
    }


    /*TODO [En desarrollo] (2): Hacer que la clase tenga una devolución genérica
    //Metodo genérico para obtener los datos de un cliente a partir de su NIF
    private <T> obtenerDatosAPartirNif(Gestion tipoGestion){

        String nif=comprobacionNif(tipoGestion);
        if(nif!=null) {

            <T> datosARecuperar = tipoGestion.recuperarDatos(nif);
            //por si ocurre un caso extraño, como que se borren los datos entre obtener el nif y recuperar los datos:
            if (datosArecuperar == null) System.out.print(fOperacion);
            else {
                System.out.print(exitoOperacion);
                }
            }
        }
        return datosARecuperar
    }
    */


}
