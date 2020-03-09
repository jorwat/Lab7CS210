package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticQuestionTest extends QuestionTest {
    private ArithmeticQuestion arithmeticQuestion;

    @BeforeEach
    void runBefore() {
        arithmeticQuestion = new ArithmeticQuestion(5, ArithmeticQuestion.Operation.ADDITION, 3,4);
        question = arithmeticQuestion;
    }

    @Test
    void testConstructor() {
        assertEquals(5, arithmeticQuestion.getMaxMark());
        assertEquals("What is 3 + 4 ? [5 points]", arithmeticQuestion.getQuestionString());
        assertEquals(7, ArithmeticQuestion.calculateAnswer
                (ArithmeticQuestion.Operation.ADDITION,3,4));
    }

    @Test
    void testCheckAnswerCorrect() {
        assertTrue(arithmeticQuestion.isCorrect("7"));
    }

    @Test
    void testCheckAnswerIncorrect() {
        assertFalse(arithmeticQuestion.isCorrect("5"));
    }
}
