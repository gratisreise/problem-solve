def solution(arr, delete_list):
    return sorted((set(arr) - set(delete_list)), key=lambda x: arr.index(x))