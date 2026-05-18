def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

def solution(arr, queries):
    for x in queries:
        swap(arr, x[0], x[1])
    return arr