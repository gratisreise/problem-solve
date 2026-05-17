def solution(arr):
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            if i == j: continue
            if arr[i][j] != arr[j][i]:
                return 0
    return 1