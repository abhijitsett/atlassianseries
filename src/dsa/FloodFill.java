package dsa;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int sr = 0;
        int sc = 1;
        int newColor = 2;
        int image[][] = {{0, 1, 0},{0, 1, 0}};
        
        System.out.println("Flood Fill");
        int oldColor = image[sr][sc];
        flood(sr,sc,image,oldColor,newColor);
    }

    private static void flood(int sr, int sc, int[][] image, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        dfs(sr,sc,rows,cols,image,oldColor,newColor);
        for(int[] img : image){
            System.out.println(Arrays.toString(img));
        }
    }

    private static void dfs(int row, int col, int rows, int cols, int[][] image, int oldColor, int newColor) {
        if(row<0 || row>=rows || col<0 || col>=cols || image[row][col] != oldColor || image[row][col] == newColor)
            return;
        image[row][col] = newColor;
        int[][] adjList = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
        for(int[] neighbour : adjList){
            dfs(neighbour[0],neighbour[1],rows,cols,image,oldColor,newColor);
        }
    }
}
