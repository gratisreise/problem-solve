def solution(dots):
    xs, ys = set(), set()
    for dot in dots:
        xs.add(dot[0])
        ys.add(dot[1])
    xs, ys = list(xs), list(ys)
    return abs(xs[0] - xs[1]) * abs(ys[0] - ys[1])