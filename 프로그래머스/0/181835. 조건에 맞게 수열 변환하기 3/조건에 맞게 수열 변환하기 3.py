def solution(arr, k):
    return [x*k for x in arr] if k % 2== 1 else [x+k for x in arr]