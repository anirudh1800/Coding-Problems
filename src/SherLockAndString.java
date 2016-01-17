import java.util.*;

public class SherLockAndString {

    public static boolean checkAnagram(int start1, int end2, int length, String input) {
        while (length >= 1 && start1 <= (input.length() - 1) && end2 >= 0) {
            if (input.charAt(start1) == input.charAt(end2)) {
                start1++;
                end2--;
            } else {
                break;
            }

            length--;

        }

        if (length == 0 && start1 != end2)
            return true;

        return false;
    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            String input = scan.next();
            sherLockAndString(input);
        }
    }


    public static void sherLockAndString(String input) {
        HashMap<Character, List<Integer>> hm = new HashMap<Character, List<Integer>>();
        List<AnagramSet> set = new ArrayList<AnagramSet>();

        for (int i = 0; i < input.length(); i++) {
            List<Integer> list = hm.get(input.charAt(i));

            if (list == null) {
                list = new ArrayList<Integer>();

                list.add(i);
                hm.put(input.charAt(i), list);
            } else {
                list.add(i);
            }
        }

        Iterator<Character> ita = hm.keySet().iterator();
        while (ita.hasNext()) {

            List<Integer> indexes = hm.get(ita.next());

            Iterator<Integer> ita1 = indexes.iterator();

            while (ita1.hasNext()) {
                int a1 = ita1.next();

                Iterator<Integer> ita2 = indexes.iterator();
                while (ita2.hasNext()) {
                    int a2 = ita2.next();

                    if (a1 == a2)
                        continue;


                    for (int i = 1; i <= input.length() - 1; i++) {
                        if (checkAnagram(a1, a2, i, input)) {
                            if (a1 == (a2 - i + 1))
                                continue;
                            set.add(new AnagramSet(a1, a1 + i - 1, a2 - i + 1, a2));
                            //System.out.println(a1 + "," + (a1 + i - 1) + " " + (a2 - i + 1)  + "," +  a2 );
                        }
                    }

                }
            }
        }

        Set<AnagramSet> set2 = AnagramSet.removeDuplicates(set);
        Iterator iter = set2.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }

}

class AnagramSet {
    public int start1;
    public int end1;
    public int start2;
    public int end2;

    public AnagramSet(int start1, int end1, int start2, int end2) {
        this.start1 = start1;
        this.end1 = end1;
        this.start2 = start2;
        this.end2 = end2;
    }

    public static Set<AnagramSet> removeDuplicates(List<AnagramSet> l) {
        Set<AnagramSet> s = new TreeSet<AnagramSet>(new Comparator<AnagramSet>() {

            @Override
            public int compare(AnagramSet o1, AnagramSet o2) {
                if (o1.start1 == o2.start1 && o1.start2 == o2.start2 && o2.end2 == o1.end2 && o2.end1 == o1.end1) {
                    return 0;
                }

                if (o1.start1 == o2.start2 && o1.end1 == o2.end2 && o1.start2 == o2.start1 && o1.end2 == o2.end1) {
                    return 0;
                }

                return -1;
            }

        });

        s.addAll(l);

        return s;
    }

    @Override
    public String toString() {
        return String.format(start1 + "," + end1 + " " + start2 + "," + end2);
    }

}