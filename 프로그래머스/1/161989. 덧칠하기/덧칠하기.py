def solution(n, m, section):
    now = section[0] + m -1
    cnt = 1
    for x in section:
        if x > now:
            now = x + m - 1
            cnt += 1
    return cnt

"""
롤러 m, 
경계밖 불가, 칸수맞추기 
페인트칠 최소횟수
이미 오름차 정렬

구역의 최소부터 롤러로 더하면서 칠하는 것 구하기


"""