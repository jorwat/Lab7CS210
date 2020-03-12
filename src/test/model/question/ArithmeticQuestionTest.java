package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticQuestionTest extends QuestionTest {
    private Question question2;
    private Question question3;

    @BeforeEach
    void runBefore() {
        question = new ArithmeticQuestion
                (5, ArithmeticQuestion.Operation.ADDITION, 3,4);
        question2 = new ArithmeticQuestion
                (5, ArithmeticQuestion.Operation.SUBTRACTION, 3,4);
        question3 = new ArithmeticQuestion
                (5, ArithmeticQuestion.Operation.MULTIPLICATION, 3,4);
    }

    @Test
    void testConstructor() {
        assertEquals(5, question.getMaxMark());
        assertEquals("What is 3 + 4 ? [5 points]", question.getQuestionString());
        assertEquals(7, ArithmeticQuestion.calculateAnswer
                (ArithmeticQuestion.Operation.ADDITION,3,4));
        assertEquals(5, question2.getMaxMark());
        assertEquals("What is 3 - 4 ? [5 points]", question2.getQuestionString());
        assertEquals(-1, ArithmeticQuestion.calculateAnswer
                (ArithmeticQuestion.Operation.SUBTRACTION,3,4));
        assertEquals(5, question3.getMaxMark());
        assertEquals("What is 3 * 4 ? [5 points]", question3.getQuestionString());
        assertEquals(12, ArithmeticQuestion.calculateAnswer
                (ArithmeticQuestion.Operation.MULTIPLICATION,3,4));

    }

    @Test
    void testCheckAnswerCorrect() {
        assertTrue(question.isCorrect("7"));
        assertTrue(question2.isCorrect("-1"));
        assertTrue(question3.isCorrect("12"));
    }

    @Test
    void testCheckAnswerIncorrect() {
        assertFalse(question.isCorrect("5"));
        assertFalse(question2.isCorrect("5"));
        assertFalse(question3.isCorrect("5"));
    }
}
