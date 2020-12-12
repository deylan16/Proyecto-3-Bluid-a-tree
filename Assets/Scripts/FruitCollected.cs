using System.Collections;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using UnityEngine;

///<summary>
/// Envía información al socket de Java y desaparece de la pantalla los tokens al ser recolectados
///</summary>
public class FruitCollected : MonoBehaviour
{
    public Rigidbody2D rb2D;
    public bool isInGround = false;
    private string captura;
    private string token;
    void Start()
    {
        rb2D = GetComponent<Rigidbody2D>();
    }

    ///<summary>
    /// Comprueba si un jugador ha recolectado este token
    ///</summary>
    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            GetComponent<SpriteRenderer>().enabled = false;
            gameObject.transform.GetChild(0).gameObject.SetActive(true);
            Destroy(gameObject, 0.5f);
            TokenCreation.Destroy(this, 0.5f);
            if(gameObject.name.Equals("Token 1(Clone)")){
                token = "11"; //49
            }
            if(gameObject.name.Equals("Token 2(Clone)")){
                token = "21"; //50
            }
            if(gameObject.name.Equals("Token 3(Clone)")){
                token = "31"; //51
            }
            if(gameObject.name.Equals("Token 4(Clone)")){
                token = "41"; //52
            }
            enviar();
        }
        if (collision.CompareTag("Player2"))
        {
            GetComponent<SpriteRenderer>().enabled = false;
            gameObject.transform.GetChild(0).gameObject.SetActive(true);
            Destroy(gameObject, 0.5f);
            TokenCreation.Destroy(this, 0.5f);
            if(gameObject.name.Equals("Token 1(Clone)")){
                token = "51"; //53
            }
            if(gameObject.name.Equals("Token 2(Clone)")){
                token = "61"; //54
            }
            if(gameObject.name.Equals("Token 3(Clone)")){
                token = "71"; //55
            }
            if(gameObject.name.Equals("Token 4(Clone)")){
                token = "81"; //56
            }
            enviar();
        }

        if (collision.CompareTag("Ground"))
        {
            rb2D.constraints = RigidbodyConstraints2D.FreezeAll;
            isInGround = true;

        }
    }

    ///<summary>
    /// Envia información sobre el token recolectado al servidor
    ///</summary>
    private void enviar()
    {
        Socket Enviar = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        IPEndPoint connect = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 10000);

        Enviar.Connect(connect);

        byte[] datos = new byte[1024];
        datos = Encoding.Default.GetBytes(token);
        Enviar.Send(datos);
        
    }
}
