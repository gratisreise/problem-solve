import java.io.*;
import java.util.*;

public class Main {
    static boolean isYoon(int n){
        return n % 400 == 0 || (n%4==0 && n%100 != 0);
    }

    static int monthToDay(boolean isYoon, int n){
        Set<Integer> m31s = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        if(m31s.contains(n)) return 31;
        if(isYoon && n == 2) return 29;
        if(!isYoon && n == 2) return 28;
        return 30;
    }

    static int hoursToMinutes(String time){
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minutes = Integer.parseInt(temp[1]);
        return hour * 60 + minutes;
    }
    static double count(int[] times){
        int year = times[0];
        int month = times[1];
        int day = (times[2]-1) * 24 * 60;
        int minutes = times[3];
        boolean yoon = isYoon(year);
        double total = (yoon ? 366 : 365) * 24 * 60;
        double now = 0;
        int days = 0;
        for(int i = 1; i < month; i++){
            days += monthToDay(yoon, i)*24*60;
        }
        now = day + days + minutes;
        return (now / total) * 100;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        Map<String, Integer> mp = new HashMap<>();
        mp.put("January", 1);
        mp.put("February", 2);
        mp.put("March", 3);
        mp.put("April", 4);
        mp.put("May", 5);
        mp.put("June", 6);
        mp.put("July", 7);
        mp.put("August", 8);
        mp.put("September", 9);
        mp.put("October", 10);
        mp.put("November", 11);
        mp.put("December", 12);

        String[] s = in.readLine().split(",");
        String[] monthDay = s[0].split(" ");
        String[] yearHour = s[1].trim().split(" ");
        int[] times = new int[4]; // 년도 월,일, 시간
        times[0] = Integer.parseInt(yearHour[0]);
        times[1] = mp.get(monthDay[0]);
        times[2] = Integer.parseInt(monthDay[1]);
        times[3] = hoursToMinutes(yearHour[1]);

        System.out.println(count(times));




        out.flush();
        out.close();
    }
}