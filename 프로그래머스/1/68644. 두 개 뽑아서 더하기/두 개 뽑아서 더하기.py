def solution(n):
     return sorted(list(set(n[i] + n[j] for i in range(len(n)) for j in range(len(n)) if i != j)))