package rocks.zipcode.io.fundamentals;


import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        // get length of string
        // get range of length
        // get power-set of range

        // for every set in power-set
            // uppercase indices of string using set
        Collection<String> collection = new ArrayList<>();
        int n = string.length();
        int max = 1 << n;
        string = string.toLowerCase();
        for (int i = 0; i < max; i++){
            char[] combination = string.toCharArray();
            for (int j = 0; j < n; j++){
                if (((i >> j) & 1) == 1){
                    if (combination[j] != ' ') {
                        combination[j] = (char) (combination[j] - 32);
                    } else {
                        combination[j] = ' ';
                    }
                }
            }
            String combo = new String(combination);
            ((ArrayList<String>) collection).add(combo);
        }
        return collection;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
        char[] chars = string.toCharArray();
        StringBuilder builder = new StringBuilder();
        Set<Integer> indicesSet = new HashSet<>(Arrays.asList(indices));
        for (int i = 0; i < chars.length; i++){
            if (indicesSet.contains(i)){
                builder.append(Character.toUpperCase(chars[i]));
            } else {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {
        char[] chars = stringToBeManipulated.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length + 1; i++){
            if (i < index){
               builder.append(chars[i]);
            } else if (i == index){
                builder.append(valueToBeInserted);
            } else {
                builder.append(chars[i - 1]);
            }
        }
        return builder.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {
        char[] chars = stringToBeManipulated.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++){
            if (i != index){
                builder.append(chars[i]);
            } else {
                builder.append(replacementValue);
            }
        }
        return builder.toString();
    }
}