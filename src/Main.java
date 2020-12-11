import clases.arboles.*;
import clasess.Enviar;
import conexion.Cliente;
import conexion.Servidor;

import static java.lang.Thread.sleep;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException{
        //VentanaProgreso ventana = VentanaProgreso.getInstance();
        //ventana.abrirVentana();
        //ventana.frame.setTitle("Progreso");
        Servidor server = new Servidor();
        Thread t = new Thread(server);
        t.start();

        new Thread(() -> {
            for(int i = 1;i <3;i++){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                new Enviar(2);
            }
        }).start();

    }
}
