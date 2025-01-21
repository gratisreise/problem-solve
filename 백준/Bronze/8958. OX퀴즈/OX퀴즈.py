for _ in range(int(input())):
    s = input().split("X")
    print(sum(len(c)*(len(c)+1)//2 for c in s))