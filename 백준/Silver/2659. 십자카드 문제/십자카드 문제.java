import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> ret = new ArrayList<>();
    static void find(int[] arr){ //시계수 찾는 함수
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int temp = 0;
            temp = getInt(arr, temp, i);
            l.add(temp);
        }
        l.sort(Comparator.naturalOrder());
        int timeNum = l.get(0);
        if(ret.contains(timeNum)) return;
        ret.add(timeNum);
    }

    static int findNum(int[] arr){ //시계수 찾는 함수
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int temp = 0;
            temp = getInt(arr, temp, i);
            l.add(temp);
        }
        l.sort(Comparator.naturalOrder());
        return l.get(0);
    }

    private static int getInt(int[] arr, int temp, int i) {
        for(int j = 0; j < 4; j++){
            temp += arr[(j+ i)%4];
            temp *= 10;
        }
        temp /=10;
        return temp;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int[] target = new int[4];
        for(int i = 0; i < 4; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        int targetNum = findNum(target);
        int lim = 10;
        for(int a = 1; a < lim; a++){
            for(int b = 1; b < lim; b++){
                for(int c = 1; c < lim; c++){
                    for(int d = 1; d < lim; d++){
                        int[] temp = new int[]{a, b, c, d};
                        find(temp);
                    }
                }
            }
        }

        System.out.println(ret.indexOf(targetNum)+1);

        out.flush();
        out.close();
    }
}