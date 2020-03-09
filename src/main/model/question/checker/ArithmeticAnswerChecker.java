package model.question.checker;

public class ArithmeticAnswerChecker extends AnswerChecker {
    private int answer;

    // EFFECTS: constructs a checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        boolean result;
        try {
            result = answer == Integer.parseInt(userResponse);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
}
