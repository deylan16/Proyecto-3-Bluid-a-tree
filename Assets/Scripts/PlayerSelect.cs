using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerSelect : MonoBehaviour
{
    public enum Player {NinjaFrog, VirtualGuy, PinkMan};
    public Player playerSelected;

    public Animator animator;
    public SpriteRenderer spriteRenderer;

    public RuntimeAnimatorController[] playersController;
    public Sprite[] playerRenderer;

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
