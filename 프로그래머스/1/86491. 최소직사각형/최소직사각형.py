def solution(sizes):
    max_width = max(min(w, h) for w, h in sizes)
    max_height = max(max(w, h) for w, h in sizes)
    return max_width * max_height
