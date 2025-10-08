using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MovetoMaze : MonoBehaviour
{
    public void ChangetoLevel3()
    {
        SceneManager.LoadSceneAsync("Level 3");
    }
}
