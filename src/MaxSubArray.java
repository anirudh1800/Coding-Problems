/**
 * Created by anirudhgali on 7/17/15.
 */

import java.util.Scanner;

public class MaxSubArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int i=0; i < T ;i++){
            int N = scan.nextInt();
            int A[] = new int[N];

            for(int j =0; j < N; j++)
                A[j] = scan.nextInt();

            maxSubarray(A, N);

        }

    }

    //Kadane's Algorithm
    public static void maxSubarray(int[] A, int size){
        int sum = A[0];
        int ans = A[0];
        int i, s, e, final_s, final_e;
        s = e = final_s = final_e = 0;
        i = 1;

        while(i < size){
            if(sum + A[i] < A[i]){
                s = i;
                sum = A[i];
            } else sum += A[i];


            if(sum > ans){
                final_e = i;
                final_s = s;
                ans = sum;
            }
            i++;
        }

        System.out.print(ans + " ");

        boolean flag = false;
        for(i = final_s; i<=final_e; i++){
            if(A[i] > 0)
                flag = true;
        }

        if(flag == false){
            ans = A[final_s];
            for(i = final_s + 1; i <= final_e; i++)
                ans = Math.max(ans, A[i]);
        }else{
            ans = 0;
            for(i = final_s; i<=final_e; i++){
                if(A[i] > 0)
                    ans += A[i];
            }
        }

        System.out.println(ans);
    }
}