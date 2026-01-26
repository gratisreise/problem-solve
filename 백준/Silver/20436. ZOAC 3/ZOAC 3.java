import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
    static int calc(Point p1, Point p2){
        return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        Map<Character, Point> mp = new HashMap<>();
        Set<Character> set = new HashSet<>();
        mapping(mp);
        setting(set);
        var st = new StringTokenizer(in.readLine());
        Point L = mp.get(st.nextToken().charAt(0));
        Point R = mp.get(st.nextToken().charAt(0));
        char[] str = in.readLine().toCharArray();
        int ret = 0;
        for(char c : str){
            Point target = mp.get(c);
            if(!set.contains(c)){
                ret += calc(L, target);
                L = new Point(target.y, target.x);
            } else {
                ret += calc(R, target);
                R = new Point(target.y, target.x);
            }
            ret++;
        }
        out.println(ret);

        out.flush();
        out.close();
    }
    static void setting(Set<Character> set){
        set.add('b'); set.add('y');set.add('u');
        set.add('i');set.add('o');set.add('p');
        set.add('h');set.add('j');set.add('k');
        set.add('l');set.add('n');set.add('m');
    }


    static void mapping(Map<Character, Point> mp){
        mp.put('a', new Point(1, 0));
        mp.put('b', new Point(2, 4));
        mp.put('c', new Point(2, 2));
        mp.put('d', new Point(1, 2));
        mp.put('e', new Point(0, 2));
        mp.put('f', new Point(1, 3));
        mp.put('g', new Point(1, 4));
        mp.put('h', new Point(1, 5));
        mp.put('i', new Point(0, 7));
        mp.put('j', new Point(1, 6));
        mp.put('k', new Point(1, 7));
        mp.put('l', new Point(1, 8));
        mp.put('m', new Point(2, 6));
        mp.put('n', new Point(2, 5));
        mp.put('o', new Point(0, 8));
        mp.put('p', new Point(0, 9));
        mp.put('q', new Point(0, 0));
        mp.put('r', new Point(0, 3));
        mp.put('s', new Point(1, 1));
        mp.put('t', new Point(0, 4));
        mp.put('u', new Point(0, 6));
        mp.put('v', new Point(2, 3));
        mp.put('w', new Point(0, 1));
        mp.put('x', new Point(2, 1));
        mp.put('y', new Point(0, 5));
        mp.put('z', new Point(2, 0));
    }
}