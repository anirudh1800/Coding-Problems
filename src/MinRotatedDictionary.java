/**
 * Created by agali on 6/26/16.
 */

public class MinRotatedDictionary {

    public static void main(String args[]) {
        // our dictionary of words
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "xyz",
                "aaa",
                "abc",
                "anirudh",
                "asymptote",
                "babka",
                "banoffe",
                "engender",
                "karpatka",
        };

        System.out.println("Start element at '" + (dictStart(words) + 1) + "' position");
    }

    // Iterative Binary Search Algorithm: Complexity O(Logn)
    static int dictStart(String[] words) {
        int low = 0, mid = 0, high = words.length - 1;

        // return if array has only single element
        if (high == low)
            return high;

        while (low <= high) {
            mid = (low + high) / 2;

            // check if the mid is the minimum element
            if (mid < high && (words[mid + 1].compareTo(words[mid]) < 0)) {
                return mid + 1;
            }

            if (mid > low && (words[mid - 1].compareTo(words[mid]) > 0)) {
                return mid;
            }

            // if mid is not minimum element, goto other half of the array
            if (words[high].compareTo(words[mid]) > 0) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return mid;
    }

}