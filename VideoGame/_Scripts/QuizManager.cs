using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class QuizManager : MonoBehaviour
{
    public List<QuestionAndAnswers> QnA;
    public GameObject[] options;
    public int currentQuestion;

    public GameObject Quizpanel;
    public GameObject GoPanel;

    public TMP_Text QuestionTxt;
    int totalQuestions = 0;
    public int score;

    [SerializeField] private Health playerHealth;

    private void Start()
    {
        totalQuestions = QnA.Count;
        GoPanel.SetActive(false);
        generateQuestion();
    }

    public void GameOver()
    {
        Quizpanel.SetActive(false);
        GoPanel.SetActive(true);
        
    }


    public void correct()
    {
        // when you are right
        score += 1;
        Debug.Log("Correct Answer Triggered in QuizManager");

        // Only remove the current question on a correct answer
        if (QnA.Count > 0)
        {
            QnA.RemoveAt(currentQuestion); // Remove the answered question
        }

        // Generate the next question
        generateQuestion();
    }

 public void IncorrectAnswer()
{
    playerHealth.TakeDamage(1);
    Debug.Log("Incorrect Answer Triggered in QuizManager");

    // Remove the current question from the list
    if (QnA.Count > 0)
    {
        QnA.RemoveAt(currentQuestion);
    }

    // Generate the next question
    generateQuestion();
}


    void SetAnswers()
    {
        for (int i = 0; i < options.Length; i++)
        {
            options[i].GetComponent<AnswerScript>().isCorrect = false;
            options[i].transform.GetChild(0).GetComponent<TMP_Text>().text = QnA[currentQuestion].Answers[i];
        
            if (QnA[currentQuestion].CorrectAnswer == i + 1)
            {
                options[i].GetComponent<AnswerScript>().isCorrect = true;
            }
        }
    }

    void generateQuestion()
    {
        // Check if there are questions left
        if (QnA.Count > 0)
        {
            // Select a new question index
            currentQuestion = Random.Range(0, QnA.Count);
            QuestionTxt.text = QnA[currentQuestion].Question;
            SetAnswers();
        }
        else
        {
            Debug.Log("Out of Questions");
            // Optionally, handle the end of the quiz here
            GameOver();
        }
    }
}
