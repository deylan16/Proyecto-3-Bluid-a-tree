package clasess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;

/**
 * <p>Esta clase se creo para decodificar el json que llega el usuario
 * </p>
 * @author Deylan
 * @author Johnny
**/
public class Analizar {
    private VentanaProgreso ventana;
    public static int nivel, nivel1;
    /**
     * <p>descodifica el json que llega al usuario y llama la clase para realizar el ataque enemigo
     * </p>
     * @param mensaje
     * @throws IOException
     */
    public Analizar(){
        ventana = VentanaProgreso.getInstance();
        ventana.abrirVentana();       
    }
    public static void Nivel(String Nivel){
        if (Nivel == "Nivel 1"){
            VentanaProgreso.frame.setTitle("Nivel 1 - Arbol BTS (Rombos)");
            nivel = 49;
            nivel1 = 53;
        }
        if (Nivel == "Nivel 2"){
            VentanaProgreso.frame.setTitle("Nivel 2 - Arbol AVL (Circulos)");
            nivel = 51;
            nivel1 = 55;
        }
        if (Nivel == "Nivel 3"){
            VentanaProgreso.frame.setTitle("Nivel 3 - Arbol Splay (Triangulos)");
            nivel = 52;
            nivel1 = 56;
        }
        if (Nivel == "Nivel 4"){
            VentanaProgreso.frame.setTitle("Nivel 4 - Arbol BTree (Cuadrados)");
            nivel = 50;
            nivel1 = 54;
        }
        
    }
    public static void Dibujar(int mensaje){
        int valor = (int) (Math.random() * (30 - 1 + 1) + 1);
        if (mensaje == nivel){
        if (mensaje == 49){
            VentanaProgreso.panelJugador1.ArbolBTS(valor);
        }
        if (mensaje == 50){
            VentanaProgreso.panelJugador1.ArbolBtree(valor);
        }
        if (mensaje == 51){
            VentanaProgreso.panelJugador1.ArbolAVL(valor);
        }
        if (mensaje == 52){
            VentanaProgreso.panelJugador1.ArbolSplay(valor);
        }
        }
        else{
            VentanaProgreso.panelJugador1.cambioNivel();
        }
    }
    public static void Dibujar1(int mensaje){
        int valor = (int) (Math.random() * (30 - 1 + 1) + 1);
        if (mensaje == nivel1)
        {
            if (mensaje == 53){
            VentanaProgreso.panelJugador2.ArbolBTS(valor);
            }
            if (mensaje == 54){
                VentanaProgreso.panelJugador2.ArbolBtree(valor);
            }
            if (mensaje == 55){
                VentanaProgreso.panelJugador2.ArbolAVL(valor);
            }
            if (mensaje == 56){
                VentanaProgreso.panelJugador2.ArbolSplay(valor);
            }
        }
        else{
            VentanaProgreso.panelJugador2.cambioNivel();
        }
    }
}