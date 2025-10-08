using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LoraxMover : MonoBehaviour
{
    public float speed;
    private int seedCount = 0;
    public TextAlignment seedCountText;
    private bool isKnockedDown = false;

    // Reference to the SeedManager
    public SeedManager seedManager; // Add this line

    // Start is called before the first frame update
    void Start()
    {
        // UpdateSeedCountDisplay();
    }

    // Update is called once per frame
    void Update()
    {
        if (!isKnockedDown)
        {
            // Move left or right based on input
            if (Input.GetKey(KeyCode.RightArrow))
            {
                Vector2 newPos = new Vector2(
                   gameObject.transform.position.x + speed * Time.deltaTime,
                   gameObject.transform.position.y
                   );
                gameObject.transform.position = newPos;
            }
            if (Input.GetKey(KeyCode.LeftArrow))
            {
                Vector2 newPos = new Vector2(
                   gameObject.transform.position.x - speed * Time.deltaTime,
                   gameObject.transform.position.y
                   );
                gameObject.transform.position = newPos;
            }
        }
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.CompareTag("ThneedSeed"))
        {
            seedCount++;
            seedManager.CollectSeed(); // Call the CollectSeed method in SeedManager
            Destroy(other.gameObject);
            Debug.Log("Seeds: " + seedCount);
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        // Check if the object we collided with is tagged as "Axe"
        if (collision.gameObject.CompareTag("Axe"))
        {
            // Log that the Lorax was hit
            Debug.Log("Lorax hit by axe!");
            // No need to call KnockDownLorax here
        }
    }
}
