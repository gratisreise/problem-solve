import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                                  line[j][0], line[j][1], line[j][2]);
                if(intersection != null) points.add(intersection);
            }
        }
        
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
        
        char[][] arr = new char[height][width];
        
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
        for(Point p : points){
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
        
        
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
            
        
        return result;
    }
    //교점 좌표 구하는 메서드
    // 두 직선 정보받기
    // 교점이 정수이면 포인트 객체 반환
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
        //교점 구해서 반환하기
        double x = (double)(b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double)(a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long)x, (long)y);
    }
    
    private Point getMinimumPoint(List<Point> points){
        // 가장 작은 좌표 구하기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    
    private Point getMaximumPoint(List<Point> points){
        // 가장 큰 좌표 구하기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }

    // 좌표를 나타내는 클래스
    private static class Point{
        //실제 좌표의 값은 계산 결과 클 수 있다.
        // long으로 다뤄야 오버플로가 안 일어난다
        public final long x, y;
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}
/*
1. 모든 직선 쌍에 대해 반복
    1-1. 교점 좌표 구하기
    1-2. 정수 좌표만 저장
2. 저장된 정수들에 대해 x,y 좌표의 최댓값, 최솟값 구하기
3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
4. 2차원 배열에 별 표시
5. 문자열 배열로 변환 후 반환
*/
