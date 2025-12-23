import java.io.*;
import java.util.*;

public class Main {
    static class User{
        int l; String n;
        User(int l, String n){
            this.l = l;
            this.n = n;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<User>> rooms = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(in.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean ined = false;
            for(int num : rooms.keySet()){ //들어갈 수 있나??
                List<User> room = rooms.get(num);
                if(room.size() >= m) continue;
                int firstL = room.get(0).l;
                if(level >= (firstL - 10) && level <= (firstL+10)){
                    room.add(new User(level, name));
                    rooms.put(num, room);
                    ined = true;
                }
                if(ined) break;
            }
            if(!ined){
                List<User> room = new ArrayList<>();
                room.add(new User(level, name));
                rooms.put(idx, room);
                idx++;
            }
        }
        for(int i = 0; i < idx; i++){
            List<User> room = rooms.get(i);
            room.sort(Comparator.comparing(a -> a.n));
            if(room.size() == m){
                out.println("Started!");
            } else {
                out.println("Waiting!");
            }
            for(User u : room){
                out.printf("%d %s\n", u.l, u.n);
            }
        }

        out.flush();
        out.close();
    }
}