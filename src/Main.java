import clases.arboles.AvlNode;
import clases.arboles.AvlTree;
import clases.arboles.BTree;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args){
        VentanaProgreso ventana = VentanaProgreso.getInstance();
        ventana.abrirVentana();
        ventana.frame.setTitle("AVL");


        new Thread(() -> {
            for(int i = 1;i <6;i++){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                VentanaProgreso.panelJugador2.ArbolBTS(i);
                System.out.print(VentanaProgreso.panelJugador2.arbolBTS.maxDepth());
            }
        }).start();







//        BTree hola = new BTree();
//        hola.add(1);
//        hola.add(10);
//        hola.add(9);
//        hola.add(11);
//        hola.add(12);
//        hola.add(13);
//        hola.add(14);
//        hola.add(15);
//        hola.add(16);
//        System.out.print(hola.toString());

    }
}
