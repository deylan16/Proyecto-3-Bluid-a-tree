using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;


///<summary>
///Permite que el jugador reaparezca luego de morir
///</summary>
public class PlayerRespawn : MonoBehaviour
{
    public Animator animator;

    ///<summary>
    /// Reposiciona al jugador en una zona segura del escenario luego de morir
    ///</summary>
    public void PlayerDamaged()
    {
        animator.Play("Hit");
        //SceneManager.LoadScene(SceneManager.GetActiveScene().name);


        if (gameObject.transform.position.x < 0)
        {
            transform.SetPositionAndRotation(new Vector3(-1.6f, 0.01f, 0f), Quaternion.Euler(0, 0, 0));
        }
        else
        {
            transform.SetPositionAndRotation(new Vector3(1.3f, 0.68f, 0f), Quaternion.Euler(0, 0, 0));
        }
    }
}
