using System.Collections;
using System.Collections.Generic;
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
        }

        if (collision.CompareTag("Ground"))
        {
            rb2D.constraints = RigidbodyConstraints2D.FreezeAll;
            isInGround = true;

        }
    }
}
