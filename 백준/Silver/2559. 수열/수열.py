psum = [0]*100004

n, k = map(int, input().split())
nums = list(map(int, input().split()))
for i in range(1, len(nums)+1):
    psum[i] = psum[i-1] + nums[i-1]
ret = -1e9
for i in range(k, len(nums)+1):
    ret = max(ret, psum[i] - psum[i-k])
print(ret)