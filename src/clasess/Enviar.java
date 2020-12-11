/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasess;

import conexion.Cliente;

/**
 *
 * @author johnn
 */
public class Enviar {
    
    public Enviar(int token){
        String numero = Integer.toString(token);
        Cliente client = new Cliente(10500, "127.0.0.1", numero);
        Thread t = new Thread(client);
        t.start();
    }
}
