import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int y; int x;
        Point(int y,int x){
            this.y = y;
            this.x = x;
        }
    }
    static List<List<Point>> l = new ArrayList<>();
    static Point[] points;
    static void combine(int start,int n, int k, List<Point> pl){
        if(pl.size() == k){
            l.add(new ArrayList<>(pl));
            return;
        }
        for(int i = start; i < n; i++){
            pl.add(points[i]);
            combine(i+1, n, k, pl);
            pl.remove(pl.size() - 1);
        }
    }
    static int calc(Point p1, Point p2){
        return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        points = new Point[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            points[i] = new Point(y, x);
        }

        combine(0, n, k, new ArrayList<>());


        int ret = Integer.MAX_VALUE;
        for(List<Point> ps : l){
            int max = -1;
            for(Point p1 : points){
                int dis = Integer.MAX_VALUE;
                for(Point p2 : ps){
                    dis = Math.min(dis, calc(p1, p2));
                }
                max = Math.max(dis, max);
            }
            ret = Math.min(max, ret);
        }

        System.out.println(ret);
        out.flush();
        out.close();
    }
}