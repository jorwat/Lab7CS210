package model.question;

import model.question.checker.ArithmeticAnswerChecker;

// represents an addition, subtraction, or multiplication question with two operands
public class ArithmeticQuestion extends Question {
    public enum Operation { ADDITION, SUBTRACTION, MULTIPLICATION }

    // REQUIRES: maxMark must be >= 0 and operation must exist
    // EFFECTS: constructs arithmetic question with given maximum mark, question statement
    // and correct answer
    public ArithmeticQuestion(int maxMark, Operation operation, int firstOp, int secondOp) {
        super(maxMark,makeQuestionString(operation,firstOp,secondOp),
                new ArithmeticAnswerChecker(calculateAnswer(operation,firstOp,secondOp)));
    }

    // EFFECTS: returns question string  with operations
    public static String makeQuestionString(Operation operation, int firstOp, int secondOp) {
        String result = "";

        if (operation == Operation.ADDITION) {
            result = "What is " + firstOp + " + " + secondOp + " ?";
        } else if (operation == Operation.SUBTRACTION) {
            result = "What is " + firstOp + " - " + secondOp + " ?";
        } else if (operation == Operation.MULTIPLICATION) {
            result = "What is " + firstOp + " * " + secondOp + " ?";
        }
        return result;
    }

    // EFFECTS: adds the two operands based on the operation
    public static int calculateAnswer(Operation operation, int firstOp, int secondOp) {
        int result = 0;

        switch (operation) {
            case ADDITION:
                result =  firstOp + secondOp;
                break;

            case SUBTRACTION:
                result = firstOp - secondOp;
                break;

            case MULTIPLICATION:
                result = firstOp * secondOp;
                break;
        }
        return result;
    }
}
