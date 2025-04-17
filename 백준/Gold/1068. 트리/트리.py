n = int(input())
inputs = list(map(int, input().split()))
rmv = int(input())
tree, root = [[] for _ in range(n)], 0
vis = [0]*n
def go(now):
    vis[now] = 1
    ret, child = 0, 0
    for next in tree[now]:
        if vis[next] or next == rmv: continue
        ret += go(next)
        child += 1
    if child == 0: ret += 1
    return ret

for i,num in enumerate(inputs):
    if num == -1:
        root = i
        continue
    tree[num].append(i)
print(0 if root == rmv else go(root))