using UnityEngine;

public class SeedCollector : MonoBehaviour
{
    private int seedCount = 0; // Counter for seeds collected
    public WinPopup winPopup; // Reference to the WinPopup script

    // Method called when a seed is collected
  public void CollectSeed()
{
    seedCount++; // Increment seed count
    Debug.Log("Seed Count: " + seedCount); // Log current seed count

    if (seedCount >= 10) // Check if the player has collected 10 seeds
    {
        Debug.Log("Collected 10 seeds, triggering Win Popup"); // Log right before showing the popup
        if (winPopup != null)
        {
            winPopup.ShowPopup(); // Trigger the win popup
        }
        else
        {
            Debug.LogError("winPopup reference is missing!");
        }
    }
}

}
