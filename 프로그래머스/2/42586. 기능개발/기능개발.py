def solution(progresses, speeds):
    idx = 0
    ret = []
    while idx < len(speeds):
        for i in range(idx, len(speeds)):
            progresses[i] += speeds[i]
        cnt = 0
        while idx < len(speeds) and progresses[idx] >= 100:
            cnt += 1
            idx += 1
        if cnt > 0: ret.append(cnt)
    return ret
"""
진도가 100일 때 서비스 반영가능
진도는 100미만
속도는 100이하의 자연수
배포는 하우레 한 번만 가능 

"""


