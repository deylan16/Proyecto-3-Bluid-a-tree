using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///<summary>
///Permite seleccionar la skin del jugador en la configuración de unity
///</summary>

public class PlayerSelect : MonoBehaviour
{
    public enum Player {NinjaFrog, VirtualGuy, PinkMan};
    public Player playerSelected;

    public Animator animator;
    public SpriteRenderer spriteRenderer;

    public RuntimeAnimatorController[] playersController;
    public Sprite[] playerRenderer;

    ///<summary>
    /// Inicializa el switch que permite el cambio de skin
    ///</summary>
    void Start()
    {
        switch (playerSelected)
        {
            case Player.NinjaFrog:
                spriteRenderer.sprite = playerRenderer[0];
                animator.runtimeAnimatorController = playersController[0];
                break;

            case Player.VirtualGuy:
                spriteRenderer.sprite = playerRenderer[1];
                animator.runtimeAnimatorController = playersController[1];
                break;

            case Player.PinkMan:
                spriteRenderer.sprite = playerRenderer[2];
                animator.runtimeAnimatorController = playersController[2];
                break;

            default:
                break;
        }
    }

}
