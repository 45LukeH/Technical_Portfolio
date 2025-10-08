using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LoraxCollisionHandler : MonoBehaviour
{
    public int seedCount = 0;
    public int playerLives = 3;
    private PlayerHealth playerHealth;

    // Start is called before the first frame update
    void Start()
    {
        playerHealth = GetComponent<PlayerHealth>();
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.CompareTag("ThneedSeed"))
        {
            seedCount++;
            Debug.Log("Seed collected! Total seeds: " + seedCount);
            Destroy(collision.gameObject);
        }
        else if (collision.gameObject.CompareTag("Axe"))
        {
            playerLives--;
            Debug.Log("Axe hit! Lives remaining: " + playerLives);
            Destroy(collision.gameObject);

            if (playerLives <= 0)
            {
                Debug.Log("Game Over!");
                //implement more game over logic
            }
        }
    }
}
