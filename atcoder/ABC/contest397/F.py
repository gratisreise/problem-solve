from atcoder.lazysegtree import LazySegTree
inf=1<<63
n=int(input())
a=list(map(int,input().split()))
def mapping(a,b):return a+b
def comp(a,b):return a+b
prefix=[]
dp=LazySegTree(max,-inf,mapping,comp,0,[0]*n)
pre=set()
for i in range(n):
    pre.add(a[i])
    prefix.append(len(pre))
idx=[-1]*(n+1)
X=[0]*(n+1)
for i in range(n):
    if idx[a[i]]==-1:
        dp.apply(0,i,1)
    else:
        dp.apply(idx[a[i]],i,1)
    X[i]=dp.prod(0,i)
    dp.set(i,prefix[i])
    idx[a[i]]=i
suf=set()
ans=0
suf.add(a[-1])
for i in range(n-2,0,-1):
    ans=max(ans,X[i]+len(suf))
    suf.add(a[i])
print(ans)