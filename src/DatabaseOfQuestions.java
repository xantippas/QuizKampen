import java.util.ArrayList;
import java.util.List;

public class DatabaseOfQuestions {
    List<String> cats = new ArrayList<>();

    Questions h1 = new Questions("Historia","Vilken stad var den första kapitalen i USA?", historyQ1Answers(), "new york");
    Questions h2 = new Questions("Historia","Vem upptäckte Amerika?", historyQ2Answers(),"leif eriksson");
    Questions h3 = new Questions("Historia","Vad hette Christofer Columbus skepp?", historyQ3Answers(), "Santa Maria, Santa Clara och Pinta");
    Questions h4 = new Questions("Historia","Vad var det som startade den stora branden i Chicago 1871?", historyQ4Answers(), "Det är fortfarande oklart");

    Questions s1 = new Questions("Naturvetenskap","Vad är den viktigaste gasen för liv?", scienceQ1Answers(), "syre");
    Questions s2 = new Questions("Naturvetenskap","Vilken planet är närmst solen?", scienceQ2Answers(),"mercurius");
    Questions s3 = new Questions("Naturvetenskap","Hur många tänder har en vuxen person?", scienceQ3Answers(), "34");
    Questions s4 = new Questions("Naturvetenskap","Vilken är den största planeten i vårt solsystem?", scienceQ4Answers(), "jupiter");

    Questions g1 = new Questions("Spel","Vad hette världens första spel?", gamingQ1Answers(), "pong");
    Questions g2 = new Questions("Spel","Vilken är världens mest bästsäljande spelkonsol?", gamingQ2Answers(),"playstation 2");
    Questions g3 = new Questions("Spel","Hur många gamers finns det i USA?", gamingQ3Answers(), "183 miljoner");
    Questions g4 = new Questions("Spel","Vad var ursprungstanken med spelet The Sims?", gamingQ4Answers(),"Det skulle funka som en architektur simulator");

    Questions m1 = new Questions("Musik","Vilket år dog Elvis Presley?", musicQ1Answers(), "1977");
    Questions m2 = new Questions("Musik","Vilket fängelse sjöng Johnny Cash om i sin låt från 1955?", musicQ2Answers(), "Folsom Prison");
    Questions m3 = new Questions("Musik","Vad är namnet på duetten som spelades in av Robbie Williams och Gary Barlow år 2010?", musicQ3Answers(), "Shame");
    Questions m4 = new Questions("Musik","Vilket rockband grundades av Trent Reznor år 1988?", musicQ4Answers(), "Nine Inch Nails");

    List<Questions> question = new ArrayList<>();

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

    public List<Questions> musicCategoryQs(){
        question = new ArrayList<>();
        question.add(m1);
        question.add(m2);
        question.add(m3);
        question.add(m4);
        return question;
    }

    public List<String> myCategories(){
        cats.add("Historia");
        cats.add("Naturvetenskap");
        cats.add("Spel");
        cats.add("Musik");
        return cats;
    }

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
        a.add("Washington");
        a.add("New York");
        a.add("Miami");
        a.add("San Franscisco");

        return a;
    }

    public List<String> historyQ2Answers(){
        List<String> a = new ArrayList<>();
        a.add("Leif Eriksson");
        a.add("Christoffer Columbus");
        a.add("George Washington");
        a.add("Thomas Jefferson");

        return a;
    }

    public List<String> historyQ3Answers(){
        List<String> a = new ArrayList<>();
        a.add("Santa Maria, Santa Clara och Pinta");
        a.add("Piff, Paff och Puff");
        a.add("Saint John, Saint Mary");
        a.add("The Blackpearl");

        return a;
    }

    public List<String> historyQ4Answers(){
        List<String> a = new ArrayList<>();
        a.add("En fabrik brann upp");
        a.add("Ett upplopp orskade branden");
        a.add("En pyroman");
        a.add("Det är fortfarande oklart");

        return a;
    }

    public List<String> scienceQ1Answers(){
        List<String> a = new ArrayList<>();
        a.add("Koldioxid");
        a.add("Helium");
        a.add("Syre");
        a.add("H20");

        return a;
    }

    public List<String> scienceQ2Answers(){
        List<String> a = new ArrayList<>();
        a.add("Venus");
        a.add("Mercurius");
        a.add("Pluto");
        a.add("Mars");

        return a;
    }

    public List<String> scienceQ3Answers(){
        List<String> a = new ArrayList<>();
        a.add("19");
        a.add("34");
        a.add("25");
        a.add("44");

        return a;
    }

    public List<String> scienceQ4Answers(){
        List<String> a = new ArrayList<>();
        a.add("Jupiter");
        a.add("Uranus");
        a.add("Mercurius");
        a.add("Saturnus");

        return a;
    }

    public List<String> musicQ1Answers(){
        List<String> a = new ArrayList<>();
        a.add("1976");
        a.add("1981");
        a.add("2006");
        a.add("1977");

        return a;
    }

    public List<String> musicQ2Answers(){
        List<String> a = new ArrayList<>();
        a.add("Walnut Grove");
        a.add("The ADX");
        a.add("Bangkok Hilton");
        a.add("Folsom Prison");

        return a;
    }

    public List<String> musicQ3Answers(){
        List<String> a = new ArrayList<>();
        a.add("Two birds with one stone");
        a.add("No I in team");
        a.add("Smells like teen spirits");
        a.add("Shame");

        return a;
    }

    public List<String> musicQ4Answers(){
        List<String> a = new ArrayList<>();
        a.add("Linking Park");
        a.add("Red Hot Chilipeppers");
        a.add("Wonderwall");
        a.add("Nine Inch Nails");

        return a;
    }

}
