import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DisasterRecovery {

// Need to improve the time complexity using Dynamic Programming

    public static void main(String[] args) {
       int noOfServers = 0, costs[], i = 0, cost = 0;
        
       Scanner scan = new Scanner(System.in);
        
       noOfServers = scan.nextInt();
       costs  = new int[noOfServers];
        
       while(i != noOfServers)
           costs[i++] = scan.nextInt();
        
       cost = findMinCost(0, noOfServers - 1, costs, 0, 1);
       
       System.out.println(cost);
       scan.close();
    }
    
    public static int findMinCost(int start, int end, int costs[], int cost, int hour){
       if(start == end){
           return cost + costs[start] * hour;
       }else{
           
           int leftCost = findMinCost(start + 1, end, costs, cost + costs[start] * hour, hour + 1);
           
           int rightCost = findMinCost(start, end - 1, costs, cost + costs[end] * hour, hour + 1);
           
           //System.out.println(leftCost + " " + rightCost);
           
           return Math.min(leftCost, rightCost);
       }
    }
}
