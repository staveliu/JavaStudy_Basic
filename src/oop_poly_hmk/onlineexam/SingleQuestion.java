package oop_poly_hmk.onlineexam;

public class SingleQuestion extends Question {
    private String answer;

    public SingleQuestion(int number, String content, String answer) {
        super(number, content);
        this.answer = answer;
    }
    @Override
    public void showQuestion(){
        System.out.println("Single answer question.");
        System.out.println("Question number: "+super.getNumber());
        System.out.println("Question Content is: "+super.getContent());
        System.out.println("-------------------------------");
    }
    @Override
    public boolean checkAnswer(String answer) {
        char[] standardAnswer = this.answer.toCharArray();
        char[] userAnswer = answer.toCharArray();
        if (standardAnswer[0]==userAnswer[0])
            return true;
        else
            return false;
    }
}
