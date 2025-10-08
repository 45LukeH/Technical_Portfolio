using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement; // Add this line


public class Health : MonoBehaviour
{
   [SerializeField] private float startingHealth;
   public float currentHealth { get; private set; }

   public void Awake()
   {
    currentHealth = startingHealth;
   }

public void TakeDamage(float _damage)
{
    currentHealth = Mathf.Clamp(currentHealth - _damage, 0, startingHealth);

    Debug.Log($"Current Health: {currentHealth}"); // Debug line to see current health

    if(currentHealth > 0)
    {
        // player hurt
        Debug.Log("Player hurt, current health: " + currentHealth);
    }
    else
    {
        // player dead
        Debug.Log("Player is dead");
        GameOver(); // Call the GameOver method when health reaches 0
    }
}

private void GameOver()
{
    // Load the GameOver scene
    SceneManager.LoadScene("GameOver"); // Ensure "GameOver" matches the scene name in your project
}



    // if E key is hit, the player will take 1 hit of damage
 //  private void Update()
 //  {
 //   if(Input.GetKeyDown(KeyCode.E))
//    TakeDamage(1);
//   }
}
