package model.quiz;

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

        int tries = curQuestion.getMaxMark();
        boolean correct = false;

        if (this.curQuestion.isCorrect(answer)) {
            this.markSoFar += tries;
            correct = true;
        } else if (!(this.curQuestion.isCorrect(answer))) {
            if (tries == 0) {
                throw new OutOfTriesException("Out of Tries");
            }
        } else {
            tries--;
            throw new AnswerIncorrectException("Incorrect");
        }
        return correct ? "Correct!" : "Incorrect!";
    }
}
