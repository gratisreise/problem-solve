def solution(dots):
    x_coords = [dot[0] for dot in dots]  # 모든 점의 x좌표 추출
    y_coords = [dot[1] for dot in dots]  # 모든 점의 y좌표 추출

    # 가로 길이와 세로 길이 계산
    width = max(x_coords) - min(x_coords)
    height = max(y_coords) - min(y_coords)

    # 넓이 계산
    return width * height
