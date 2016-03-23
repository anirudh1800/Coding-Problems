import java.util.*;

class TreeConstruction{
	
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int degree[] = new int[n];
	int tree[] = new int[n];
        
	for(int degree_i=0; degree_i < n; degree_i++){
       	degree[degree_i] = in.nextInt();
        tree[degree_i] = degree_i;
    }

	System.out.println(isFeasibleTree(tree, degree));
	scan.close();
}
    
public static boolean isFeasibleTree(int tree[], int[] degree){
    for(int i = 0; i < tree.length; i++){
        int j = i, k = i;
        int prev = tree[i];
        int oldprev;
        
        while((2*i + 1) < tree.length){
            oldprev = prev;
            k = maxDegreeNode(2*i + 1, 2*i + 2, degree);
            prev = tree[k];
            tree[k] = oldprev;
            i = k;    
        }
        tree[j] = prev;
    }
    

    System.out.println(Arrays.toString(tree));
    return false;
}
    
public static int maxDegreeNode(int i, int j, int[] degree){
    return degree[i] >= degree[j] ? i : j;
}
    
}
