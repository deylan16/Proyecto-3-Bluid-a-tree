using System.Collections;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using UnityEngine;

public class FruitCollected : MonoBehaviour
{
    public Rigidbody2D rb2D;
    public bool isInGround = false;

    void Start()
    {
        rb2D = GetComponent<Rigidbody2D>();
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            GetComponent<SpriteRenderer>().enabled = false;
            gameObject.transform.GetChild(0).gameObject.SetActive(true);
            Destroy(gameObject, 0.5f);
            TokenCreation.Destroy(this, 0.5f);
            enviar();
        }

        if (collision.CompareTag("Ground"))
        {
            rb2D.constraints = RigidbodyConstraints2D.FreezeAll;
            isInGround = true;

        }
    }

    private void enviar()
    {
        Socket Enviar = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        IPEndPoint connect = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 10000);

        Enviar.Connect(connect);

        byte[] datos = new byte[1024];
        datos = Encoding.Default.GetBytes("3");
        Enviar.Send(datos);
        
    }
}
