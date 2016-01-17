import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectCellGrid {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int m = Integer.valueOf(scan.nextLine());
        int n = Integer.valueOf(scan.nextLine());

        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        int j = 0;

        String input;

        for (int k = 0; k < m; k++) {
            input = scan.nextLine();
            String[] values = input.split(" ");

            for (int i = 0; i < n; i++)
                grid[k][i] = Integer.valueOf(values[i]);
        }

        for (int k = 0; k < m; k++)
            for (int i = 0; i < n; i++)
                visited[k][i] = false;

        if(grid[0][0] == 1)
            System.out.println(connectedCell(0, 0, m, n, 1, grid, visited));
        else
            System.out.println(connectedCell(0, 0, m, n, 0, grid, visited));
    }


    public static int connectedCell(int x, int y, int m, int n, int sum, int[][] grid, boolean[][] visited) {
        int upleftsum, leftsum, rightsum, upsum, downsum, uprightsum, downleftsum, downrightsum;

        upleftsum = leftsum = rightsum = upsum = downsum = uprightsum = downleftsum = downrightsum = 0;

        boolean[][] temp = new boolean[visited.length][visited[0].length];


        if(visited[x][y]){
            return sum;
        }

        visited[x][y] = true;

        if ((x - 1) >= 0 && (x - 1) <= m - 1 && (y - 1) >= 0 && (y - 1) <= n - 1) {
            if (grid[x - 1][y - 1] == 1) {
                upleftsum = connectedCell(x - 1, y - 1, m, n, sum + 1, grid, visited);
            }else{
                upleftsum = connectedCell(x - 1, y - 1, m, n, 0, grid, visited);
            }
        }

        if ((y - 1) >= 0 && (y - 1) <= n - 1) {
            if (grid[x][y - 1] == 1) {
                leftsum = connectedCell(x, y - 1, m, n, sum + 1, grid, visited);
            }else{
                leftsum = connectedCell(x, y - 1, m, n, 0, grid, visited);
            }
        }

        if ((x + 1) >= 0 && (x + 1) <= m - 1 && (y - 1) >= 0 && (y - 1) <= n - 1) {
            if (grid[x + 1][y - 1] == 1) {
                downleftsum = connectedCell(x + 1, y - 1, m, n, sum + 1, grid, visited);
            }else{
                downleftsum = connectedCell(x + 1, y - 1, m, n, 0, grid, visited);
            }
        }


        if ((x - 1) >= 0 && (x - 1) <= m - 1) {
            if (grid[x - 1][y] == 1) {
                upsum = connectedCell(x - 1, y, m, n, sum + 1, grid, visited);
            }else
                upsum = connectedCell(x - 1, y, m, n, 0, grid, visited);
        }


        if ((y + 1) >= 0 && (y + 1) <= n - 1) {
            if (grid[x][y + 1] == 1) {
                downsum = connectedCell(x, y + 1, m, n, sum + 1, grid, visited);
            }else{
                downsum = connectedCell(x, y + 1, m, n, 0, grid, visited);
            }
        }

        if ((x - 1) >= 0 && (x - 1) <= m - 1 && (y + 1) >= 0 && (y + 1) <= n - 1) {
            if (grid[x - 1][y + 1] == 1) {
                uprightsum = connectedCell(x - 1, y + 1, m, n, sum + 1, grid, visited);
            }else{
                uprightsum = connectedCell(x - 1, y + 1, m, n, 0, grid, visited);
            }
        }


        if ((x + 1) >= 0 && (x + 1) <= m - 1) {
            if (grid[x + 1][y] == 1) {
                rightsum = connectedCell(x + 1, y, m,
                        n, sum + 1, grid, visited);
            }else{
                rightsum = connectedCell(x + 1, y, m,
                        n, 0, grid, visited);
            }
        }


        if ((x + 1) >= 0 && (x + 1) <= m - 1 && (y + 1) >= 0 && (y + 1) <= n - 1) {
            if (grid[x + 1][y + 1] == 1) {
                downrightsum = connectedCell(x + 1, y + 1, m, n, sum + 1, grid, visited);
            }else{
                downrightsum = connectedCell(x + 1, y + 1, m, n, 0, grid, visited);
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(upleftsum);
        list.add(leftsum);
        list.add(rightsum);
        list.add(rightsum);
        list.add(upsum);
        list.add(downsum);
        list.add(uprightsum);
        list.add(downleftsum);
        list.add(downrightsum);

        return Collections.max(list);
    }
}