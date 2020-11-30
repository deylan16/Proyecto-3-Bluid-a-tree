using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TokenCreation : MonoBehaviour
{
    public GameObject token;
    public static GameObject[] tokenEnPantalla;
    public static int limit = 4;

    private void Start()
    {
        tokenEnPantalla = GameObject.FindGameObjectsWithTag("Token");
        InvokeRepeating("UpdateList", 0.0f, 0.01f);
        InvokeRepeating("SpawnToken", 5.0f, 20.0f);
        
    }

    void SpawnToken()
    {
        Debug.Log(tokenEnPantalla.Length);
        if (tokenEnPantalla.Length < limit)
        {

            Vector2 randomToken = new Vector2(Random.Range(-1.9f, 1.9f), 1.2f);
            Instantiate(token, randomToken, transform.rotation);

 
        }

    }

    void UpdateList()
    {
        tokenEnPantalla = GameObject.FindGameObjectsWithTag("Token");
    }
}

