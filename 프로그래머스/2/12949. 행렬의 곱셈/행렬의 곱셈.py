def solution(arr1, arr2):
    n, m = len(arr1), len(arr2[0])
    ret = [[0] * m for _ in range(n)]
    for i in range(len(ret)):
        for j in range(len(ret[i])):
            num = 0
            while num < len(arr2):
                ret[i][j] += (arr1[i][num] * arr2[num][j])
                num += 1
    return ret