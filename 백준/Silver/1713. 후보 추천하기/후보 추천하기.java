import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine()); // 사진틀 개수
        int m = Integer.parseInt(in.readLine()); // 총 추천 횟수
        var st = new StringTokenizer(in.readLine());

        int[] recommendCount = new int[101]; // 추천수 (기본값 0)
        int[] recentTime = new int[101];     // 최근 추천받은 시간 (기본값 0)

        // frame: 현재 사진틀에 걸려있는 학생들의 번호 (최대 N개)
        List<Integer> frame = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int studentNum = Integer.parseInt(st.nextToken());

            // 1. 이미 프레임에 걸려있는 학생인 경우
            if (frame.contains(studentNum)) {
                recommendCount[studentNum]++;
            }
            // 2. 새로운 학생인 경우
            else {
                // 2-A. 프레임에 빈자리가 있는 경우
                if (frame.size() < n) {
                    frame.add(studentNum);
                    recommendCount[studentNum] = 1;
                    recentTime[studentNum] = i; // 현재 시간으로 갱신
                }
                // 2-B. 프레임이 꽉 찬 경우 (교체 필요)
                else {
                    frame.sort((a, b) -> {
                        if (recommendCount[a] == recommendCount[b]) {
                            return recentTime[a] - recentTime[b];
                        }
                        return recommendCount[a] - recommendCount[b];
                    });

                    int evictedStudent = frame.remove(0);

                    // 밀려난 학생의 추천수와 시간 기록 초기화
                    recommendCount[evictedStudent] = 0;
                    recentTime[evictedStudent] = 0;

                    frame.add(studentNum);
                    recommendCount[studentNum] = 1;
                    recentTime[studentNum] = i;
                }
            }
        }


        frame.sort(Comparator.naturalOrder());

        for(int student : frame){
            out.print(student + " ");
        }

        out.flush();
        out.close();
    }
}