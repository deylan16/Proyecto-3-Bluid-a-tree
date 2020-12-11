/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasess;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

/**
 * <p>Esta clase se creo para decodificar el json que llega el usuario
 * </p>
 * @author Deylan
 * @author Johnny
**/
public class Analizar {

    /**
     * <p>descodifica el json que llega al usuario y llama la clase para realizar el ataque enemigo
     * </p>
     * @param mensaje
     * @throws IOException
     */
    public Analizar(String mensaje) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode Nodecarta = mapper.readTree(mensaje);
  
        int daño = Nodecarta.get("daño").intValue();
        int coste = Nodecarta.get("coste").intValue();
        String imagen = Nodecarta.get("imagen").asText();
        String nombre = Nodecarta.get("nombre").asText();
        String siguiente = Nodecarta.get("siguiente").asText();
        int cuentapoderzote = Nodecarta.get("cuentapoderzote").intValue();
        String aquienMana = Nodecarta.get("aquienMana").asText();
        String tipo = Nodecarta.get("tipo").asText();     
    }    
}