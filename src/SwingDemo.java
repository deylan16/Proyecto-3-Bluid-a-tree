import clases.arboles.*;

import java.awt.*;
import javax.swing.*;
/**
 * <p>Esta clase se creo para hacer los JPanels de cada jugador
 * </p>
 * @author Deylan
 */
public class SwingDemo extends JPanel {
    public AvlTree arbolAVL = null;
    public BTree arbolBtree = null;
    public BTStree arbolBTS = null;
    public SplayTree arbolSplay = null;
    public boolean gano = false;
    public Graphics2D g2d = null;

    /**
     * <p>Se encarga revisar cual arbol no esta en nulo para dibujarlo y tambien cuando alguien logro el objetivo</p>
     */
    @Override
    public void paint(Graphics g) {
        g.setFont( new Font( "Arial", Font.BOLD, 12 ) );
        this.g2d = (Graphics2D) g;
        this.g2d.setColor(Color.BLUE);
        if (arbolAVL != null){
            DibujaArbol.paintAVL(this.g2d, 230, 0,arbolAVL.getRaiz(),100);
            if(arbolAVL.contador > 5){
                arbolAVL = null;
                gano = true;
            }

        }
        if (arbolBTS != null){
            DibujaArbol.paintBTS(this.g2d, 230, 0,arbolBTS.getRoot(),100);
            if(arbolBTS.maxDepth() > 2){
                arbolBTS = null;
                gano = true;
            }

        }
        if (arbolBtree != null){
            DibujaArbol.paintBtree(this.g2d, 230, 50,arbolBtree.root,230,50,this);

        }
        if (arbolSplay != null){
            DibujaArbol.paintSplay(this.g2d, 230, 0,arbolSplay.getRoot(),100);
            if(arbolSplay.contador > 5){
                arbolSplay = null;
                gano = true;
            }
        }
        this.g2d.setColor(Color.BLACK);
        if(gano){
            g.drawRect(0,0,483,160);

            g.setFont( new Font( "Arial", Font.BOLD, 46 ) );
            g.drawString("GANASTE",120,100);
            g.setFont( new Font( "Arial", Font.BOLD, 12 ) );
            VentanaProgreso.getInstance().frame.repaint();
        }
    }
    public Graphics2D getG2d(){
        return this.g2d;
    }
    /**
     * <p>Crea e inserta el un nodo al arbol AVL</p>
     */
    public void ArbolAVL(int x){
        if (this.arbolAVL == null){
            arbolAVL = new AvlTree();
            arbolAVL.crear(x);}
        else{arbolAVL.insertar(x);
        }
        VentanaProgreso.getInstance().frame.repaint();
    }
    /**
     * <p>Crea e inserta el un nodo al arbol BTree</p>
     */
    public void ArbolBtree(int x){
        if (this.arbolBtree == null){
            this.arbolBtree = new BTree();

        }

        this.arbolBtree.add(x);
        VentanaProgreso.getInstance().frame.repaint();
    }
    /**
     * <p>Crea e inserta el un nodo al arbol BTS</p>
     */
    public void ArbolBTS(int x){
        if (this.arbolBTS == null){
            this.arbolBTS = new BTStree();}
        this.arbolBTS.insert(x);
        VentanaProgreso.getInstance().frame.repaint();
    }
    /**
     * <p>Crea e inserta el un nodo al arbol Splay</p>
     */
    public void ArbolSplay(int x){
        if (this.arbolSplay == null){
            this.arbolSplay = new SplayTree();}
        this.arbolSplay.insert(x);
        VentanaProgreso.getInstance().frame.repaint();
    }
    /**
     * <p>Pone en nulo todos los arboles de jugador y el indicador de si gano, esto para cambiar de
     * de nivel</p>
     */
    public void cambioNivel(){
        this.arbolBtree = null;
        this.arbolSplay = null;
        this.arbolAVL = null;
        this.arbolBTS = null;
        this.gano = false;
        VentanaProgreso.getInstance().frame.repaint();


    }

}
