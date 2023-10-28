import java.util.Scanner;

public class Main {
    static int ret = 0;
    static int n;

    static class Board {
        int[][] a;

        public Board() {
            a = new int[24][24];
        }

        void rotate90() {
            int[][] temp = new int[24][24];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = a[n - j - 1][i];
                }
            }
            a = temp;
        }

        void move() {
            int[][] temp = new int[24][24];
            for (int i = 0; i < n; i++) {
                int c = -1, d = 0;
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0) continue;
                    if (d != 0 && a[i][j] == temp[i][c]) {
                        temp[i][c] *= 2;
                        d = 0;
                    } else {
                        temp[i][++c] = a[i][j];
                        d = 1;
                    }
                }
                for (c++; c < n; c++) temp[i][c] = 0;
            }
            a = temp;
        }

        void getMax() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ret = Math.max(ret, a[i][j]);
                }
            }
        }
    }

    static void go(Board c, int here) {
        if (here == 5) {
            c.getMax();
            return;
        }
        for (int i = 0; i < 4; i++) {
            Board d = new Board();
            d.a = c.a.clone();
            d.move();
            go(d, here + 1);
            c.rotate90();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Board c = new Board();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c.a[i][j] = scanner.nextInt();
            }
        }

        go(c, 0);
        System.out.println(ret);
    }
}
