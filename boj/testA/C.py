import sys
from itertools import combinations

ip, op = sys.stdin, sys.stdout
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]
home, chi = [], []
n, m = map(int, ip.readline().rstrip().split())
mp = [0]*n
for i in range(n):
    mp[i] = list(map(int, ip.readline().rstrip().split()))
    for j in range(n):
        if mp[i][j] == 1:
            home.append((i,j))
        elif mp[i][j] == 2:
            chi.append((i,j))
ret = 1e9
for arr in list(combinations(chi, m)):
    sum = 0
    for h in home:
        dis = 1e9
        for c in arr:
            dis = min(dis, abs(h[0]-c[0])+abs(h[1]-c[1]))
        sum += dis
    ret = min(sum, ret)
op.write(f'{ret}\n')
        



"""
**조합 로직, 메서드 사용방법 모름**
50, 13

0 - 빈칸
1 - 집
2 - 치킨집
1<= 집수 <= 2N
M <= 치킨집 <= 13
폐업 안하는 치킨 M개 고르고 
치킨거리 = 가장 가까운 치킨집까지의 거리
도시의 치킨 거리 = 모든 집의 치킨거리합 최솟값
2500 * 13C6
1. 입력받기
    집위치 저장
    치킨집 위치 저장
2. 폐업하지 않는 치킨집 M개 뽑기
3. 집집마다 치킨거리 구하기(bfs)
4. 최솟값갱신


"""