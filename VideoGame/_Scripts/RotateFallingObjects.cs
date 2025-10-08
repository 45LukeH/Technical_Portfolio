using UnityEngine;

public class RotateFallingObject : MonoBehaviour
{
    public float rotationSpeed = 100f;  // Speed of rotation in degrees per second

    void Update()
    {
        // Rotate counterclockwise around the Z-axis (for 2D)
        transform.Rotate(0, 0, rotationSpeed * Time.deltaTime);
    }
}
