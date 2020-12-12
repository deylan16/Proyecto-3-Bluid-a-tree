using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///<summary>
/// Permite al jugador subirse y bajar de una plataforma
///</summary>
public class Platform : MonoBehaviour
{

    private PlatformEffector2D effector;
    public float startWaitTime = 0.2f;
    public float waitedTime;

    ///<summary>
    /// inicializa la plataforma
    ///</summary>
    void Start()
    {
        effector = GetComponent<PlatformEffector2D>();
    }

    ///<summary>
    /// Actualiza la plataforma
    ///</summary>
    void Update()
    {

        if (Input.GetKeyUp(KeyCode.DownArrow) || Input.GetKeyUp("s") || Input.GetKey(KeyCode.Joystick1Button0))
        {
            waitedTime = startWaitTime;
        }


        if (Input.GetKey(KeyCode.DownArrow) || Input.GetKey("s") || Input.GetKey(KeyCode.Joystick1Button0))
        {
            if (waitedTime <= 0)
            {
                effector.rotationalOffset = 180f;
                waitedTime = startWaitTime;
            }

            else
            {
                waitedTime -= Time.deltaTime;
            }
        }

        if (Input.GetKey("space") || Input.GetKey(KeyCode.Joystick1Button2))
        {
            effector.rotationalOffset = 0;
        }

    }
}
