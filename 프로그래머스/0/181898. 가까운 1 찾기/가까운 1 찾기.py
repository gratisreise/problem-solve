def solution(arr, idx):
    try:
        return arr[idx:].index(1) + idx
    except:
        return -1