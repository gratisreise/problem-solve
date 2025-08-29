from collections import deque, defaultdict
import sys, itertools, math, heapq

ip, op = sys.stdin, sys.stdout

n = int(ip.readline())
nums = list(map(int, ip.readline().split()))
dic = defaultdict(list)

for i,num in enumerate(nums):
    dic[num].append(i)

ret = int(1e9)
for value in dic.values():
    if len(value) > 1:
        for i in range(len(value)-1):
            ret = min(ret, value[i+1] - value[i]+1)
print(ret if ret != int(1e9) else -1)


"""
n(1~20만), I(1~100만)
모든 입력값은 정수
같은값이 여러번 등장하는 부분 존재하는지 판다
존재한다면: 가장짧은 길이 출력
없으면: -1 출력
부분순열에서 같은 값이 있는 것중 가장 짧은것

20만
순회하면서 맵에 바꿔서 위치인덱스를저장
20만보다 적게나오지
맵돌면서 부분배열 숫자 가장 길이 짧은것 
"""