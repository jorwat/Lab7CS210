package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitedTriesQuizTest extends QuizTest {
    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new LimitedTriesQuiz(questionList);
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals(2, quiz.questions.length());
        assertEquals(6, quiz.getMaxMark());
    }

    @Test
    void testSubmitAnswerAllCorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 6 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerWithTries() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            fail("Incorrect!");
            assertEquals("Incorrect!", feedback);
            assertEquals(3, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("Ert");
            assertEquals("Incorrect!", feedback);
            assertEquals(2, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(2, quiz.getMarkSoFar());
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertFalse(quiz.hasMoreQuestions());
            assertEquals(".", quiz.endQuiz());
        } catch (Exception e) {
        }
    }

    @Test
    void testSubmitAnswerAndFail() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            fail("Incorrect");
            assertEquals("Incorrect!", feedback);
            assertEquals(3, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("Ert");
            fail("Incorrect");
            assertEquals("Incorrect!", feedback);
            assertEquals(2, quiz.curQuestion.getMaxMark());
            feedback = quiz.submitAnswer("mars");
            fail("Incorrect");
            assertEquals("Incorrect!", feedback);
            assertEquals(1, quiz.getMarkSoFar());
            feedback = quiz.submitAnswer("moon");
            fail("Incorrect");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Out of Tries");
            assertEquals(".", quiz.endQuiz());
        } catch (OutOfTriesException e) {
            //pass
        } catch (AnswerIncorrectException e) {
            //pass
        }
    }
}
