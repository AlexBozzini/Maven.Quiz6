package rocks.zipcode.io.arrays;

/**
 * @author leon on 24/01/2019.
 */
public class ArrayUtils {
    /**
     * @param start - value to begin counting
     * @param end   - value to stop counting
     * @return array of all integers between `start` and `stop`
     */
    public static Integer[] getRange(Integer start, Integer end) {
        Integer[] range = new Integer[end - start + 1];
        int counter = start;
        for (int i = 0; i < range.length; i++){
            range[i] = counter;
            counter++;
        }
        return range;
    }

    /**
     * @param array - array to be unboxed
     * @return array with identical contents in primitive-array form
     */
    public static char[] unbox(Character[] array) {
        char[] unboxed = new char[array.length];
        for (int i = 0; i < unboxed.length; i++){
            unboxed[i] = array[i];
        }
        return unboxed;
    }

    /**
     * @param array - array to be boxed
     * @return array with identical contents in nonprimitive-array form
     */
    public static Character[] box(char[] array) {
        Character[] boxed = new Character[array.length];
        for (int i = 0; i < boxed.length; i++){
            boxed[i] = array[i];
        }
        return boxed;
    }
}
