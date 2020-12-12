import clasess.VentanaProgreso;
import clases.arboles.*;
import clasess.Enviar;
import clasess.Analizar;
import conexion.Cliente;
import conexion.Servidor;

import static java.lang.Thread.sleep;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException{
        Servidor server = new Servidor();
        Thread t = new Thread(server);
        t.start();
        new Analizar();
        Analizar.Nivel("Nivel 3");
        
        new Thread(() -> {
            while(true){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(Analizar.nivel == 49 || Analizar.nivel == 50){
                    int token = (int)(Math.random() * (3));
                    new Enviar(token);
                }
                if(Analizar.nivel == 51 || Analizar.nivel == 52 ){
                    int token = (int)(Math.random() * (5)+2);
                    new Enviar(token);
                }
            }
        }).start();

    }
}
