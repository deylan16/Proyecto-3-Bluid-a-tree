using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

///<summary>
/// Permite cambiar la escena, del menú principal al juego
///</summary>
public class MainMenu : MonoBehaviour
{
    ///<summary>
    /// Cambia a la escena del juego y la inicializa
    ///</summary>
    public void EscenaJuego()
    {
        SceneManager.LoadScene("Game");
    }

    ///<summary>
    /// Cierra el juego
    ///</summary>
    public void Salir()
    {
        Application.Quit();
    }
}
