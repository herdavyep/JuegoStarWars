package com.heri.ProyectoJuego;

/**
 * Created by heriberto on 11/03/17.
 */
public class Nave {

    protected int brigada;
    protected String nombre;
    protected String arma;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected boolean jugado = true;
    protected boolean ataco = false;
    protected boolean defendio = false;
    protected boolean destruida = false;

    public Nave() {

    }

    public Nave(int brigada, String nombre, String arma, int vida, int ataque, int defensa) {
        this.brigada = brigada;
        this.nombre = nombre;
        this.arma = arma;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public boolean isDestruida(Nave nave){

        if (nave.getVida() <= 0){

            destruida = true;

        }
        return destruida;

    }

    public static void isDestruidaMensaje(Nave nave){

        if (nave.getVida() <= 0){

            System.out.println("La Nave enemiga fue destruida");
        }

    }

    public void getDestruida(){

        if (destruida){

            System.out.println("Destruida: SI");
        }else {

            System.out.println("Destruida: NO");
        }

    }

    public void isAtaco() {

        if(ataco){

            System.out.println("Ataco: SI");

        }else {

            System.out.println("Ataco: NO");
        }
    }

    public boolean isDefendio() {
        return defendio;
    }

    public String getNombre() {

        System.out.println("Nombre nave: "+nombre);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArma() {

        System.out.println("Arma: "+arma);
        return arma;
    }

    public void setArma(String arma) {

        this.arma = arma;
    }

    public int getVida() {

        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getBrigada() {

        System.out.println("Brigada: "+brigada);
        return brigada;
    }

    public void setBrigada(int brigada) {

        this.brigada = brigada;
    }

    public int getAtaque() {
        System.out.println("Poder de ataque: "+ataque);
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {

        System.out.println("Escudo de defensa: "+defensa);
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void getNave(){

        System.out.println("");
        getBrigada();
        getNombre();
        System.out.println("Vida: "+vida);
        getArma();
        getAtaque();
        getDefensa();
        isAtaco();
        getDestruida();
        System.out.println("");
    }

    public int Daños(int daño){

        vida = vida - daño;
        return vida;
    }

    public static void MenuAtacarA(){

        System.out.println("");
        System.out.println("¿Cual quieres atacar?");
        System.out.println("1. Atacar al Acorasado Estelar");
        System.out.println("2. Atacar al Ejecutor");
        System.out.println("3. Atacar al Caza Estelar");
        System.out.println("Ingresa la opcion!");
        System.out.println("");

    }

    public static void MenuAtacarEjecutorCazestelar (){

        System.out.println("");
        System.out.println("¿Con cual quieres atacar?");
        System.out.println("1. Atacar con Ejecutor");
        System.out.println("2. Atacar con Caza Estelar");
        System.out.println("Ingresa la opcion!");
        System.out.println("");

    }

    public static void Menu (){

        System.out.println("");
        System.out.println("1. Ver mi equipo");
        System.out.println("2. Atacar");
        System.out.println("3. Defender");
        System.out.println("4. Ver equipo contrario");
        System.out.println("¿Que accion quieres ejecutar?");
        System.out.println("");
    }

    public static void AtaqueExitoso(int daño){

        System.out.println("El ataque fue directo y ocaciono "+daño+" puntos de daño");

    }

    public static void AtaqueExitosoEscudo(int daño){

        System.out.println("El ataque fue debilitado y solo ocasiono "+daño+" puntos de daño, porque el enemigo tenia activado el escudo");
    }

    public static void AtacarConAcorasado(Nave ataca,Nave atacada, Nave estado){

        if (!ataca.ataco){

            if (atacada.defendio){
                atacada.Daños(2);
                Nave.AtaqueExitosoEscudo(2);

            }else{

                atacada.Daños(7);
                Nave.AtaqueExitoso(7);
            }

            estado.ataco = true;
        }else{

            System.out.println("Ya ataco debe esperar que ataquen los demas");
            estado.ataco = false;

        }

        ataca.ataco = true;
    }

    public static void Atacar(Nave ataca,Nave atacada, Nave estado){

        if(ataca.getVida() <= 0){

            System.out.println("Una nave destruida no puede atacar");
            estado.ataco = false;
            //break;
        }else {

            if (!ataca.ataco){
                if(atacada.getVida() <= 0){

                    System.out.println("\nNo se puede atacar una nave destruida");
                    estado.ataco = false;
                    //break;

                }else{

                    if (atacada.defendio){

                        atacada.Daños(2);
                        Nave.AtaqueExitosoEscudo(2);
                        Nave.isDestruidaMensaje(atacada);


                    }else{

                        atacada.Daños(5);
                        Nave.AtaqueExitoso(5);
                        Nave.isDestruidaMensaje(atacada);
                    }
                }

                estado.ataco = true;

            }else{

                System.out.println("Ya ataco debe esperar que ataquen los demas");
                estado.ataco = false;
            }
        }

        ataca.ataco = true;
    }
}
