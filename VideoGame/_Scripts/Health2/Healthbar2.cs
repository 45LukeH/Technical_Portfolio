using UnityEngine.UI;
using UnityEngine;

public class Healthbar2 : MonoBehaviour
{
   [SerializeField] private Health2 playerHealth;
   [SerializeField] private Image totalhealthBar;
   [SerializeField] private Image currenthealthBar;

   private void Start()
   {
    totalhealthBar.fillAmount = playerHealth.currentHealth / 10;
   }

   private void Update()
    {
        currenthealthBar.fillAmount = playerHealth.currentHealth / 10;
    }
   
}
