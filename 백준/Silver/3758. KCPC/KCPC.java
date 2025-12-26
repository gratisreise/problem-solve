import java.io.*;
import java.util.*;

public class Main {
    static class Team{
        int score;
        int cnt;
        int time;
        Team(int score, int cnt, int time){
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        for(int i = 0; i < t; i++){
            var st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀수
            int k = Integer.parseInt(st.nextToken()); // 문제수
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); //입력수
            List<Team> teams = new ArrayList<>();
            teams.add(new Team(-100, 0, 0));
            for(int j = 0; j < n; j++){
                teams.add(new Team(0, 0, 0));
            }
            int[][] solved = new int[n+1][k+1];
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(in.readLine());
                int solvedId = Integer.parseInt(st.nextToken());
                int pNum = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                Team now = teams.get(solvedId);
                now.cnt++;
                now.time = j;
                solved[solvedId][pNum] = Math.max(solved[solvedId][pNum], s);
            }
            List<Integer> l = new ArrayList<>();
            for(int j = 1; j <= n; j++){
                int sum = 0;
                for(int p = 1; p <= k; p++){
                    sum += solved[j][p];
                }
                teams.get(j).score += sum;
                l.add(j);
            }
            l.sort((a, b) ->{
                if(teams.get(a).score == teams.get(b).score){
                    if(teams.get(a).cnt == teams.get(b).cnt) return teams.get(a).time - teams.get(b).time;
                    return teams.get(a).cnt - teams.get(b).cnt;
                } return teams.get(b).score - teams.get(a).score;
            });
            out.println(l.indexOf(id)+1);
        }

        out.flush();
        out.close();
    }
}