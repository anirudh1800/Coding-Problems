import java.util.Scanner;

/**
 * Created by agali on 2/4/16.
 */
public class SherLockAndBeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int z = n;

            while(z % 3 != 0){
                z -= 5;
            }

            if(z < 0)
                System.out.println(-1);
            else{
                StringBuilder x = new StringBuilder(n);

                for(int i = 0; i < z; i++)
                    x.append("5");

                for(int i = 0; i < (n - z); i++)
                    x.append("3");

                System.out.println(x);
            }

        }

    }
}
