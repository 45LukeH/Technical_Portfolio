using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Health2 : MonoBehaviour
{
    [SerializeField] private float startingHealth = 3; // Total health
    public float currentHealth { get; private set; }
    private Rigidbody2D rb;

    private void Awake()
    {
        currentHealth = startingHealth;
        rb = GetComponent<Rigidbody2D>();

        // Start with gravity disabled to prevent falling
        rb.gravityScale = 0;
    }

    public void TakeDamage(float _damage)
    {
        currentHealth = Mathf.Clamp(currentHealth - _damage, 0, startingHealth);

        if (currentHealth > 0)
        {
            Debug.Log("Lorax hurt! Health remaining: " + currentHealth);
        }
        else
        {
            Debug.Log("Lorax is out of lives. Game Over.");
            StartCoroutine(FlyOffScreen()); // Start coroutine to move off-screen
        }
    }

private IEnumerator FlyOffScreen()
{
    // Disable Rigidbody2D movement
    rb.velocity = Vector2.zero; // Stop any current movement
    rb.isKinematic = true; // Make Rigidbody kinematic to prevent physics interaction

    Vector3 targetPosition = new Vector3(-10f, transform.position.y, transform.position.z); // Target position off-screen
    float duration = 2f; // Duration of the transition
    float elapsed = 0f;

    // Gradual rotation speed
    float rotationSpeed = 30f; // Degrees per second

    // Move the Lorax off-screen smoothly
    while (elapsed < duration)
    {
        // Calculate new position using Lerp for smooth transition
        transform.position = Vector3.Lerp(transform.position, targetPosition, elapsed / duration);
        
        // Apply gradual rotation
        transform.Rotate(new Vector3(0, 0, rotationSpeed * Time.deltaTime));

        elapsed += Time.deltaTime;
        yield return null; // Wait for the next frame
    }

    // Ensure the Lorax is at the target position after finishing
    transform.position = targetPosition;

    // Load GameOver scene after a short delay
    Invoke(nameof(GoToGameOverScene), 1f);
}

    private void GoToGameOverScene()
    {
        SceneManager.LoadScene("GameOver");
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        // Check if the collided object has the tag "Axe"
        if (collision.gameObject.CompareTag("Axe"))
        {
            TakeDamage(1); // Deal 1 damage per axe hit
            Destroy(collision.gameObject); // Destroy the axe after hit
        }
    }
}
