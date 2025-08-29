def sol(a, b, c):
    # ax^2 + bx + c = 0의 양의 정수 해를 이진 탐색으로 찾음
    l, r = 0, 600000001
    while r - l > 1:
        mid = (l + r) // 2
        if a * mid * mid + b * mid + c <= 0:
            l = mid
        else:
            r = mid
    if a * l * l + b * l + c == 0:
        return l
    return -1

N = int(input())  # 입력 N

# d = x - y를 1부터 탐색
d = 1
found = False
while d * d * d <= N:
    if N % d != 0:  # N이 d로 나누어 떨어지지 않으면 건너뜀
        d += 1
        continue
    m = N // d  # m = N/d = 3k^2 + 3dk + d^2
    # 이차 방정식: 3k^2 + 3dk + (d^2 - m) = 0
    k = sol(3, 3 * d, d * d - m)
    if k > 0:  # 유효한 k를 찾으면
        x = k + d
        y = k
        print(x, y)  # (x, y) 출력
        found = True
        break
    d += 1

if not found:
    print(-1)  # 쌍이 없으면 -1 출력