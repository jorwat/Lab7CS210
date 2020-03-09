package model.quiz;

import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnlimitedTriesQuizTest extends QuizTest {

    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new UnlimitedTriesQuiz(questionList);
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
            assertEquals("It took you 2 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerThatIsWrong() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            fail("Incorrect!");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("It took you 2 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            //pass
        }
    }
}