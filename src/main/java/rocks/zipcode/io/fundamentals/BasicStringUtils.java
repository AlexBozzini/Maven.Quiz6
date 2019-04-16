package rocks.zipcode.io.fundamentals;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStringUtils {
    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (char c : chars){
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(Character[] chars) {
        StringBuilder builder = new StringBuilder();
        for (Character c : chars){
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * @param string - string to be manipulated
     * @return identical string with lowercase and uppercase vowels removed
     */
    public static String removeAllVowels(String string) {
        List<Character> charList = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowelSet = new HashSet<>(Arrays.asList(vowels));
        List<Character> removedCharList = new ArrayList<>();
        for(Character c : charList){
            if (!vowelSet.contains(c)){
                removedCharList.add(c);
            }
        }
        Character[] noVowelChars = removedCharList.toArray(new Character[removedCharList.size()]);
        return getString(noVowelChars);
    }

    /**
     * @param string             - string to be manipulated
     * @param charactersToRemove - characters to be removed from string
     * @return
     */
    public static String removeSpecifiedCharacters(String string, String charactersToRemove) {
        List<Character> charList = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        char[] charsToRemove = charactersToRemove.toCharArray();
        Character[] ch = new Character[charsToRemove.length];
        for (int i = 0; i < charsToRemove.length; i++){
            ch[i] = charsToRemove[i];
        }
        Set<Character> removeSet = new HashSet<>(Arrays.asList(ch));
        List<Character> removedCharList = new ArrayList<>();
        for(Character c : charList){
            if (!removeSet.contains(c)){
                removedCharList.add(c);
            }
        }
        Character[] removedChars = removedCharList.toArray(new Character[removedCharList.size()]);
        return getString(removedChars);
    }
}
