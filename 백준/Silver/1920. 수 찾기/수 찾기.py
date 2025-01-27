import sys
def bi_search(n):
    l ,r = 0,len(nums)-1
    while l <= r:
        mid = (l + r) // 2
        if n > nums[mid]: 
            l = mid + 1
        elif n < nums[mid]: 
            r = mid - 1
        else: return True
    return False

ip, op = sys.stdin, sys.stdout
n  =  int(ip.readline())
nums = sorted(map(int, ip.readline().split()))
m = int(ip.readline())
nums2 = map(lambda x: 1 if bi_search(int(x)) else 0, ip.readline().split())
op.write('\n'.join(map(str, nums2))+'\n')