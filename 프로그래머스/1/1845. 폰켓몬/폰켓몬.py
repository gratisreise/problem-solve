def solution(nums):
    temp = set(nums)
    if len(temp) > len(nums)//2:
        return len(nums)//2
    else:
        return len(temp)
"""
1. 중복제거
2. 포켓몬 갯수를 2로 나눈 것보다 중복제거한 갯수가 크면 2로 나눈 수를 반환
아니면 중복제거한게 최대 종류수
"""