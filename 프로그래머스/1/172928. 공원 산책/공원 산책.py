def solution(park, routes):
    board = []
    for p in park:
        board.append([c for c in p])
    row, col = len(board), len(board[0])
    ret = []
    for i in range(row):
        for j in range(col):
            if board[i][j] == 'S':
                ret = [i, j]    
    dy,dx = [-1, 0, 1, 0], [0, 1, 0, -1]
    direc = {"N": 0, "E":1, "S":2, "W":3}
    for rou in routes:
        cmd = rou.split()
        size = int(cmd[1])
        dd = direc[cmd[0]]
        ny, nx = ret[0] + dy[dd]*size, ret[1] + dx[dd]*size
        if ny < 0 or ny >= row or nx < 0 or nx >= col:
            continue
        flag = False
        ty, tx = ret
        while tx != nx or ty != ny:
            ty, tx = ty + dy[dd], tx + dx[dd]
            if board[ty][tx] == 'X':
                flag = True
                break
        if flag: continue
        ret = [ny, nx]
        
    return ret
        
        



"""
[조건]
이동시 장애물, 경계밖 확인 => 명령을 무시
모든 명령을 수행한 후 로봇이 놓일 위치 [세로, 가로]
50 * 50 보드

[아이디어]
경계밖 체크 후 장애물 체크 후 좌표 옮기기

[자료구조]
방향벡터, 문자방향인덱스, 결과좌표, 변형보드 

[로직]
1.라우트 순회
2. 각 라우트 별로 다음을 진행 
    2-1. 경계밖인지 체크 => 맞으면 무시
    2-2. 이동시 장애물 있는지 확인 => 맞으면 무시
    2-3. 이동
3. 결과 좌표 반환

"""