package Server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {

    List<List<String>> science = new ArrayList<>();
    List<List<String>> gaming = new ArrayList<>();
    List<List<String>> history = new ArrayList<>();
    List<List<String>> music = new ArrayList<>();

    List<String> category = Arrays.asList(
            "science", "gaming", "history", "music"
    );

    public Questions returnQuestions() {
        return this;
    }

    public List<String> getCategory() {
        return this.category;
    }

    public void scienceQuestions(){

        List<String> scienceQ = new ArrayList<>();
        List<String> scienceA = new ArrayList<>();


        scienceQ.add("Vad är den viktigaste gasen för liv?");
        scienceQ.add("Vilken planet är närmst solen?");
        scienceQ.add("Hur många tänder har en vuxen person?");
        scienceQ.add(("Vilken är den största planeten i vårt solsystem?"));

        scienceA.add(("Syre"));
        scienceA.add(("Mercurius"));
        scienceA.add(("34"));
        scienceA.add(("Jupiter"));

        List<String> scienceBogusA;
        List<String> scienceBogusB;
        List<String> scienceBogusC;
        List<String> scienceBogusD;

        scienceBogusA = Arrays.asList("Koldioxid", "Helium", "H20");
        scienceBogusB = Arrays.asList("Venus", "Pluto", "Mars");
        scienceBogusC = Arrays.asList("19", "25", "44");
        scienceBogusD = Arrays.asList("Uranus", "Mercurius", "Saturnus");
        
        science.add(scienceQ);
        science.add(scienceA);
        science.add(scienceBogusA);
        science.add(scienceBogusB);
        science.add(scienceBogusC);
        science.add(scienceBogusD);

    }

    public void gamingQuestions(){

        List<String> gamingQ = new ArrayList<>();
        List<String> gamingA = new ArrayList<>();

        List<String> gamingBogus = new ArrayList<>();

        gamingQ.add(("Vad hette världens första spel?"));
        gamingQ.add(("Vilken är världens mest bästsäljande spelkonsol?"));
        gamingQ.add(("Hur många gamers finns det i USA?"));
        gamingQ.add(("Vad var ursprungstanken med spelet The Sims?"));

        gamingA.add(("Pong"));
        gamingA.add(("Playstation 2"));
        gamingA.add(("183 miljoner"));
        gamingA.add(("Det skulle funka som en architektur simulator"));

        List<String> gamingBogusA;
        List<String> gamingBogusB;
        List<String> gamingBogusC;
        List<String> gamingBogusD;

        gamingBogusA = Arrays.asList("Tetris" , "Super Mario" , "Minecraft");
        gamingBogusB = Arrays.asList("Super Nintendo" , "Playstation 4", "Nintendo-64");
        gamingBogusC = Arrays.asList("55 miljoner", "92 miljoner", "500 tusen");
        gamingBogusD = Arrays.asList("Simulera världen", "Få bossa runt människor", "Skapa kaos");

        gaming.add(gamingQ);
        gaming.add(gamingQ);
        gaming.add(gamingBogusA);
        gaming.add(gamingBogusB);
        gaming.add(gamingBogusC);
        gaming.add(gamingBogusD);


    }

    public void historyQuestions(){

        List<String> historyQ = new ArrayList<>();
        List<String> historyA = new ArrayList<>();
        List<String> historyBogus = new ArrayList<>();

        historyQ.add(("Vilken stad var den första kapitalen i USA?"));
        historyQ.add(("Vem upptäckte Amerika?"));
        historyQ.add(("Vad hette Columbus skepp?"));
        historyQ.add(("Vad var det som startade den stora branden i Chicago 1871?"));

        historyA.add(("New York"));
        historyA.add(("Leif Erikson"));
        historyA.add(("Santa Maria, Santa Clara och Pinta"));
        historyA.add(("Det är fortfarande oklart"));

        List<String> historyBogusA;
        List<String> historyBogusB;
        List<String> historyBogusC;
        List<String> historyBogusD;

        historyBogusA = Arrays.asList("Washington", "Miami", "San Franscisco");
        historyBogusB = Arrays.asList("Christoffer Columbus", "George Washington", "Thomas Jefferson");
        historyBogusC = Arrays.asList("Piff, Paff och Puff", "Saint John, Saint Mary", "The Blackpearl");
        historyBogusD = Arrays.asList("En pyroman", "Ett upplopp orskade branden", "En fabrik brann upp");

        history.add(historyQ);
        history.add(historyA);
        history.add(historyBogusA);
        history.add(historyBogusB);
        history.add(historyBogusC);
        history.add(historyBogusD);
    }


    public void musicQuestions(){

        List<String> musicQ = new ArrayList<>();
        List<String> musicA = new ArrayList<>();
        List<String> musicBogus = new ArrayList<>();


        musicQ.add(("Vilket år dog Elvis Presley?"));
        musicQ.add(("Vilket fängelse sjöng Johnny Cash om i sin låt från 1955?"));
        musicQ.add(("Vad är namnet på duetten som spelades in av Robbie Williams och Gary Barlow år 2010?"));
        musicQ.add(("Vilket rockband grundades av Trent Reznor år 1988?"));

        musicA.add(("1977"));
        musicA.add(("Folsom Prison"));
        musicA.add(("Shame"));
        musicA.add(("Nine Inch Nails"));

        List<String> musicBogusA;
        List<String> musicBogusB;
        List<String> musicBogusC;
        List<String> musicBogusD;

        musicBogusA = Arrays.asList("2006", "1976", "1981");
        musicBogusB = Arrays.asList("Walnut Grove", "The ADX", "Bangkok Hilton");
        musicBogusC = Arrays.asList("Two birds with one stone", "No I in team", "Smells like teen spirits");
        musicBogusD = Arrays.asList("Linking Park", "Red Hot Chilipeppers", "Wonderwall");

        music.add(musicQ);
        music.add(musicA);
        music.add(musicBogusA);
        music.add(musicBogusB);
        music.add(musicBogusC);
        music.add(musicBogusD);


    }
}
