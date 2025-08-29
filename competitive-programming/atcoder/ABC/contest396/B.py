import sys
input = sys.stdin.readline
n, m = map(int, input().split())
nums_b = list(map(int, input().split()))
nums_w = list(map(int, input().split()))
nums_b = sorted(nums_b, reverse=True)
nums_w = sorted(nums_w, reverse=True)

ret = 0
for i in range(len(nums_b)):
    sum = nums_b[i] + (nums_w[i] if i < len(nums_w) else 0)
    if sum > 0: ret += sum
    else: break
print(ret if ret > 0 else 0)






"""
n:black(1~20만), m:white(1~20만)
i -Bi
j - Wj
0개이상 선택

b >= w
1.양수만 모음
2.정렬
3.흰공을 검은공보다 적게 뽑는다.

내림차순 정렬에서 누적합을 구한다

l, r

"""