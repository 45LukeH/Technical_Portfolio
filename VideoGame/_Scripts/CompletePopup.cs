using UnityEngine;
using UnityEngine.SceneManagement; // Add this namespace for scene management

public class CompletePopup : MonoBehaviour
{
    public GameObject popup; // Reference to the popup GameObject
    public GameObject lorax; // Reference to the Lorax GameObject

    public void ShowPopup()
    {
        Debug.Log("Showing popup"); // Debug line
        popup.SetActive(true); // Show the popup
        if (lorax != null)
        {
            lorax.SetActive(false); // Hide the Lorax
        }
        Time.timeScale = 0; // Freeze the game
    }

    public void HidePopup()
    {
        popup.SetActive(false); // Hide the popup
        if (lorax != null)
        {
            lorax.SetActive(true); // Show the Lorax again
        }
        Time.timeScale = 1; // Resume the game
    }

    // This method is called when the Play button is clicked
    public void OnPlayButtonClicked()
    {
        HidePopup(); // Unfreeze the game
        SceneManager.LoadScene("Level3"); // Load Level 3 (make sure the name matches your scene)
    }
}
