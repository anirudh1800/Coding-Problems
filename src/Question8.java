import java.util.*;

/**
 * Created by agali on 3/4/16.
 */

public class Question8 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        HashSet<Character> duplicates = new HashSet<>();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (hm.containsKey(c)) {
                int val = hm.get(c);

                hm.put(c, val + 1);
                duplicates.add(c);
            } else {
                hm.put(c, 1);
            }
        }

        Iterator<Character> iter = duplicates.iterator();
        while (iter.hasNext()) {
            char c = iter.next();
            System.out.println(c + ":" + hm.get(c));
        }
    }
}
