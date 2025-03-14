import sys
input = sys.stdin.readline
output = sys.stdout.write
t = int(input())
for _ in range(t):
    n1 = int(input())
    nums1 = set(map(int, input().split()))
    n2 = int(input())
    nums2 = list(map(int, input().split()))
    for num in nums2:
        output(f"{1 if num in nums1 else 0}\n")