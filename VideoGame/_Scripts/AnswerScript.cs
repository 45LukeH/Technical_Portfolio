using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AnswerScript : MonoBehaviour
{
    public bool isCorrect = false;
    public QuizManager quizManager;

public void Answers()
{
    if (isCorrect)
    {
        Debug.Log("AnswerScript: Correct Answer Clicked");
        quizManager.correct();
    }
    else
    {
        Debug.Log("AnswerScript: Wrong Answer Clicked");
        quizManager.IncorrectAnswer();
    }
}

}
