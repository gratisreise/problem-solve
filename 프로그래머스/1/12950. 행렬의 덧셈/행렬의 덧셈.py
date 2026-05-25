def solution(arr1, arr2):
    row, col = len(arr1), len(arr1[0])
    ret = [[0] * col for _ in range(row)]
    for i in range(row):
        for j in range(col):
            ret[i][j] = arr1[i][j] + arr2[i][j]
    return ret
            