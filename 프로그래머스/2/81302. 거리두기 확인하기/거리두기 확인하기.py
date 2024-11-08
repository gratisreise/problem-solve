
def go(y, x, place, vis, cnt):
    dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]
    vis[y][x] = 1 
    if cnt == 2: return 0
    ret = 0
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if ny < 0 or nx < 0 or ny >= 5 or nx >= 5: continue
        if place[ny][nx] == 'X' or vis[ny][nx]: continue
        if place[ny][nx] == 'P': return 1
        ret = ret or go(ny, nx, place, vis, cnt+1)
    return ret

def check(place):
    for i in range(5):
        for j in range(5):
            if place[i][j] == 'P':
                vis = [[0]*5 for _ in range(5)]
                if go(i, j, place, vis, 0): 
                    return 0
    return 1

def solution(places):
    return [check(place) for place in places]
"""
응시자들 끼리 맨해튼 거리 2 이하, 파티션으로 가로막히면 허용
거리 2 이내에 내가 도달할 수 있는 사람이 있으면 거리두기 실패
거리두기 지키면 1, 아니면 0

1. 모든 자리배치에 대해 다음을 반복
  1-1. 거리 2 이내에 내가 도달할 수있는 사람이 있는지 확인
  1-2. 있으면 0, 아니면 1 리턴
2. 배열 반환

"""