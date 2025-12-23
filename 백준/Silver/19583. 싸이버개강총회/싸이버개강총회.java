import java.io.*;
import java.util.*;

public class Main {
    static int hourToMinute(String time){
        String[] times = time.split(":");
        int hour  = Integer.parseInt(times[0]) * 60;
        int minute = Integer.parseInt(times[1]);
        return hour + minute;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);


        var st = new StringTokenizer(in.readLine());
        int s = hourToMinute(st.nextToken());
        int e = hourToMinute(st.nextToken());
        int q = hourToMinute(st.nextToken());
        Map<String, Set<Integer>> mp = new HashMap<>();//출석확인

        String line;
        while((line = in.readLine()) != null){
            String[] words = line.split(" ");
            String name = words[1];
            int time = hourToMinute(words[0]);
            if(!mp.containsKey(name)){
                mp.put(name, new HashSet<>());;
            }
            if(time <= s){
                Set<Integer> st1 = mp.get(name);
                st1.add(-1);
                mp.put(name, st1);
            } else if(time >= e && time <= q){
                Set<Integer> st1 = mp.get(name);
                st1.add(1);
                mp.put(name, st1);
            }
        }
        int ret = 0;
        for(String name : mp.keySet()){
            if(mp.get(name).size() == 2){
                ret++;
            }
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}