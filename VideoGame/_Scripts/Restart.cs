using System.Collections;
using UnityEngine;
using UnityEngine.Playables;

public class Restart : MonoBehaviour
{
    public void ReplayGame()
    {
        // Load your game scene here
        UnityEngine.SceneManagement.SceneManager.LoadScene("Main Menu"); // Replace with your actual scene name
    }
}