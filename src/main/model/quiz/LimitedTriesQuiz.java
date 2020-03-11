package model.quiz;

import model.question.Question;
import model.question.QuestionList;
import model.exceptions.OutOfTriesException;
import model.exceptions.AnswerIncorrectException;

/**
 * Represents a Quiz that provides limited attempts
 */
public class LimitedTriesQuiz extends Quiz {

    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    @Override
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {

        Question q = super.curQuestion;
        int tries = q.getMaxMark();
        boolean correct = false;

        for (int i = tries; i >= 0; i--) {
            if (q.isCorrect(answer)) {
                super.markSoFar += i;
                correct = true;
                break;
            } else if (!(q.isCorrect(answer))) {
                if (i == 0) {
                    throw new OutOfTriesException("Out Of Tries!");
                } else {
                    throw new AnswerIncorrectException("Incorrect");
                }
            }
        }
        return correct ? "Correct!" : "Incorrect!";
    }
}
