import java.util.Scanner;

/**
 * Created by agali on 1/28/16.
 */

// Using Kadane's Algorithm
public class MaxSumSubArray2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.valueOf(scan.nextLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.println(findMaxSumSubArray(0, n - 1, nums));
        
        scan.close();

    }

    public static int findMaxSumSubArray(int low, int high, int[] nums){
        int max_so_far = 0;
        int max_ending_here = 0;

        for(int i = low; i <= high; i++){
            if(nums[i] == 0) {
                max_ending_here = 0;
                continue;
            }

            max_ending_here = max_ending_here + nums[i];

            if(max_ending_here < 0){
                max_ending_here = 0;
            }

            if(max_ending_here > max_so_far){
                max_so_far = max_ending_here;
            }
        }

        return max_so_far;
    }

}
