def solution(wallpaper):
    mnx, mny, mxx, mxy =1000, 1000, -1, -1
    row, col = len(wallpaper), len(wallpaper[0])
    for i in range(row):
        for j in range(col):
            if wallpaper[i][j] == '#':
                mnx, mny = min(mnx, i), min(mny, j)
                mxx, mxy = max(mxx, i), max(mxy, j)
    mxx += 1
    mxy += 1
    return [mnx,mny,mxx,mxy]

"""
왼쪽위(0, 0)
빈:., 파일:#
최소한의 이동거리를 갖는 한번의 드래그 


"""