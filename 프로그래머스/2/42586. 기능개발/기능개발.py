def solution(progresses, speeds):
    prev, idx, ret = 0, 0, []
    while idx < len(progresses):
        for i in range(idx, len(speeds)):
            progresses[i] += speeds[i]
        while idx < len(progresses) and progresses[idx] >= 100:
            idx += 1
        if idx - prev > 0: ret.append(idx - prev)
        prev = idx
    return ret


"""
진도 100 서비스 반영
배포마다 반영되는 기능 갯수 반환
1. 매일 작업도 반영
2. 반영되는 기능의 갯수를 저장
3. 반영된 기능은 작업도 계산에서 제외반환
4. 기능 갯수의 모음을 반환
"""