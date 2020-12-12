using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///<summary>
/// Detecta las colisiones del ataque del jugador con el otro jugador
///</summary>
public class Atack : MonoBehaviour
{
    CircleCollider2D cC2D;
    public static object Jugador;

    ///<summary>
    /// Verifica si un jugador se encuentra en el rango delataque de otro jugador
    ///</summary>
    public void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            //Jugador = GameObject.FindGameObjectsWithTag("Player");
            Debug.Log("el jugador1 está siendo atacado");
        }
        if (collision.CompareTag("Player2")){
            Debug.Log("el jugador2 esta siendo atacado");
        }
    }
}
