
def solution(balls, share):
    r = min(share, balls - share)
    n = balls
    top, bottom = 1, 1
    while r > 0:
        top *= n
        bottom *= r
        if top % bottom == 0: 
            top // bottom
        n -= 1
        r -= 1
    return top // bottom