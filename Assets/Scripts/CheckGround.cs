using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CheckGround : MonoBehaviour
{
    public static bool isGrounded;
    public static bool isAtacked;

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


}
