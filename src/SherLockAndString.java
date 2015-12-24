import java.util.*;

public class SherLockAndString {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            String input = scan.next();
            sherLockAndString(input);
        }
    }

    public static void sherLockAndString(String input) {
        int n = input.length(), z = 0, res = 0;
        int noOfsubstrings = n*n - (n*(n -1)/2);
        String[] substrings = new String[noOfsubstrings];
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                    String sub = input.substring(i, j + 1);
                    char[] temp = sub.toCharArray();
                
                    Arrays.sort(temp);
                    substrings[z++] = new String(temp);
            }
        }
        
        for(int i = 0; i < noOfsubstrings; i++){
            for(int j = i + 1; j < noOfsubstrings; j++){
                if(substrings[i].equals(substrings[j]))
                    res++;
            }
        }
        
        System.out.println(res);
        
    }
}
