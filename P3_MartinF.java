/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3_martinf;

import java.util.Scanner;

public class P3_MartinF {

    public static final String G_HO = "Noi";
    public static final String G_DO = "Noia";
    public static final String G_NC = " -   ";
    public static final String P_GEN = "General";
    public static final String P_EDU = "Educació";
    public static final String P_EMP = "Empresa";
    public static final String P_PREM = "Premsa";
//Declaramos los mins y maxs de cada opción
    public static final int MAX_CODI = 2100;
    public static final int MIN_CODI = 100;
    public static final int MAX_GEN = 3;
    public static final int MIN_GEN = 1;
    public static final int MAX_TIP = 3;
    public static final int MIN_TIP = 0;
    public static final int MAX_DONA = 1;
    public static final int MIN_DONA = 0;
    public static final int MAX_ID = 27;
    public static final int MIN_ID = 4;
    public static final int MAX_EXP = 30;
    public static final int MIN_EXP = 0;
    public static final int INTENTOS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sessio = " ";
        String nomGenere = " ";
        String nomTipus = "";

        int i = 0;
        int compteParticipants = 0;

        boolean repetirBucle = true;
        boolean mensajeIntentos = true;
        boolean esCorrecto = true;
        boolean ordenar = false;

        int arrCodi[] = new int[10];
        int arrGenero[] = new int[10];
        int arrTipus[] = new int[10];
        int arrSessio[] = new int[10];
        int arrIdSessio[] = new int[10];
        int arrExp[] = new int[10];

        while (repetirBucle) { //Bucle principal. No se podrá salir de él a menos que sea voluntariamente. O mediantes los comandos o parando el programa manualmente.
            i = 0;
            System.out.println("Entrada dades d’usuari ------------------");
            while (i < 3) { //bucle1
                System.out.println("Introdueix el codi");
                esCorrecto = scanner.hasNextInt();
                //Utilizaremos este booleano cada vez que haya que introducir datos
                //para saber si el usuario ha puesto algo que no sea un número
                if (esCorrecto) {
                    int codi = scanner.nextInt();
                    scanner.nextLine();

                    if ((codi >= MIN_CODI) && (codi <= MAX_CODI)) { //Si llegamos aquí es que los datos del codigo son correctos
                        arrCodi[compteParticipants] = codi;
                        i = 0;
                        while (i < 3) { //bUCLE 2
                            System.out.println("És noia (1), noi(2), o prefereix no respondre(3)?");
                            esCorrecto = scanner.hasNextInt();
                            if (esCorrecto) {
                                int genere = scanner.nextInt();
                                scanner.nextLine();
                                if ((genere >= MIN_GEN) && (genere <= MAX_GEN)) { //Si llegamos aquí es que los datos de género son correctos
                                    arrGenero[compteParticipants] = genere;
                                    i = 0;
                                    while (i < 3) { //BUCLE 3
                                        System.out.println("Quin tipus de participant es?\n General(0) \n Educacio(1) \n Empresa(2) \n Premsa (3)");
                                        esCorrecto = scanner.hasNextInt();
                                        if (esCorrecto) {
                                            int tipus = scanner.nextInt();
                                            scanner.nextLine();
                                            if ((tipus >= MIN_TIP) && (tipus <= MAX_TIP)) {//Si llegamos aquí es que los datos del tipo son correctos
                                                arrTipus[compteParticipants] = tipus;
                                                i = 0;
                                                while (i < 3) { //BUCLE 4
                                                    System.out.println("Dona sessió (1)? (0 si no en dona.)");
                                                    esCorrecto = scanner.hasNextInt();
                                                    if (esCorrecto) {
                                                        int donaSessio = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (donaSessio >= MIN_DONA && donaSessio <= MAX_DONA) { //Si llegamos aquí es que los datos del donaSessio son correctos
                                                            arrSessio[compteParticipants] = donaSessio;
                                                            i = 0;

                                                            if (donaSessio == 1) { //Esto solo se aplicará si da sesión. Si no, el codigo sigue a la experiencia.
                                                                boolean idCorrecte = false;
                                                                while (i < 3 && !idCorrecte) { //BUCLE ESPECIAL
                                                                    System.out.println("Entra el id de la sessió (4-27)");
                                                                    esCorrecto = scanner.hasNextInt();
                                                                    if (esCorrecto) {
                                                                        int idSessio = scanner.nextInt();
                                                                        scanner.nextLine();
                                                                        if ((idSessio < MIN_ID) || (idSessio > MAX_ID)) { //Control de error para el id.
                                                                            System.out.println("Num incorrecte. ");
                                                                            i++;
                                                                        } else {
                                                                            arrIdSessio[compteParticipants] = idSessio;

                                                                            i = 0;
                                                                            idCorrecte = true;
                                                                        }
                                                                    } else {
                                                                        System.out.println("Dada incorrecta. ");
                                                                        i++;
                                                                    }
                                                                }//FIN BUCLE ESPECIAL

                                                            }
                                                            while (i < 3) { //BUCLE 5
                                                                System.out.println("Anys d'experiencia?");
                                                                esCorrecto = scanner.hasNextInt();
                                                                if (esCorrecto) {
                                                                    int experiencia = scanner.nextInt();
                                                                    scanner.nextLine();
                                                                    if ((experiencia < MIN_EXP) || (experiencia > MAX_EXP)) { //Control de error para la experiencia, sí es correcto.
                                                                        System.out.println("Num incorrecte. ");
                                                                        i++;
                                                                    } else {      //Llegamos aquí los datos de exp eran correcto. Así que continuamos para mostrar los datos.
                                                                        arrExp[compteParticipants] = experiencia;
                                                                        i = 3;//Pongo esto porque si no nunca saldría de los bucles.

                                                                        //Como los arrays están colocados de forma que se rellenan según se introduce 
                                                                        // y la cuenta de participantes solo sube una vez están todos completos. En caso de que se equivocase 3 veces
                                                                        //el usuario no llegaría aquí, por lo que la posición del array se sobreescribiría
                                                                        
                                                                        compteParticipants++;
                                                                        mensajeIntentos = false;

                                                                    }
                                                                } else {
                                                                    System.out.println("Dada incorrecta.");
                                                                    scanner.nextLine();
                                                                    i++;
                                                                }

                                                            }
                                                        }//BUCLE 5
                                                        else {
                                                            System.out.println("Num incorrecte.");
                                                            i++;
                                                        }

                                                    } else {
                                                        System.out.println("Dada incorrecta.");
                                                        scanner.nextLine();
                                                        i++;
                                                    }
                                                }//Fin bucle 4

                                            } else {
                                                System.out.println("Num incorrecte.");
                                                i++;
                                            }

                                        } else {
                                            System.out.println("Dada incorrecta.");
                                            scanner.nextLine();
                                            i++;
                                        }
                                    } //Fin bucle 3
                                } else {
                                    System.out.println("Num incorrecte.");
                                    i++;
                                }

                            } else {
                                System.out.println("Dada incorrecta.");
                                scanner.nextLine();
                                i++;
                            }

                        }//fIN bUCLE 2
                    } else {
                        System.out.println("Num incorrecte. ");
                        i++;
                    }
                } else {
                    System.out.println("Dada incorrecta. ");
                    scanner.nextLine();
                    i++;
                }

            }//finbucle1. Aquí vamos a llegar solo si i>3. El mensajeIntentos solo puede ser f si has llegado correctamente hasta el final.
            if (mensajeIntentos == true) {
                System.out.println("Superat número de intents.");
            } else {
                mensajeIntentos = true;
            }
            do { //Se haga correcto o se falle el número de intentos. Siempre se llegará aquí y se podrá decidir si añadir otra participante.
                System.out.println("Vols introduir mes dades? Sí(1) No(0)");
                esCorrecto = scanner.hasNextInt();
                if (esCorrecto) {
                    int repetir = scanner.nextInt();
                    scanner.nextLine();

                    switch (repetir) { //El ejercicio no indicaba que ocurre si se falla aquí. 
                        //Así que he decidido que este bucle sea infinito hasta que se introduzcan los datos adecuados.
                        //De otra manera tendría que volver a introducir el participante a pesar de haber escrito bien los datos.
                        case 1:
                            break;

                        case 0:

                            repetirBucle = false;

                            break;

                        default:
                            System.out.println("Num incorrecte.");
                            esCorrecto = false;
                            break;
                    }
                } else {
                    System.out.println("Dada incorrecta.");
                    scanner.nextLine();

                }
            } while (!esCorrecto);

        }
        
        //Llegaremos aquí una vez se diga que no se quieren introducir más participantes.
        
        //Lo primero que haremos es preguntar si se van a querer ordenar. 
        //Hacemos un bucle por si hay un error. Para que no se salga del programa y tengamos que volver a introducir todos los datos.

            boolean preguntaOrdenar = false;
            while (!preguntaOrdenar) {
                System.out.println("Vols ordenar per experiencia?");
                esCorrecto = scanner.hasNextInt();

                if (esCorrecto) {
                    int resposta = scanner.nextInt();
                    scanner.nextLine();
                    if (resposta == 1) {
                        ordenar = true;
                        preguntaOrdenar = true;
                    }
                    if (resposta == 0) {
                        preguntaOrdenar = true;
                    }
                }
            }

            //Mostramos los resultados tal cual los ha introducido el usuario.
            //Mostrará el número exacto gracias al contador.
            
            System.out.println("");
            System.out.println("Codi" + "  " + "Genere" + "  " + "Tipus" + "  " + "Sessio" + "  " + "Experiencia");
            for (i = 0; i < compteParticipants; i++) {

                sessio = "No";

                if (arrSessio[i] == 1) {
                    sessio = "Si:" + arrIdSessio[i];
                }

                switch (arrTipus[i]) {
                    case 0:
                        nomTipus = P_GEN;
                        break;
                    case 1:
                        nomTipus = P_EDU;
                        break;
                    case 2:
                        nomTipus = P_EMP;
                        break;
                    case 3:
                        nomTipus = P_PREM;
                    default:
                        break;
                }
                //Pongo el resultado de los datos en este switch por la diferencia de caracteres entre
                //los casos 1 y 2 y el 3, que es bastante más largo. 
                // Tambien se podría hacer un if aparte, pero de esta forma ahorro código y evito redundancias.

                switch (arrGenero[i]) {
                    case 1:
                        nomGenere = G_DO;
                        break;
                    case 2:
                        nomGenere = G_HO;
                        break;
                    case 3:
                        nomGenere = G_NC;
                        break;
                    default:
                        break;

                }
                System.out.println(arrCodi[i] + "  " + nomGenere + "   " + nomTipus + "  " + sessio + "     " + arrExp[i]);

            }
            System.out.println(" ");
            System.out.println("Has introduit un total de " + compteParticipants + " participants.");
            
            
//A este bucle solo llegamos si se dijo que se quería ordenar.

            if (ordenar) {
                int cambio = 0;
                       
                for (i = 0; i < compteParticipants-1; i++) {
                    for (int j = i + 1; j < compteParticipants; j++) {
                        //Primero ordenará todos los arrays solo teniendo en cuenta la experiencia.                        
                        if (arrExp[i] > arrExp[j]) {
                            cambio = arrCodi[i];
                            arrCodi[i] = arrCodi[j];
                            arrCodi[j] = cambio;
                            
                              cambio = arrGenero[i];
                            arrGenero[i] = arrGenero[j];
                            arrGenero[j] = cambio;
                            
                            cambio = arrTipus[i];
                            arrTipus[i] = arrTipus[j];
                            arrTipus[j] = cambio;
                            
                              cambio = arrSessio[i];
                           arrSessio[i] = arrSessio[j];
                            arrSessio[j] = cambio;
                            
                               cambio = arrIdSessio[i];
                           arrIdSessio[i] = arrIdSessio[j];
                            arrIdSessio[j] = cambio;
                            
                             cambio = arrExp[i];
                           arrExp[i] = arrExp[j];
                            arrExp[j] = cambio;

                        }
                    }
                }

                //Muestra los resultados con exactamente el mismo bucle que los mostraba sin ordenar.
                    
                  System.out.println("");
                  System.out.println("Participants ordenats per experiencia");
            System.out.println("Codi" + "  " + "Genere" + "  " + "Tipus" + "  " + "Sessio" + "  " + "Experiencia");
            for (i = 0; i < compteParticipants; i++) {

                sessio = "No";

                if (arrSessio[i] == 1) {
                    sessio = "Si:" + arrIdSessio[i];
                }

                switch (arrTipus[i]) {
                    case 0:
                        nomTipus = P_GEN;
                        break;
                    case 1:
                        nomTipus = P_EDU;
                        break;
                    case 2:
                        nomTipus = P_EMP;
                        break;
                    case 3:
                        nomTipus = P_PREM;
                    default:
                        break;
                }
   
                switch (arrGenero[i]) {
                    case 1:
                        nomGenere = G_DO;
                        break;
                    case 2:
                        nomGenere = G_HO;
                        break;
                    case 3:
                        nomGenere = G_NC;
                        break;
                    default:
                        break;

                }
                System.out.println(arrCodi[i] + "  " + nomGenere + "   " + nomTipus + "  " + sessio + "     " + arrExp[i]);

            }
                
            }
    }
}
