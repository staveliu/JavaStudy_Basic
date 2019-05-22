package oop_poly_hmk.onlineexam;

public class MultipleQuestion extends Question {
    private String answer;

    public MultipleQuestion(int number, String content, String answer) {
        super(number, content);
        this.answer = answer;
    }
    @Override
    public void showQuestion(){
        System.out.println("Multiple answer question.");
        System.out.println("Question number: "+super.getNumber());
        System.out.println("Question Content is: "+super.getContent());
        System.out.println("-------------------------------");
    }
    @Override
    public boolean checkAnswer(String answer){
        char[] userAnswer = answer.toCharArray();
        for (int i=0;i<userAnswer.length;i++){
            for (int j=i+1;j<userAnswer.length;j++){
                if (userAnswer[i]>userAnswer[j]) {
                    char temp = userAnswer[i];
                    userAnswer[i]=userAnswer[j];
                    userAnswer[j]=temp;
                }
            }
        }
        char[] standardAnswer = this.answer.toCharArray();
        for (int i=0;i<standardAnswer.length;i++){
            if (standardAnswer[i]!=userAnswer[i])
                return false;
        }
        return true;
    }
}
