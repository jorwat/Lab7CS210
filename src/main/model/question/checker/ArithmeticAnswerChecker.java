package model.question.checker;

public class ArithmeticAnswerChecker extends AnswerChecker {
    private int answer;

    // EFFECTS: constructs a checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        try {
            Integer.parseInt(userResponse);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect");
        }
        return answer == Integer.parseInt(userResponse);
    }
}
