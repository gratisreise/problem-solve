import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 받기 위한 StringTokenizer를 사용하여 첫 줄을 읽음
        int k = Integer.parseInt(st.nextToken()); // k를 입력 받음
        int n = Integer.parseInt(st.nextToken()); // n을 입력 받음
        int cnt = 0; // 결과값을 저장할 변수
        int[] a = new int[104]; // 입력된 수열을 저장할 배열
        int[] visited = new int[104]; // 방문 여부를 저장할 배열
        List<Integer> v = new ArrayList<>(); // 중복된 수를 저장할 리스트

        st = new StringTokenizer(br.readLine()); // 다음 줄을 읽어와 StringTokenizer에 저장
        for (int i = 0; i < n; i++) { // n개의 수열을 입력 받음
            a[i] = Integer.parseInt(st.nextToken()); // 수열을 배열에 저장
        }

        for (int i = 0; i < n; i++) { // 수열을 하나씩 탐색
            if (visited[a[i]] == 0) { // 아직 방문하지 않은 수일 경우
                if (v.size() == k) { // 리스트에 k개의 수가 저장되어 있는 경우(멀티탭다 쓰는 경우)
                    int lastIdx = 0, pos = 0; // 마지막으로 등장하는 인덱스와 해당 수를 저장할 변수 초기화
                    for (int j = 0; j < v.size(); j++) { // 리스트에 저장된 수에 대해 탐색
                        int herePick = INF; // 해당 수가 마지막으로 등장하는 인덱스 초기화
                        for (int l = i + 1; l < n; l++) { // 현재 위치 이후의 수열에 대해 탐색
                            if (v.get(j) == a[l]) { // 리스트에 저장된 수와 동일한 수를 발견한 경우
                                herePick = l; // 해당 수의 인덱스를 저장
                                break;
                            }
                        }
                        if (lastIdx < herePick) { // 마지막으로 등장하는 인덱스가 이전에 등장한 인덱스보다 큰 경우
                            lastIdx = herePick; // 마지막으로 등장하는 인덱스 갱신
                            pos = v.get(j); // 해당 수 갱신
                        }
                    }
                    visited[pos] = 0; // 리스트에서 해당 수를 제거하기 위해 방문 여부를 0으로 변경
                    cnt++; // 카운트 증가
                    v.remove(v.indexOf(pos)); // 리스트에서 해당 수 제거
                }
                v.add(a[i]); // 현재 수를 멀티탭에 꽂기
                visited[a[i]] = 1; // 현재 수를 방문 처리
            }
        }
        System.out.println(cnt); // 결과 출력
    }
}
