package Server;

public class quizQuestions {

    String [] questions = {"vad heter jag?"};
    String [] answers = {"Simon" , "Ramtin" , "Xantippa" , "Takuma"};

    public quizQuestions() {


    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
