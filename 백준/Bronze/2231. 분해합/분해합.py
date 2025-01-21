n = int(input())
for i in range(n):
    if n == sum(map(int, str(i))) + i:
        print(i)
        exit()
print(0)