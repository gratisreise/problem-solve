# 입력 받기
n, m = map(int, input().split())
j = int(input())
l = 1
ret = 0

# j번 반복
for _ in range(j):
    r = l + m - 1
    temp = int(input())
    
    # temp가 l과 r 사이에 있으면 넘어감
    if l <= temp <= r:
        continue
    # temp가 범위 밖에 있는 경우
    else:
        if temp < l:
            ret += (l - temp)
            l = temp
        else:
            l += (temp - r)
            ret += (temp - r)

# 결과 출력
print(ret)