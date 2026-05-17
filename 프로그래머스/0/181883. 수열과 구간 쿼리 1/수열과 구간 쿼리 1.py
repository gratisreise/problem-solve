def solution(arr, queries):
    for row in queries:
        for i in range(row[0], row[1]+1):
            arr[i] += 1
    return arr
            