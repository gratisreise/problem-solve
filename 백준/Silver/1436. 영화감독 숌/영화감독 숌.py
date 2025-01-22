n, ret, tar = 666, 0, int(input())
while True:
    if "666" in str(n): ret += 1
    if ret == tar: 
        print(n)
        break
    n += 1