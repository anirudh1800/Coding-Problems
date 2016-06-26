import java.util.*;

class Solution {
//    public int solution(int X) {
//        HashSet<Integer> hs = new HashSet<Integer>();
//        String number = Integer.toString(X);
//        ArrayList<Integer> rm_idx = new ArrayList<Integer>();
//        ArrayList<Integer> result = new ArrayList<Integer>();
//
//        int tmp = X;
//
//        // find all the unique digits in the number
//        while (tmp > 0) {
//            hs.add(tmp % 10);
//            tmp = tmp / 10;
//        }
//
//        // finding the numbers to be removed
//        Iterator<Integer> iter = hs.iterator();
//        while (iter.hasNext()) {
//            int digit = iter.next();
//            String substring = digit + "" + digit;
//
//            int index = word.indexOf(guess);
//            while (index >= 0) {
//                System.out.println(index);
//                index = word.indexOf(guess, index + 1);
//            }
//        }
//
//        // get all the numbers
//        for (int index : rm_idx) {
//            String output = number.substring(0, index) + number.substring(index + 1);
//            result.add(Integer.parseInt(output));
//        }
//
//        Collections.sort(result);
//        return result.get(result.size() - 1);
//    }

}