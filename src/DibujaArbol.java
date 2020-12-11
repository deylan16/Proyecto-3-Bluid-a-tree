import clases.arboles.AvlNode;
import clases.arboles.BSTNode;
import clases.arboles.BTree;
import clases.arboles.SplayNode;

import javax.swing.*;
import java.awt.*;

public class DibujaArbol  extends JPanel{

    public static void  paintAVL(Graphics2D g,int x,int y,AvlNode nodo,int espacio) {
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(nodo.getElement()),x+11,y+19);
        g.setColor(Color.BLUE);
        if (nodo.getLeft() != null){
            g.drawLine(x+15,y,x-espacio+15,y+30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(nodo.getElement()),x+11,y+19);
            g.setColor(Color.BLUE);
            paintAVL(g,x-espacio,y+30,nodo.getLeft(),espacio -40);
        }
        if (nodo.getRight() != null){
            g.drawLine(x+15,y,x+espacio+15,y+30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(nodo.getElement()),x+11,y+19);
            g.setColor(Color.BLUE);
            paintAVL(g,x+espacio,y+30,nodo.getRight(),espacio -40);
        }
    }
    public static void  paintBTS(Graphics2D g, int x, int y, BSTNode nodo, int espacio) {
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(nodo.getKey()),x+11,y+19);
        g.setColor(Color.BLUE);
        if (nodo.getLeft() != null){
            g.drawLine(x+15,y,x-espacio+15,y+30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(nodo.getKey()),x+11,y+19);
            g.setColor(Color.BLUE);
            paintBTS(g,x-espacio,y+30,nodo.getLeft(),espacio -40);
        }
        if (nodo.getRight() != null){
            g.drawLine(x+15,y,x+espacio+15,y+30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(nodo.getKey()),x+11,y+19);
            g.setColor(Color.BLUE);
            paintBTS(g,x+espacio,y+30,nodo.getRight(),espacio -40);
        }
    }
    public static void  paintSplay(Graphics2D g, int x, int y, SplayNode nodo, int espacio) {
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(nodo.getElement()),x+11,y+19);
        g.setColor(Color.BLUE);
        if (nodo.getLeft() != null){
            g.drawLine(x+15,y,x-espacio+15,y+30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(nodo.getElement()),x+11,y+19);
            g.setColor(Color.BLUE);
            paintSplay(g,x-espacio,y+30,nodo.getLeft(),espacio -40);
        }
        if (nodo.getRight() != null){
            g.drawLine(x+15,y,x+espacio+15,y+30);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(nodo.getElement()),x+11,y+19);
            g.setColor(Color.BLUE);
            paintSplay(g,x+espacio,y+30,nodo.getRight(),espacio -40);
        }
    }
    public static void  paintBtree(Graphics2D g, int x, int y, BTree.Node node, int x2, int y2, SwingDemo swingDemo) {
        String muestra = "|";
        int cuenta2 = 10;
        int cuenta3 = 0;
        int espacio = -100;
        for (int i = 0; i < node.keysSize; i++) {
            if (10 < (int) node.getKey(i)){
                cuenta2= 17;
            }
            muestra += node.getKey(i);
            muestra += "|";
        }
        g.drawString(muestra,x,y);


        if (node.children != null) {
            for (int i = 0; i < node.numberOfChildren(); i++) {
                String muestra2 = "|";
                for (int e = 0;e < node.getChild(i).keysSize; e++) {
                    muestra2 += node.getChild(i).getKey(e);
                    muestra2 += "|";
                    if(node.getChild(i).getChild(0) != null){
                        swingDemo.arbolBtree = null;
                        swingDemo.gano = true;
                    }
                }
                g.drawLine(x+espacio,y+20,x+cuenta3,y);
                g.drawString(muestra2,x+espacio,y+30);
                espacio += 100;
                cuenta3 += cuenta2;
            }

            }


    }
}
