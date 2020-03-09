package model.question.checker;

// checks answers to arithmetic math problems
public class ArithmeticAnswerChecker extends AnswerChecker {
    private int answer;

    // EFFECTS: constructs a checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        return answer == Integer.parseInt(userResponse);
    }
}

