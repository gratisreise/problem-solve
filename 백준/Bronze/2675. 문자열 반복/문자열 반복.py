n = int(input())
for _ in range(n):
    cnt, s = input().split(" ")
    ans = "".join(map(lambda c: c*int(cnt), s))
    print(ans)