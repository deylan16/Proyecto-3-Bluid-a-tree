/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import clasess.Analizar;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * <p>Clase servidor</p>
 * @author Deylan
 * @author Johnny
 */
public class Servidor implements Runnable{
    private final int PUERTO = 10000;
    private String IP;
    private DataInputStream IN;
    
    /**
     * <p>Se crea el servidor y se setea la ip local</p>
     * @throws UnknownHostException
     */
    public Servidor() throws UnknownHostException {
       InetAddress address = InetAddress.getLocalHost();
       this.IP = address.getHostAddress();
    }
    
    @Override
    public void run() {
        try{
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado");
        Socket cliente;
        while(true){
            cliente = servidor.accept();
            IN = new DataInputStream(cliente.getInputStream());
            byte mensaje = IN.readByte(); // 1=49, 2=50, 3=51, 4=52
            int mensa = (int)(mensaje);
            if ( 48 < mensa & mensa < 53){
                Analizar.Dibujar(mensa);
            }
            if ( 52 < mensa & mensa < 57){
                Analizar.Dibujar1(mensa);
            }
            cliente.close();
        }
        
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
