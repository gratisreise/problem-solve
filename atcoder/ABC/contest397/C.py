import sys
input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))
temp1 = [0]*(n-1)
st = set()
for i in range(n-1):
    st.add(nums[i])    
    temp1[i] = len(st)
st = set()
ret = -1
idx = n - 2
for i in range(n-1, 0, -1):
    st.add(nums[i])
    ret = max(temp1[idx]+len(st),ret)
    idx -= 1
print(ret)