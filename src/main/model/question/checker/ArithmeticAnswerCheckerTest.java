package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticAnswerCheckerTest {
    private ArithmeticAnswerChecker arithmeticAnswerChecker;

    @BeforeEach
    void runBefore() {
        arithmeticAnswerChecker = new ArithmeticAnswerChecker(5);
    }

    @Test
    void testCaseMatch() {
        try {
            assertTrue(arithmeticAnswerChecker.checkAnswer("5"));
        } catch (NumberFormatException e) {
            fail("No exception");
        }
    }

    @Test
    void noCaseMatch() {
        try {
            assertFalse(arithmeticAnswerChecker.checkAnswer("6"));
        } catch (NumberFormatException e) {
            fail("No exception");
        }

    }

    @Test
    void testFloat() {
        try {
            arithmeticAnswerChecker.checkAnswer("5.0");
            assertFalse(arithmeticAnswerChecker.checkAnswer("5.0"));
        } catch (NumberFormatException e) {
            //pass
        }
    }

    @Test
    void testMinMax() {
        try {
            arithmeticAnswerChecker.checkAnswer("50000000000");
            assertFalse(arithmeticAnswerChecker.checkAnswer("50000000000"));
        } catch (NumberFormatException e) {
            //pass
        }
    }

    @Test
    void invalidString() {
        try {
            arithmeticAnswerChecker.checkAnswer("five");
            assertFalse(arithmeticAnswerChecker.checkAnswer("five"));
        } catch (NumberFormatException e) {
            //pass
        }
    }
}