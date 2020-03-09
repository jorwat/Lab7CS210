package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.question.QuestionList;

/**
 * Represents a Quiz that provides unlimited attempts
 */
public class UnlimitedTriesQuiz extends Quiz {

    public int numAttempts;

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public UnlimitedTriesQuiz(QuestionList questions) {
        super(questions);
        numAttempts = 0;
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // does not modify max mark of current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException {
        boolean correct = super.checkAnswer(answer);
        numAttempts++;
        if (correct == false) {
            throw new AnswerIncorrectException("Incorrect");
        }
        return correct ? "Correct!" : "Incorrect!";
    }

    // EFFECTS: returns number of attempts taken to answer questions so far
    public int getNumAttempts() {
        return numAttempts;
    }

    @Override
    public String endQuiz() {
        return "It took you " + getNumAttempts() + " attempts to answer "
                + questions.length() + " questions correctly.";
    }
}
