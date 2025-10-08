using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OncelerFollowLorax : MonoBehaviour
{
    public float speed;
    public GameObject player;
    public float damage = 0.5f; // Set damage to half a heart
    private Health3 playerHealth; // Change this to Health3 if it matches your health script
    private Vector3 startingPosition;
    private bool isFacingRight = true; // Track the Onceler’s facing direction
    public Vector2 randomSpawnRangeX = new Vector2(-10f, 10f); // X-axis range for random spawn
    public Vector2 randomSpawnRangeY = new Vector2(-5f, 5f);   // Y-axis range for random spawn

    // Start is called before the first frame update
    void Start()
    {
        player = GameObject.FindGameObjectWithTag("Lorax");

        if (player != null)
        {
            playerHealth = player.GetComponent<Health3>(); // Use Health3 if that's your health script
        }

        startingPosition = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        if (player != null)
        {
            Vector3 direction = player.transform.position - transform.position;
            direction.Normalize();
            transform.position += direction * speed * Time.deltaTime;

            // Handle horizontal flipping
            if ((direction.x < 0 && isFacingRight) || (direction.x > 0 && !isFacingRight))
            {
                Flip();
            }
        }
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.CompareTag("Lorax"))
        {
            if (playerHealth != null)
            {
                playerHealth.TakeDamage(damage); // Now takes half a heart
            }

            // Randomize spawn position after collision with Lorax
            float randomX = Random.Range(randomSpawnRangeX.x, randomSpawnRangeX.y);
            float randomY = Random.Range(randomSpawnRangeY.x, randomSpawnRangeY.y);
            transform.position = new Vector3(randomX, randomY, transform.position.z);
        }
    }

    // Function to flip the Onceler horizontally
    void Flip()
    {
        isFacingRight = !isFacingRight;
        Vector3 localScale = transform.localScale;
        localScale.x *= -1; // Flip the x scale to create the flip effect
        transform.localScale = localScale;
    }
}
