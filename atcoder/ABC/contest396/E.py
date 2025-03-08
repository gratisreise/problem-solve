import sys

input = sys.stdin.readline
n,m = map(int, input().split())
ret = [0]*n
condi = []
for i in range(m):
    condi.append(tuple(map(int, input().split())))
print(condi)

if m == 0:
    print([0]*n)


"""
n(1~20만),m(0~10만)
x,y,z
x,y(1~n)
z(0~10^9)
길이 n인 정수수열 A 찾기
모든 a[xi]^a[yi] == zi
존재x -1출력
존재시 a의 원소합 최소인 수열 출력

1. 길이 n인수열의 경우
2. m개의 조건을 만족한다
3.



"""