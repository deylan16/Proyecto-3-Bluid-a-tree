using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour
{

    public float runSpeed = 2;
    public float jumpSpeed = 4;
    Rigidbody2D rb2D;

    public bool betterJump = true;
    public float fallMultiplier = 0.5f;
    public float lowJumpMultiplier = 1f;

    public float doubleJumpSpeed = 3f;
    private bool canDoubleJump;

    public SpriteRenderer  spriteRenderer;
    public Animator animator;  

    void Start()
    {
        rb2D = GetComponent<Rigidbody2D>();
    }


    public void Update()
    {

        if (Input.GetKey("space"))
        {
            if (CheckGround.isGrounded)
            {
                canDoubleJump = true;
                rb2D.velocity = new Vector2(rb2D.velocity.x, jumpSpeed);
            }

            else
            {
                if(Input.GetKeyDown("space"))
                {
                    if (canDoubleJump)
                    {
                        animator.SetBool("DoubleJump", true);
                        rb2D.velocity = new Vector2(rb2D.velocity.x, doubleJumpSpeed);
                        canDoubleJump = false; 

                    }
                }
            }
        }

        if (CheckGround.isGrounded == false)
        {
            animator.SetBool("Jump", true);
            animator.SetBool("Run", false);
        }

        if (CheckGround.isGrounded == true)
        {
            animator.SetBool("Jump", false);
            animator.SetBool("DoubleJump", false);
            animator.SetBool("Falling", false);
        }

        if (rb2D.velocity.y < 0) 
        {
            animator.SetBool("Falling", true);
            animator.SetBool("DoubleJump", true);
        }

        else if (rb2D.velocity.y > 0)
        {
            animator.SetBool("Falling", false);

        }

    }

    void FixedUpdate()
    {
        if (Input.GetKey("d") || Input.GetKey("right"))
        {
            rb2D.velocity = new Vector2(runSpeed, rb2D.velocity.y);
            spriteRenderer.flipX = false;
            animator.SetBool("Run", true);
        }

        else if (Input.GetKey("a") || Input.GetKey("left"))
        {
            rb2D.velocity = new Vector2(-runSpeed, rb2D.velocity.y);
            spriteRenderer.flipX = true;
            animator.SetBool("Run", true);
        }

        else
        {
            rb2D.velocity = new Vector2(0, rb2D.velocity.y);
            animator.SetBool("Run", false);

        }

        if (betterJump)
        {
            if (rb2D.velocity.y < 0)
            {
                rb2D.velocity += Vector2.up * Physics2D.gravity.y * (fallMultiplier) * Time.deltaTime;
            }
            if (rb2D.velocity.y > 0 && !Input.GetKey("space"))
            {
                rb2D.velocity += Vector2.up * Physics2D.gravity.y * (lowJumpMultiplier) * Time.deltaTime;
            }
        }
    }
}
        

    
