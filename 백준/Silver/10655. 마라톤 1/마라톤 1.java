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

        int n = Integer.parseInt(in.readLine());

        List<Point> points = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            var st = new StringTokenizer(in.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            points.add(new Point(y, x));
        }

        int total = 0;
        Point first = points.get(0);
        int y = first.y;
        int x = first.x;
        for(int i = 1; i < n; i++){
            Point now = points.get(i);
            int cy = now.y;
            int cx = now.x;
            total += (Math.abs(y - cy) + Math.abs(x - cx));
            y = cy; x = cx;
        }

        int cha = 0;
        for(int i = 0; i < n - 2; i++){
            Point now = points.get(i);
            Point skip = points.get(i+1);
            Point goal = points.get(i+2);
            int normal = calc(now, skip) + calc(skip, goal);
            int abnormal = calc(now, goal);
            cha = Math.max(cha, (normal - abnormal));
        }
        out.println(total - cha);

        out.flush();
        out.close();
    }
}