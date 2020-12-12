package clasess;

import clases.arboles.AvlNode;
import clases.arboles.AvlTree;

import javax.swing.*;
import java.awt.*;
/**
 * <p>Esta clase se creo para mostrar la ventana con el progreso de los arboles de cada jugador
 * </p>
 * @author Deylan
 */
public class VentanaProgreso {
    public static JFrame frame = new JFrame();
    static SwingDemo panelJugador1 =new SwingDemo();
    static SwingDemo panelJugador2 = new SwingDemo();

    private static VentanaProgreso Instancia = null;
    public int contador = 0;
    private VentanaProgreso() {
    }
    /**
     * <p>este es un metodo creado para implementar un singleton
     * </p>
     * @return intancia de la ventana
     */
    public  static VentanaProgreso getInstance() {
        if (Instancia == null){
            Instancia = new VentanaProgreso();
        }

        return Instancia;
    }
    /**
     * <p>abrea el jframe donde se mostrara los jpanels con los
     * arboles de cada jugador
     * </p>
     */
    public void abrirVentana(){
        frame.setLayout(new GridBagLayout());
        frame.setSize(500, 350);
        progresoJugadores("Jugador1");
        progresoJugadores("Jugador2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /**
     * <p>Inserta los Jpanels de cada jugador en el Jframe
     * </p>
     * @param cual
     */
    public void progresoJugadores(String cual){
        JPanel jugador = null;
        if (cual.equals("Jugador1")) {
            jugador = panelJugador1;
            panelJugador1.variable = 1;
        }else{
            if (cual.equals("Jugador2")) {
                jugador = panelJugador2;
                panelJugador2.variable = 2;

            }
        }


        if (jugador != null) {
            jugador.setLayout(new GridBagLayout());
            frame.add(jugador,dimensiones(0, contador, 1, 1, 1.0, 1.0));
            this.contador += 1;
        }



    }
    /**
     * <p>este metodo recibe la dimensiones en las que se quiere poner un componente en la interfaz</p>
     * @param empiezaC
     * @param empiezaF
     * @param ocupaC
     * @param ocupaF
     * @param estirax
     * @param estiray
     * @return GridBagConstraints
     */
    public GridBagConstraints dimensiones(int empiezaC, int empiezaF, int ocupaC, int ocupaF,Double estirax,Double estiray){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = empiezaC; // El área de texto empieza en la columna cero.
        constraints.gridy = empiezaF; // El área de texto empieza en la fila cero
        constraints.gridwidth = ocupaC; // El área de texto ocupa dos columnas.
        constraints.gridheight = ocupaF; // El área de texto ocupa 2 filas.
        constraints.weighty = estiray; // La fila 0 debe estirarse, le ponemos un 1.0
        constraints.weightx = estirax; // La fila 0 debe estirarse, le ponemos un 1.0
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }


}
