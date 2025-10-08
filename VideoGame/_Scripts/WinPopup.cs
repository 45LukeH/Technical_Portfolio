using UnityEngine;
using UnityEngine.SceneManagement;

public class WinPopup : MonoBehaviour
{
    public GameObject popup; // Reference to the popup GameObject

    // Method to show the win popup
    public void ShowPopup()
    {
        Debug.Log("Showing Win Popup"); // Debug line to verify popup call
        popup.SetActive(true); // Show the popup
        Time.timeScale = 0; // Freeze the game
    }

    // Method to hide the win popup
    public void HidePopup()
    {
        popup.SetActive(false); // Hide the popup
        Time.timeScale = 1; // Resume the game
    }

    // Method to load the next scene when the player clicks the button
    public void LoadNextLevel()
    {
        HidePopup(); // Optionally hide the popup
        SceneManager.LoadScene("WinGame"); // Replace with your next level scene name
    }
}
