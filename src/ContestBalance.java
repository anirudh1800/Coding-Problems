import java.util.Scanner;

/**
 * Created by anirudhgali on 7/23/15
 *
 */

public class ContestBalance {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] p = new int[5][2];


       for(int i = 0; i < 5; i++){
            p[i][0] = scan.nextInt();
            p[i][1] = scan.nextInt();
        }

        int ans = 0;

        for(int j = 1; j < 5; j++){
            for(int k = j; k > 0; k--){
                if(p[k][0] < p[k-1][0]){
                    int temp1 = p[k][0];
                    int temp2 = p[k][1];

                    p[k][0] = p[k-1][0];
                    p[k-1][0] = temp1;

                    p[k][1] = p[k-1][1];
                    p[k-1][1] = temp2;
                }
            }
        }

        for(int j = 0; j < 4; j++){
            if(p[j][1] < p[j+1][1])
                ans = 1;
            else{
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
        scan.close();
    }
}
