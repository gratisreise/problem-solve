def solution(my_string, indices):
    return ''.join(c for i,c in enumerate(my_string) if i not in indices)