using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TokenCreation : MonoBehaviour
{
    public GameObject token1;
    public GameObject token2;
    public GameObject token3;
    public GameObject token4;

    public static GameObject[] tokenEnPantalla;
    public static int limit = 4;

    public KeyCode a, b, c, d;

    public int n;

    private void Start()
    {
        tokenEnPantalla = GameObject.FindGameObjectsWithTag("Token");
        InvokeRepeating("UpdateList", 0.0f, 0.01f);
        //InvokeRepeating("SpawnToken", 5.0f, 5.0f);
        
    }

    public void Update()
    {
        if (Input.GetKeyDown(a) || Input.GetKeyDown(b) || Input.GetKeyDown(c) || Input.GetKeyDown(d))
        {
            if (Input.GetKey(a))
            {
                n = 1;
            }
            if (Input.GetKey(b))
            {
                n = 2;

            }
            if (Input.GetKey(c))
            {
                n = 3;

            }
            if (Input.GetKey(d))
            {
                n = 4;
            }

            SpawnToken(n);
        }

    }

    void SpawnToken(int n)
    {
        Vector2 positionToken = new Vector2(Random.Range(-1.9f, 1.9f), 1.2f);
        
    
        Debug.Log(tokenEnPantalla.Length);
        if (tokenEnPantalla.Length < limit)
        {
            if (n.Equals(1)) //Rombo
            {
                Instantiate(token1, positionToken, transform.rotation);

            }
            if (n.Equals(2)) //Cuadrado
            {
                Instantiate(token2, positionToken, transform.rotation);

            }
            if (n.Equals(3)) //Circulo
            {
                Instantiate(token3, positionToken, transform.rotation);

            }
            if (n.Equals(4)) //Triángulo
            {
                Instantiate(token4, positionToken, transform.rotation);

            }




        }

    }

    void UpdateList()
    {
        tokenEnPantalla = GameObject.FindGameObjectsWithTag("Token");
    }
}

