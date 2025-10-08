using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FallingObjectsSpawner : MonoBehaviour
{
    public GameObject thneedSeedPrefab;
    public GameObject axePrefab;
    public float spawnInterval = 0.5f;  // Spawn one object every 0.5 seconds
    public float minX;
    public float maxX;
    public float spawnY;
    public int maxActiveObjects = 10;  // Limit the number of active objects

    private List<GameObject> activeObjects = new List<GameObject>();
    private bool isSpawning = false;  // Prevent multiple coroutines from starting

    // Start is called before the first frame update
    void Start()
    {
        if (!isSpawning)
        {
            StartCoroutine(SpawnObjects());
            isSpawning = true;
        }
    }

    IEnumerator SpawnObjects()
    {
        while (true)
        {
            // Ensure we spawn only one object every spawnInterval
            if (activeObjects.Count < maxActiveObjects)
            {
                GameObject objectToSpawn;

                // 25% chance of spawning axe and 75% for thneedSeed
                if (Random.value > 0.75f)
                {
                    objectToSpawn = thneedSeedPrefab;
                }
                else
                {
                    objectToSpawn = axePrefab;
                }

                float randomX = Random.Range(minX, maxX);
                Vector2 spawnPosition = new Vector2(randomX, spawnY);

                // Instantiate object and add it to activeObjects list
                GameObject spawnedObject = Instantiate(objectToSpawn, spawnPosition, Quaternion.identity);
                activeObjects.Add(spawnedObject);

                // Start the process to destroy the object after 10 seconds
                StartCoroutine(DestroyObjectAfterTime(spawnedObject, 4f));
            }

            yield return new WaitForSeconds(spawnInterval);  // Wait for spawn interval
        }
    }

    IEnumerator DestroyObjectAfterTime(GameObject obj, float time)
    {
        yield return new WaitForSeconds(time);

        if (obj != null)
        {
            // Remove the object from the list and destroy it
            activeObjects.Remove(obj);
            Destroy(obj);
        }
    }

    // Call this method when an object (e.g., a seed) is collected by the player
    public void OnObjectCollected(GameObject obj)
    {
        // Ensure the object is removed from the activeObjects list when collected
        if (activeObjects.Contains(obj))
        {
            activeObjects.Remove(obj);
        }
        Destroy(obj);  // Destroy the collected object
    }
}
