using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement; // Import this for scene management

public class Health3 : MonoBehaviour
{
    [SerializeField] private float startingHealth = 3f; // Total starting health (3 hearts)
    public float currentHealth { get; private set; }

    private void Awake()
    {
        currentHealth = startingHealth;
    }

    public void TakeDamage(float _damage)
    {
        currentHealth = Mathf.Clamp(currentHealth - _damage, 0, startingHealth);
        
        if (currentHealth > 0)
        {
            // Player hurt
            Debug.Log("Player hurt! Current Health: " + currentHealth);
        }
        else
        {
            // Player dead
            Debug.Log("Player is dead!");
            GameOver(); // Call GameOver method
        }
    }

    private void GameOver()
    {
        // Load the Game Over scene
        SceneManager.LoadScene("GameOver"); // Make sure this matches your Game Over scene name
    }

    public void Update()
    {
        // Removed E key damage handling
        // if(Input.GetKeyDown(KeyCode.E))
        //     TakeDamage(1);
    }
}
