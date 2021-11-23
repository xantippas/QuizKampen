import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseOfQuestions {
    List<String> cats = new ArrayList<>();

    Questions h1 = new Questions("Vilken stad var den första kapitalen i USA?", historyQ1Answers(), "new york");
    Questions h2 = new Questions("Vem upptäckte Amerika?", historyQ2Answers(),"leif eriksson");
    Questions h3 = new Questions("Vad hette Christofer Columbus skepp?", historyQ3Answers(), "Santa Maria, Santa Clara och Pinta");
    Questions h4 = new Questions("Vad var det som startade den stora branden i Chicago 1871?", historyQ4Answers(), "Det är fortfarande oklart");

    Questions s1 = new Questions("Vad är den viktigaste gasen för liv?", scienceQ1Answers(), "syre");
    Questions s2 = new Questions("Vilken planet är närmst solen?", scienceQ2Answers(),"mercurius");
    Questions s3 = new Questions("Hur många tänder har en vuxen person?", scienceQ3Answers(), "34");
    Questions s4 = new Questions("Vilken är den största planeten i vårt solsystem?", scienceQ4Answers(), "jupiter");

    Questions g1 = new Questions("Vad hette världens första spel?", gamingQ1Answers(), "pong");
    Questions g2 = new Questions("Vilken är världens mest bästsäljande spelkonsol?", gamingQ2Answers(),"playstation 2");
    Questions g3 = new Questions("Hur många gamers finns det i USA?", gamingQ3Answers(), "183 miljoner");
    Questions g4 = new Questions("Vad var ursprungstanken med spelet The Sims?", gamingQ4Answers(),"Det skulle funka som en architektur simulator");

    List<Questions> question = new ArrayList<>();

    public List<String> gamingQ1Answers(){
        List<String> a = new ArrayList<>();
        a.add("Pong");
        a.add("Tetris");
        a.add("Super Mario");
        a.add("Minecraft");

        return a;
    }

    public List<String> gamingQ2Answers(){
        List<String> a = new ArrayList<>();
        a.add("Super Nintendo");
        a.add("Playstation 4");
        a.add("Playstation 2");
        a.add("Nintendo-64");

        return a;
    }

    public List<String> gamingQ3Answers(){
        List<String> a = new ArrayList<>();
        a.add("55 miljoner");
        a.add("183 miljoner");
        a.add("92 miljoner");
        a.add("500 tusen");

        return a;
    }

    public List<String> gamingQ4Answers(){
        List<String> a = new ArrayList<>();
        a.add("Det skulle funka som en architektur simulator");
        a.add("Simulera världen");
        a.add("Få bossa runt människor");
        a.add("Skapa Kaos");

        return a;
    }

    public List<String> historyQ1Answers(){
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("New York");
        a.add("C");
        a.add("D");

        return a;
    }

    public List<String> historyQ2Answers(){
        List<String> a = new ArrayList<>();
        a.add("Leif Eriksson");
        a.add("B");
        a.add("C");
        a.add("D");

        return a;
    }

    public List<String> historyQ3Answers(){
        List<String> a = new ArrayList<>();
        a.add("Santa Maria, Santa Clara och Pinta");
        a.add("B");
        a.add("C");
        a.add("D");

        return a;
    }

    public List<String> historyQ4Answers(){
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("Det är fortfarande oklart");

        return a;
    }

    public List<String> scienceQ1Answers(){
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("Syre");
        a.add("");

        return a;
    }

    public List<String> scienceQ2Answers(){
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("Mercurius");
        a.add("C");
        a.add("");

        return a;
    }

    public List<String> scienceQ3Answers(){
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("34");
        a.add("C");
        a.add("");

        return a;
    }

    public List<String> scienceQ4Answers(){
        List<String> a = new ArrayList<>();
        a.add("Jupiter");
        a.add("B");
        a.add("C");
        a.add("");

        return a;
    }

    public List<Questions> historyCategoryQs(){
        question = new ArrayList<>();
        question.add(h1);
        question.add(h2);
        question.add(h3);
        question.add(h4);
        return question;
    }

    public List<Questions> scienceCategoryQs(){
        question = new ArrayList<>();
        question.add(s1);
        question.add(s2);
        question.add(s3);
        question.add(s4);
        return question;
    }

    public List<Questions> gamingCategoryQs(){
        question = new ArrayList<>();
        question.add(g1);
        question.add(g2);
        question.add(g3);
        question.add(g4);
        return question;
    }

    public List<String> myCategories(){
        cats.add("History");
        cats.add("Science");
        cats.add("Gaming");
        return cats;
    }

}
