/**
 * Created by agali on 3/5/16.
 */
/*

Given an array of 0s and 1s, and k, Find the longest continuous streak of 1s after flipping k 0s to 1s.

        E.x array is {1,1,0,0,1,1,1,0,1,1}
        k = 1 (which means we can flip ‘k’ one 0 to 1)
*/

public class LongestStreak {
    public static void main(String args[]) {
        int[] array = {1, 1, 0, 0, 1, 1, 0, 1, 1};

        System.out.println(longestStreak(array, 2));
    }

    public static int longestStreak(int[] nums, int k) {
        int start = 0;
        int max_cur = 0;
        int max_so_far = 0;
        int tmp = k;

        while (start != nums.length) {
            if (nums[start] == 1) {
                max_so_far += 1;
            } else if (tmp != 0) {
                max_so_far += 1;
                tmp--;
            } else {
                if (max_cur < max_so_far)
                    max_cur = max_so_far;

                start = start - max_so_far;
                max_so_far = 0;
                tmp = k;
            }
            start++;
        }

        return Math.max(max_cur, max_so_far);
    }
}
