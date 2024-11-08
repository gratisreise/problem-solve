def solution(n):
    tri = [[0]*(i+1) for i in range(n)]
    dy, dx = [1, 0, -1], [0, 1, -1]
    y, x, d, num = 0, 0, 0, 1
    
    while True:
        tri[y][x] = num
        num += 1
        ny, nx = y + dy[d], x + dx[d]
        if 0 <= ny < n and 0 <= nx < n and tri[ny][nx] == 0:
            y, x = ny, nx
        else:
            d = (d+1) % 3
            ny, nx = y + dy[d], x + dx[d]
            
            if 0 <= ny < n and 0 <= nx < n and tri[ny][nx] == 0:
                y, x = ny, nx
            else:
                break
        
    return [num for arr in tri for num in arr]



"""
시작좌표 = (0, 0), 시작숫자 = 1
 0      1        2
y + 1, x + 1, y - 1 x - 1
1. 다음을 반복
    1-1. 자리에 숫자을 채운다
    1-2. 경계에 닿으면 방향을 바꿔준다
    1-3. 다음 자리에 숫자가 있으면 방향을 바꿔준다
    1-4. 두번 예외인 경우이면 반복을 그만한다.
2. 맨위에서부터 저장된 숫자를 가져와서 다시 넣어준다.
"""