using UnityEngine;

public class ThneedSeed : MonoBehaviour
{
    public float rotationSpeed = 50f;
    private SeedCollector seedCollector; // Reference to SeedCollector

    void Start()
    {
        // Find the SeedCollector in the scene (make sure it exists in the scene!)
        seedCollector = FindObjectOfType<SeedCollector>();

        if (seedCollector == null)
        {
            Debug.LogError("SeedCollector not found in the scene!");
        }
    }

    void Update()
    {
        // Rotate the seed for visual effect
        transform.Rotate(0f, 0f, rotationSpeed * Time.deltaTime);
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.CompareTag("Lorax")) // Make sure the Lorax GameObject is tagged correctly
        {
            Debug.Log("Seed collected");
            if (seedCollector != null)
            {
                seedCollector.CollectSeed(); // Call CollectSeed() in SeedCollector
            }

            Destroy(gameObject); // Destroy the seed after collection
        }
    }
}
