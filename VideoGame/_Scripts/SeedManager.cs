using UnityEngine;

public class SeedManager : MonoBehaviour
{
    private int seedCount = 0;
    public CompletePopup completePopup; // Reference to the CompletePopup script

    public void CollectSeed()
    {
        seedCount++;
        Debug.Log("Seed Count: " + seedCount);

        // Check if the player has collected 5 seeds
        if (seedCount >= 5)
        {
            // Trigger the popup to show
            completePopup.ShowPopup();
        }
    }
}
