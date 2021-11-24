import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Questions implements Serializable {

    String categoryChosen;
    String question;
    List<String> answers;
    String correctAnswerInList;

    public Questions(String c, String q, List<String> a, String i){
        categoryChosen=c;
        question=q;
        answers =a;
        correctAnswerInList=i;
    }

    public String getCategoryChosen() {
        return categoryChosen;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswerInList() {
        return correctAnswerInList;
    }


}

