def solution(num_list, n):
    row, col = len(num_list) // n, n
    return [[num_list[i*n+j] for j in range(col)] for i in range(row)]