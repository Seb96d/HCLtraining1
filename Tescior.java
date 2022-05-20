import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Tescior {

    public static void main(String[] args) throws ParseException {

        ArrayList<Character> characters = new ArrayList<>(26);
        //HashMap<Character, Integer> combinatedCharacter = new HashMap();
        ArrayList<Character> cominatedCharacterArrayList = new ArrayList<>();

        //ArrayList<ArrayList> pairs = new ArrayList<>();

        char singleCombination=0;
        //char pairedCharacter = 0;
        //char xd=0;


        for(char ch = 'a'; ch<='z'; ch++) {
            characters.add(ch);
            //System.out.println(ch);
        }


        for (int i = 0; i < characters.size()-1; i++) {
            for (int j = i+1; j < characters.size()-1; j++) {
                singleCombination = (char) (characters.get(i) & characters.get(j));
                System.out.println(characters.get(i)+" and "+characters.get(j) + " gives " + singleCombination);
                cominatedCharacterArrayList.add(singleCombination);

            }
        }

        System.out.println(cominatedCharacterArrayList);

        String myCharactersRules = "<', a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
        RuleBasedCollator myCollator = new RuleBasedCollator(myCharactersRules);

        cominatedCharacterArrayList.sort(myCollator);


    }
}
