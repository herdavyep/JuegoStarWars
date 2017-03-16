package com.heri.ProyectoJuego;

import java.util.Scanner;

/**
 * Created by heriberto on 11/03/17.
 */
public class RunJuego {

    public static void main(String[] args) {

        boolean gameOver = true;
        int opcion = 0;

        Scanner sc = new Scanner(System.in);
        Nave n = new Nave();

        System.out.println("\nS T A R   W A R S\n");
        System.out.println("Existen 3 tipos de naves con las cuales solo se puede atacar una vez," +
                " puede volver a atacar cuando los demas de su grupo ya lo allan hecho\n, se puede defender las veces que quiera, pero si ataca, " +
                "el escudo se desabilitara." +
                " El juego termina cuando el Acorasado estelar es destruido \n");

        Nave AE1 = new Nave(1,"Acorasado Estelar","Cañon Estelar",13,7,5);
        Nave Ej1 = new Nave(1,"Ejecutor","Ejecucion Milenaria",9,5,3);
        Nave CE1 = new Nave(1,"Caza estelar","Laser de Luz",5,3,1);

        Nave AE2 = new Nave(2,"Acorasado Estelar","Cañon Estelar",13,7,5);
        Nave Ej2 = new Nave(2,"Ejecutor","Ejecucion Final",9,5,3);
        Nave CE2 = new Nave(2,"Caza estelar","Laser Oscuro",5,3,1);

        while (gameOver){

            if (n.jugado){

                if (Ej1.isDestruida(Ej1)){

                    Ej1.ataco = true;
                }

                if (CE1.isDestruida(CE1)){

                    CE1.ataco = true;
                }

                System.out.println("\nJugador 1");
                Nave.Menu();

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

                            System.out.println("tu tropa esta lista para volver a atacar");

                        }

                        if (AE1.defendio){

                            System.out.println("Escudo protector desactivado");
                        }

                        AE1.defendio = false;
                        Ej1.defendio = false;
                        CE1.defendio = false;

                        n.ataco = false;

                        while (!n.ataco){

                            Nave.MenuAtacarA();
                            opcion = sc.nextInt();
                            switch (opcion){

                                case 1: // atacar acorazado

                                   Nave.AtacarConAcorasado(AE1,AE2,n);

                                    break;

                                case 2://atacar ejecutor con ejecutor

                                    Nave.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){

                                        Nave.Atacar(Ej1,Ej2,n);

                                    }else if(opcion == 2){ // atacar ejecutor con caza estelar

                                        Nave.Atacar(CE1,Ej2,n);

                                    }else if (opcion != 1 && opcion != 2){
                                        System.out.println("Opcion no valiida");
                                        n.ataco = false;
                                    }
                                    break;

                                case 3://atacar Caza estelar con ejecutor

                                    Nave.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){

                                        Nave.Atacar(Ej1,CE2,n);

                                    }else if (opcion == 2){ //atacar caza estelar con caza estelar

                                        Nave.Atacar(CE1,CE2,n);

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

                    case 4:

                        AE2.getNave();
                        Ej2.getNave();
                        CE2.getNave();

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
                Nave.Menu();

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

                            Nave.MenuAtacarA();
                            opcion = sc.nextInt();
                            switch (opcion){

                                case 1:

                                    Nave.AtacarConAcorasado(AE2,AE1,n);

                                    break;

                                case 2://atacar ejecutor

                                    Nave.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){

                                        Nave.Atacar(Ej2,Ej1,n);

                                    }else if(opcion == 2){

                                        Nave.Atacar(CE2,Ej1,n);

                                    }else if (opcion != 1 && opcion != 2){

                                        System.out.println("Opcion no valiida");

                                        n.ataco = false;
                                    }
                                    break;

                                case 3://atacar Caza estelar

                                    Nave.MenuAtacarEjecutorCazestelar();
                                    opcion = sc.nextInt();
                                    if (opcion == 1){

                                        Nave.Atacar(Ej2,CE1,n);

                                    }else if (opcion == 2){

                                        Nave.Atacar(CE2,CE1,n);

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

                    case 4:

                        AE1.getNave();
                        Ej1.getNave();
                        CE1.getNave();

                        break;

                    default:
                        System.out.println("opcion no valida");
                }
            }

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
