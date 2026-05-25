def solution(arr):
    n = max(len(arr), len(arr[0]))
    print(n)
    ret = [[0] *n for _ in range(n)]
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            ret[i][j] =  arr[i][j]
    return ret