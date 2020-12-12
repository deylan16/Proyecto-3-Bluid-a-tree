using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Atack : MonoBehaviour
{
    CircleCollider2D cC2D;
    public static object Jugador;
    
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
