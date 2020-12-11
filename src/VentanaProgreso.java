import clases.arboles.AvlNode;
import clases.arboles.AvlTree;

import javax.swing.*;
import java.awt.*;

public class VentanaProgreso {
    public JFrame frame = new JFrame();
    static SwingDemo panelJugador1 =new SwingDemo();
    static SwingDemo panelJugador2 = new SwingDemo();
    static SwingDemo panelJugador3 = new SwingDemo();
    static SwingDemo panelJugador4 = new SwingDemo();

    private static VentanaProgreso Instancia = null;
    public int contador = 0;
    private VentanaProgreso() {
    }
    public  static VentanaProgreso getInstance() {
        if (Instancia == null){
            Instancia = new VentanaProgreso();
        }

        return Instancia;
    }

    public void abrirVentana(){
        frame.setLayout(new GridBagLayout());
        frame.setSize(500, 700);
        progresoJugadores("Jugador1");
        progresoJugadores("Jugador2");
        progresoJugadores("Jugador3");
        progresoJugadores("Jugador4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void progresoJugadores(String cual){
        JPanel jugador = null;
        if (cual.equals("Jugador1")) {
            jugador = panelJugador1;

        }else{
            if (cual.equals("Jugador2")) {
                jugador = panelJugador2;

            }else{
                if (cual.equals("Jugador3")) {
                    jugador = panelJugador3;
                }else{
                    if (cual.equals("Jugador4")) {
                        jugador = panelJugador4;
                }
            }
            }
        }


        if (jugador != null) {
            jugador.setLayout(new GridBagLayout());
            frame.add(jugador,dimensiones(0, contador, 1, 1, 1.0, 1.0));
            this.contador += 1;
        }



    }
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
