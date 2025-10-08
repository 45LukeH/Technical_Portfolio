using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LoraxMazeMover : MonoBehaviour
{
    public float speed;  // speed of the Lorax movement
    public Camera mainCamera;  // reference to the main camera
    public Vector3 cameraOffset = new Vector3(0, 0, -10);  // offset to maintain camera distance

    // Start is called before the first frame update
    void Start()
    {
        // Find the main camera if not assigned in the Inspector
        if (mainCamera == null)
        {
            mainCamera = Camera.main;
        }
    }

    // Update is called once per frame to handle Lorax movement
    void Update()
    {
        if (Input.GetKey(KeyCode.RightArrow))
        {
            Vector2 newPos = new Vector2(
               gameObject.transform.position.x + speed * Time.deltaTime,
               gameObject.transform.position.y
            );
            gameObject.transform.position = newPos;
        }

        if (Input.GetKey(KeyCode.LeftArrow))
        {
            Vector2 newPos = new Vector2(
               gameObject.transform.position.x - speed * Time.deltaTime,
               gameObject.transform.position.y
            );
            gameObject.transform.position = newPos;
        }

        if (Input.GetKey(KeyCode.UpArrow))
        {
            Vector2 newPos = new Vector2(
               gameObject.transform.position.x,
               gameObject.transform.position.y + speed * Time.deltaTime
            );
            gameObject.transform.position = newPos;
        }

        if (Input.GetKey(KeyCode.DownArrow))
        {
            Vector2 newPos = new Vector2(
               gameObject.transform.position.x,
               gameObject.transform.position.y - speed * Time.deltaTime
            );
            gameObject.transform.position = newPos;
        }
    }

    // Remove or comment out the LateUpdate method
    /*
    void LateUpdate()
    {
        if (mainCamera != null)
        {
            Vector3 cameraNewPos = gameObject.transform.position + cameraOffset;
            mainCamera.transform.position = cameraNewPos;
        }
    }
    */
}
