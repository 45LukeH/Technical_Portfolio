using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MovetoRiver : MonoBehaviour
{
    public void ChangetoLevel1()
    {
        SceneManager.LoadSceneAsync("Level 2");
    }
}
