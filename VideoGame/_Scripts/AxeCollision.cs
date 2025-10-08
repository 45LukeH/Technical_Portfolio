using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AxeCollision : MonoBehaviour
{
    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Lorax"))
        {
            LoraxHealth loraxHealth = collision.GetComponent<LoraxHealth>();
            if (loraxHealth != null)
            {
                loraxHealth.TakeDamage(1);
            }
            Destroy(gameObject);
        }
    }
}
