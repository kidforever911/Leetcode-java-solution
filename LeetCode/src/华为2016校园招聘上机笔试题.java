import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n + 1];
            for(int i = 1; i <= n; i ++){
                arr[i] = in.nextInt();
            }
            while(m -- > 0){
                String operation = in.next();
                if(operation.equals("Q")){
                    int a = in.nextInt();
                    int b = in.nextInt();
                    if(a > b){
                        int temp = b;
                        b = a;
                        a = temp;
                    }
                    int result = findMax(arr, a, b);
                    System.out.println(result);
                }else if(operation.equals("U")){
                    int x = in.nextInt();
                    arr[x] = in.nextInt();
                }
            }
        }

    }

    private static int findMax(int[] arr, int a, int b){
        int max = 0;
        for(int i = a; i <= b; i ++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}

import java.io.*;
        import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        HashMap<String[], Integer> record = new HashMap<>();
        LinkedList<String[]> list = new LinkedList<>();
        while(in.hasNext()){
            String inputString = in.next();
            String[] s = inputString.split("\\\\");
            int location = in.nextInt();
            String l = Integer.toString(location);
            String r = s[s.length - 1];
            String[] store = new String[2];
            store[0] = r;
            store[1] = l;
            if(!record.containsKey(store)){
                record.put(store, record.getOrDefault(r, 0) + 1);
                list.addLast(store);
            }
        }
        for(int i = 0; i < Math.max(list.size(), 8); i ++){
            String[] output = list.get(i);
            if(output[0].length() > 16){
                String result = output[0].substring(output[0].length() - 16);
                System.out.print(result + " " + output[1] + " " + record.get(output));
                System.out.println();
            }else{
                System.out.print(output[0] + " " + output[1] + " " + record.get(output));
                System.out.println();
            }
        }
    }
}

import java.io.*;
        import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()){
            String inputString = in.nextLine();
            String[] competition = inputString.split("-");
            if(competition[1].equals("joker JOKER") || competition[0].equals("joker JOKER")){
                System.out.println("joker JOKER");
            }else{
                String[] left = competition[0].split(" ");
                String[] right = competition[1].split(" ");
                if(left.length != right.length && (left.length != 4 && right.length != 4)) System.out.println("ERROR");
                else{
                    if(left.length == 4 && right.length < 4){
                        System.out.println(competition[0]);
                    }else if(left.length < 4 && right.length == 4){
                        System.out.println(competition[1]);
                    }else{
                        if(left[0].equals("J")) left[0] = "11";
                        if(left[0].equals("Q")) left[0] = "12";
                        if(left[0].equals("K")) left[0] = "13";
                        if(left[0].equals("A")) left[0] = "14";
                        if(left[0].equals("2")) left[0] = "15";
                        if(left[0].equals("joker")) left[0] = "99";
                        if(left[0].equals("JOKER")) left[0] = "100";
                        if(right[0].equals("J")) right[0] = "11";
                        if(right[0].equals("Q")) right[0] = "12";
                        if(right[0].equals("K")) right[0] = "13";
                        if(right[0].equals("A")) right[0] = "14";
                        if(right[0].equals("2")) right[0] = "15";
                        if(right[0].equals("joker")) right[0] = "99";
                        if(right[0].equals("JOKER")) right[0] = "100";
                        if(Integer.parseInt(left[0]) > Integer.parseInt(right[0])){
                            System.out.println(competition[0]);
                        }else{
                            System.out.println(competition[1]);
                        }
                    }
                }
            }
        }
    }
}