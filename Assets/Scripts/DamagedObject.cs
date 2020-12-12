using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///<summary>
///Hace que el jugador reciba daño al ser tocado por este
///</summary>
public class DamagedObject : MonoBehaviour
{
    ///<summary>
    /// Verifica si un jugador ha entrado en el collider de este objeto y lo hace morir
    ///</summary>
    private void OnCollisionEnter2D(Collision2D collision)
    { 
        if (collision.transform.CompareTag("Player") || (collision.transform.CompareTag("Player2")))
        {
            Debug.Log("Player Damaged");
            collision.transform.GetComponent<PlayerRespawn>().PlayerDamaged();
        }
    }
}
