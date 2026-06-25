
    
        
def solution(A,B):
    A.sort()
    B.sort(reverse=True)
    return sum(x1*x2 for x1, x2 in zip(A,B))