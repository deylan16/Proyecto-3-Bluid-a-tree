using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///<summary>
/// Comprueba si el jugador entra en contacto con colliders del escenario y ataques enemigos
///</summary>
public class CheckGround : MonoBehaviour
{
    public static bool isGrounded;
    public static bool isAtacked;

    ///<summary>
    /// Comprueba si un jugador entra en contacto con el suelo o con un ataque
    ///</summary>
    private void OnTriggerEnter2D(Collider2D collision) 
    {
        if (collision.CompareTag("Ground"))
        {
            isGrounded = true;
        }

        if (collision.CompareTag("Atack"))
        {
            isAtacked = true;
        }
    }

    ///<summary>
    /// Comprueba si un jugador sale del contacto con el suelo o de un ataque
    ///</summary>
    private void OnTriggerExit2D(Collider2D collision)
    {
        if (collision.CompareTag("Ground"))
        {
            isGrounded = false;
        }
        if (collision.CompareTag("Atack"))
        {
            isAtacked = false;
        }

    }

    ///<summary>
    /// Comprueba si el jugador se encuentra en contacto con un ataque
    ///</summary>
    private void OnTriggerStay(Collider other)
    {
        if (other.CompareTag("Atack"))
        {
            isAtacked = true;
        }
    }

}
