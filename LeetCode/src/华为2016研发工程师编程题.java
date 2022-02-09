import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            int n = in.nextInt();
            int result = delete(n);
            System.out.println(result);
        }

    }

    private static int delete(int n){
        List<Integer> record = new ArrayList<>();
        int i = 0;
        for(i = 0; i < n; i ++){
            record.add(i);
        }
        while(record.size() > 1){

            i = (i + 2) % record.size();
            //System.out.println(i);
            record.remove(i);
        }
        //System.out.println(record.get(0));
        return record.get(0);
    }
}

import java.io.*;
        import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            String s = in.next();
            String result = output(s);
            System.out.println(result);
        }
    }

    private static String output(String s){
        char[] letters = s.toCharArray();
        String result = "";
        HashSet<Character> record = new HashSet<>();
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < letters.length; i ++){
            if(!record.contains(letters[i])){
                list.addLast(letters[i]);
                record.add(letters[i]);
            }
        }
        for(int i = 0; i < list.size(); i ++){
            result += list.get(i);
        }
        return result;
    }
}

import java.io.*;
        import java.util.*;

public class Main{
    private static boolean[][] col = new boolean [9][10];
    private static boolean[][] row = new boolean [9][10];
    private static int[][] board = new int[9][9];
    private static boolean[][][] cell = new boolean[3][3][10];

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            for(int i = 0; i < 9; i ++){
                for(int j = 0; j < 9; j ++){
                    board[i][j] = in.nextInt();
                }
            }

            for(int i = 0; i < 9; i ++){
                for(int j = 0; j < 9; j ++){
                    if(board[i][j] != 0){
                        int t = board[i][j];
                        row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                    }
                }
            }
            dfs(board, 0, 0);
            for(int i = 0; i < 9; i ++){
                for(int j = 0; j < 9; j ++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean dfs(int[][] board, int x, int y){
        if(y == 9){
            x ++;
            y = 0;
        }
        if(x == 9) return true;
        if(board[x][y] != 0) return dfs(board, x, y + 1);
        for(int i = 1; i <= 9; i ++){
            if(!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]){
                board[x][y] = i;
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if(dfs(board, x, y + 1)) return true;
                board[x][y] = 0;
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
            }
        }
        return false;
    }
}

