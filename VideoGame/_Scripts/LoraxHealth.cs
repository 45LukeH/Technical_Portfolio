using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LoraxHealth : MonoBehaviour
{
    public int maxLives = 3;
    private int currentLives;

    // Start is called before the first frame update
    void Start()
    {
        currentLives = maxLives;
    }

    // Update is called once per frame
   public void TakeDamage(int damage)
    {
        currentLives -= damage;

        if (currentLives <= 0)
        {
            Debug.Log("Lorax is dead!");

            //Dana please create a game over scene once this code executes
            //SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
        }
        else
        {
            Debug.Log("Lorax has " + currentLives + " lives left.");
        }
    }
}
