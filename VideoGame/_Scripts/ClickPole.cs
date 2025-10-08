using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ClickPole : MonoBehaviour
{
    public void PoleClicked()
    {
        SceneManager.LoadSceneAsync("Level 1");
    }

}
