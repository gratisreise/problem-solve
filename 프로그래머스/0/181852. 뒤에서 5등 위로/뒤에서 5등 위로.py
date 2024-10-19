def solution(num_list):
    num_list.sort()
    return [x for i, x in enumerate(num_list) if i >= 5]