def solution(arr1, arr2):
    n = len(arr1)
    m = len(arr2[0])
    ret = [[0] * m for _ in range(n)]
    for i in range(len(ret)):
        for j in range(len(ret[i])):
            num = 0
            ans = 0
            while num < len(arr2):
                ans += (arr1[i][num] * arr2[num][j])
                num += 1
            ret[i][j] = ans
    return ret