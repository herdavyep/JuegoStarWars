package com.heri.ProyectoJuego;

import java.util.Scanner;

/**
 * Created by heriberto on 11/03/17.
 */
public class RunJuego {

    public static void main(String[] args) {

        boolean gameOver = true;
        int opcion = 0;
        int brigada,brigada2;

        Scanner sc = new Scanner(System.in);
        Nave n = new Nave();

        System.out.println("\nS T A R   W A R S\n");
        System.out.println("Existen 3 tipos de naves con las cuales solo se puede atacar una vez," +
                " puede volver a atacar cuando los demas de su grupo ya lo allan hecho, se puede efender las veces que quiera\n");

        AcorasadoEstelar AE1 = new AcorasadoEstelar(1);
        Ejecutor Ej1 = new Ejecutor(1);
        CazaEstelar CE1 = new CazaEstelar(1);

        AcorasadoEstelar AE2 = new AcorasadoEstelar(2);
        Ejecutor Ej2 = new Ejecutor(2);
        CazaEstelar CE2 = new CazaEstelar(2);

        while (gameOver){

            if (n.jugado){

                System.out.println("\nJugador 1");
                n.Menu();

                opcion = sc.nextInt();
                switch (opcion){

                    case 1:
                        AE1.getNave();
                        Ej1.getNave();
                        CE1.getNave();
                        break;
                    case 2:

                        if (AE1.ataco && Ej1.ataco && CE1.ataco){

                            AE1.ataco = false;
                            Ej1.ataco = false;
                            CE1.ataco = false;

                            System.out.println("tu tropa ya esta lista para volver a atacar");

                        }

                        if (AE1.defendio){

                            System.out.println("Escudo protector desactivado");
                        }

                        AE1.defendio = false;
                        Ej1.defendio = false;
                        CE1.defendio = false;

                        n.ataco = false;

                        while (!n.ataco){

                            n.MenuAtacarA();
                            opcion = sc.nextInt();
                            switch (opcion){

                                case 1:

                                    if (!AE1.ataco){

                                        if (AE2.defendio){
                                            AE2.Daños(2);
                                            n.AtaqueExitosoEscudo(2);

                                        }else{

                                            AE2.Daños(7);
                                            n.AtaqueExitoso(7);
                                        }

                                        n.ataco = true;
                                    }else{

                                        System.out.println("Ya ataco debe esperar que ataquen los demas");
                                        n.ataco = false;

                                    }

                                    AE1.ataco = true;

                                    break;

                                case 2:

                                    n.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){
                                        if (!Ej1.ataco){

                                            if (Ej2.defendio){

                                                Ej2.Daños(2);
                                                n.AtaqueExitosoEscudo(2);

                                            }else{

                                                Ej2.Daños(5);
                                                n.AtaqueExitoso(5);

                                            }
                                            n.ataco = true;

                                        }else{

                                            System.out.println("Ya ataco debe esperar que ataquen los demas");
                                            n.ataco = false;
                                        }

                                        Ej1.ataco = true;


                                    }else if(opcion == 2){
                                        if (!CE1.ataco){

                                            if (Ej2.defendio){

                                                Ej2.Daños(0);
                                                n.AtaqueExitosoEscudo(0);

                                            }else {

                                                Ej2.Daños(3);
                                                n.AtaqueExitoso(3);

                                            }
                                            n.ataco = true;

                                        }else{

                                            System.out.println("Ya ataco debe esperar que ataquen los demas");
                                            n.ataco = false;
                                        }

                                        CE1.ataco = true;
                                    }else if (opcion != 1 && opcion != 2){
                                        System.out.println("Opcion no valiida");
                                        n.ataco = false;
                                    }
                                    break;

                                case 3:

                                    n.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){
                                        if (!Ej1.ataco){

                                            CE2.Daños(5);
                                            System.out.println("El ataque supero la defensa y el Caza estelar fue destruido");
                                            n.ataco = true;

                                        }else {

                                            System.out.println("Ya ataco debe esperar que ataquen los demas");
                                            n.ataco = false;
                                        }

                                        Ej1.ataco = true;

                                    }else if (opcion == 2){
                                        if (!CE1.ataco){
                                            if (CE2.defendio){

                                                CE2.Daños(2);
                                                n.AtaqueExitosoEscudo(2);
                                            }else {

                                                CE2.Daños(3);
                                                System.out.println("El ataque destruyo el Caza Estelar");
                                            }
                                            n.ataco = true;

                                        }else {

                                            System.out.println("Ya ataco debe esperar que ataquen los demas");
                                            n.ataco = false;
                                        }

                                        CE1.ataco = true;

                                    }else if (opcion != 1 && opcion != 2){

                                        System.out.println("Opcion no valiida");
                                        n.ataco = false;
                                    }
                                    break;

                                default:
                                    System.out.println("Opcion no valida");

                            }

                        }


                        n.jugado = false;
                        break;
                    case 3:

                        AE1.defendio = true;
                        Ej1.defendio = true;
                        CE1.defendio = true;

                        System.out.println("Escudo protector activado");

                        n.jugado = false;
                        break;
                    default:
                        System.out.println("opcion no valida");
                }
            }else {

                if (Ej2.isDestruida(Ej2)){

                    Ej2.ataco = true;
                }

                if (CE2.isDestruida(CE2)){

                    CE2.ataco = true;
                }

                System.out.println("\nJugador 2");
                n.Menu();

                opcion = sc.nextInt();
                switch (opcion){

                    case 1:
                        AE2.getNave();
                        Ej2.getNave();
                        CE2.getNave();
                        break;
                    case 2:


                        if (AE2.ataco && Ej2.ataco && CE2.ataco){

                            AE2.ataco = false;
                            Ej2.ataco = false;
                            CE2.ataco = false;

                            System.out.println("tu tropa ya esta lista para volver a atacar");

                        }

                        if (AE2.defendio){

                            System.out.println("Escudo protector desactivado");
                        }

                        AE2.defendio = false;
                        Ej2.defendio = false;
                        CE2.defendio = false;

                        n.ataco = false;

                        while (!n.ataco){

                            n.MenuAtacarA();
                            opcion = sc.nextInt();
                            switch (opcion){

                                case 1:

                                    if (!AE2.ataco){

                                        if (AE1.defendio){
                                            AE1.Daños(2);
                                            n.AtaqueExitosoEscudo(2);

                                        }else{

                                            AE1.Daños(7);
                                            n.AtaqueExitoso(7);
                                        }

                                        n.ataco = true;
                                    }else{

                                        System.out.println("Ya ataco debe esperar que ataquen los demas");
                                        n.ataco = false;

                                    }

                                    AE2.ataco = true;

                                    break;

                                case 2://atacar ejecutor

                                    n.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){
                                        if(Ej2.getVida() <= 0){

                                            System.out.println("Una nave destruida no puede atacar");
                                            n.ataco = false;
                                            break;
                                        }else {

                                            if (!Ej2.ataco){
                                                if(Ej1.getVida() <= 0){

                                                    System.out.println("\nNo se puede atacar una nave destruida");
                                                    n.ataco = false;
                                                    break;

                                                }else{

                                                    if (Ej1.defendio){

                                                        Ej1.Daños(2);
                                                        n.AtaqueExitosoEscudo(2);

                                                    }else{

                                                        Ej1.Daños(5);
                                                        n.AtaqueExitoso(5);

                                                    }
                                                }

                                                n.ataco = true;

                                            }else{

                                                System.out.println("Ya ataco debe esperar que ataquen los demas");
                                                n.ataco = false;
                                            }

                                        }

                                        Ej2.ataco = true;


                                    }else if(opcion == 2){
                                        if(CE2.getVida() <= 0){

                                            System.out.println("Una nave destruida no puede atacar");
                                            n.ataco = false;
                                            break;
                                        }else {

                                            if (!CE2.ataco){
                                                if(Ej1.getVida() <= 0){

                                                    System.out.println("\nNo se puede atacar una nave destruida");
                                                    n.ataco = false;
                                                    break;

                                                }else {

                                                    if (Ej1.defendio){

                                                        Ej1.Daños(0);
                                                        n.AtaqueExitosoEscudo(0);

                                                    }else {

                                                        Ej1.Daños(3);
                                                        n.AtaqueExitoso(3);

                                                    }
                                                }

                                                n.ataco = true;

                                            }else{

                                                System.out.println("Ya ataco debe esperar que ataquen los demas");
                                                n.ataco = false;
                                            }

                                        }

                                        CE2.ataco = true;
                                    }else if (opcion != 1 && opcion != 2){
                                        System.out.println("Opcion no valiida");
                                        n.ataco = false;
                                    }
                                    break;

                                case 3://atacar Caza estelar

                                    n.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){
                                        if(Ej2.getVida() <= 0){

                                            System.out.println("Una nave destruida no puede atacar");
                                            n.ataco = false;
                                            break;
                                        }else {

                                            if (!Ej2.ataco){
                                                if (CE1.getVida() <= 0){

                                                    System.out.println("\nNo se puede atacar una nave destruida");
                                                    n.ataco = false;
                                                    break;

                                                }else {

                                                    CE1.Daños(5);
                                                    System.out.println("El ataque supero la defensa y el Caza estelar fue destruido");
                                                    n.ataco = true;
                                                }

                                            }else {

                                                System.out.println("Ya ataco debe esperar que ataquen los demas");
                                                n.ataco = false;
                                            }
                                        }

                                        Ej2.ataco = true;

                                    }else if (opcion == 2){
                                        if(CE2.getVida() <= 0){

                                            System.out.println("Una nave destruida no puede atacar");
                                            n.ataco = false;
                                            break;

                                        }else {

                                            if (!CE2.ataco){
                                                if (CE1.getVida() <= 0){

                                                    System.out.println("\nNo se puede atacar una nave destruida");
                                                    n.ataco = false;
                                                    break;

                                                }else {

                                                    if (CE1.defendio){

                                                        CE1.Daños(2);
                                                        n.AtaqueExitosoEscudo(2);
                                                    }else {

                                                        CE1.Daños(3);
                                                        System.out.println("El ataque destruyo el Caza Estelar");
                                                    }
                                                }

                                                n.ataco = true;

                                            }else {

                                                System.out.println("Ya ataco debe esperar que ataquen los demas");
                                                n.ataco = false;
                                            }
                                        }

                                        CE2.ataco = true;

                                    }else if (opcion != 1 && opcion != 2){

                                        System.out.println("Opcion no valiida");
                                        n.ataco = false;
                                    }
                                    break;

                                default:
                                    System.out.println("Opcion no valida");

                            }

                        }

                        n.jugado = true;
                        break;
                    case 3:

                        AE2.defendio = true;
                        Ej2.defendio = true;
                        CE2.defendio = true;

                        System.out.println("Escudo protector activado");

                        n.jugado = true;
                        break;
                    default:
                        System.out.println("opcion no valida");
                }
            }



            /*AE1.Daños(3);
            System.out.println(AE1.getVida());*/

            if (AE1.getVida() <= 0 || AE2.getVida() <= 0){

                System.out.println("\nG A M E   O V E R \n");
                gameOver = false;

                if (AE1.getVida() <= 0){

                    System.out.println("El ganador es el Jugador 2");

                }else{

                    System.out.println("El ganador es el Jugador 1");


                }
            }

        }



    }

}