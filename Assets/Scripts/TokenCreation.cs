using System.Collections;
using System.Collections.Generic;
using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using UnityEngine;

public class TokenCreation : MonoBehaviour
{
    public GameObject token1;
    public GameObject token2;
    public GameObject token3;
    public GameObject token4;

    public static GameObject[] tokenEnPantalla;
    public static int limit = 4;
    private TcpListener tcpListener; 
	private Thread tcpListenerThread;  	
	private TcpClient connectedTcpClient; 	
	private String clientMessage;
    private int Numero = 0;

    private void Start()
    {
        tokenEnPantalla = GameObject.FindGameObjectsWithTag("Token");
        tcpListenerThread = new Thread (new ThreadStart(ListenForIncommingRequests)); 		
		tcpListenerThread.IsBackground = true; 		
		tcpListenerThread.Start(); 
        
    }

    public void Update()
    {
        if (tokenEnPantalla.Length < limit)
        {
            if (Numero > 0)
            {
                Vector2 positionToken = new Vector2(UnityEngine.Random.Range(-1.9f, 1.9f), 1.2f);
                if (Numero.Equals(1)) //Rombo
                {
                    Instantiate(token1, positionToken, transform.rotation);
                    Numero = 0;
                }
                if (Numero.Equals(2)) //Cuadrado
                {
                    Instantiate(token2, positionToken, transform.rotation);
                    Numero = 0;
                }
                if (Numero.Equals(3)) //Circulo
                {
                    Instantiate(token3, positionToken, transform.rotation);
                    Numero = 0;
                }
                if (Numero.Equals(4)) //Triángulo
                {
                    Instantiate(token4, positionToken, transform.rotation);
                    Numero = 0;
                }
            }
        }
    }

    private void ListenForIncommingRequests () { 		
		try { 			
			// Create listener on localhost port 10500. 			
			tcpListener = new TcpListener(IPAddress.Parse("127.0.0.1"), 10500); 			
			tcpListener.Start();              
			Debug.Log("Server is listening");              
			Byte[] bytes = new Byte[1024];  			
			while (true) { 				
				using (connectedTcpClient = tcpListener.AcceptTcpClient()) { 					
					// Get a stream object for reading				
					using (NetworkStream stream = connectedTcpClient.GetStream()) { 						
						int length; 						
						// Read incomming stream into byte arrary. 						
						while ((length = stream.Read(bytes, 0, bytes.Length)) != 0) { 							
							var incommingData = new byte[length]; 							
							Array.Copy(bytes, 0, incommingData, 0, length);  							
							// Convert byte array to string message. 							
							clientMessage = Encoding.ASCII.GetString(incommingData);
							Numero = int.Parse(clientMessage);
						}
					} 				
				} 			
			} 		
		} 		
		catch (SocketException socketException) { 			
			Debug.Log("SocketException " + socketException.ToString()); 		
		}     
	}

}

