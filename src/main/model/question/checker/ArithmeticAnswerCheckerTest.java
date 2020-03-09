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
        assertTrue(arithmeticAnswerChecker.checkAnswer("5"));
    }

    @Test
    void noCaseMatch() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("6"));
    }

    @Test
    void testFloat() {
        try {
            arithmeticAnswerChecker.checkAnswer("5.0");
        } catch (NumberFormatException e) {
            assertFalse(arithmeticAnswerChecker.checkAnswer("5.0"));
        }
    }

    @Test
    void testMinMax() {
        try {
            arithmeticAnswerChecker.checkAnswer("50000000000");
        } catch (NumberFormatException e) {
            assertFalse(arithmeticAnswerChecker.checkAnswer("50000000000"));
        }
    }

    @Test
    void invalidString() {
        try {
            arithmeticAnswerChecker.checkAnswer("five");
        } catch (NumberFormatException e) {
            assertFalse(arithmeticAnswerChecker.checkAnswer("five"));
        }
    }
}