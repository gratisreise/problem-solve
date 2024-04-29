import java.util.*;

public class Main {
    static int[][] tree;

    static String preOrder(int now) { //전위 순회
        char c = (char) (now + 'A');
        String s = ("" + c); // 루트 집어넣기
        //순차탐색: 좌 -> 우
        for(int next : tree[now]){
            if(next == -1) continue;
            s += preOrder(next);
        }
        return s;
    }

    static String inOrder(int now) { //중위 순회
        char c = (char) (now + 'A');
        String s = "";
        // 좌 -> 루트 -> 우
        if (tree[now][0] != -1) s += inOrder(tree[now][0]);
        s += c;
        if (tree[now][1] != -1) s += inOrder(tree[now][1]);
        return s;
    }

    static String postOrder(int now) {//후위 순회
        char c = (char) (now + 'A');
        String s = "";
        // 좌 -> 우 -> 루트
        if (tree[now][0] != -1) s += postOrder(tree[now][0]);
        if (tree[now][1] != -1) s += postOrder(tree[now][1]);
        s += c;
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new int[n + 4][2]; // 트리 2차원배열 이용 선언
        for (int i = 0; i < n; i++) {
            // 입력받은 문자 -> int로
            int now = sc.next().charAt(0) - 'A';
            // 좌, 우 입력받기
            for (int j = 0; j < 2; j++) {
                char c = sc.next().charAt(0);
                if (c == '.') { // .이면 구분할 수 있게 -1로 저장
                    tree[now][j] = -1;
                    continue;
                }
                tree[now][j] = c - 'A';
            }
        }
        System.out.println(preOrder(0));
        System.out.println(inOrder(0));
        System.out.println(postOrder(0));
    }
}
/*
1. 2차원 배열 생성
2. 2차원 배열에 트리 집어넣기
3. 전위순회 -> 출력 
4. 중위순회 -> 출력
5. 후위순회 -> 출력
 */