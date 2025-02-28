n, k = map(int, input().split())
nums = list(map(int, input().split()))

# 초기 윈도우 합 계산
window_sum = sum(nums[:k])
max_sum = window_sum

# 슬라이딩 윈도우 이동
for i in range(n - k):
    window_sum = window_sum - nums[i] + nums[i + k]
    max_sum = max(max_sum, window_sum)

print(max_sum)

"""
슬라이딩 윈도우
개선 사항

메모리 효율성: 
    누적 합 배열을 사용하지 않고 슬라이딩 윈도우를 사용하여 메모리 사용량을 줄였습니다.
시간 효율성: 
    슬라이딩 윈도우를 사용하여 매번 k개의 수의 합을 다시 계산하는 대신, 이전 합에서 첫 번째 수를 빼고 다음 수를 더하여 효율적으로 합을 계산합니다.
가독성: 
    변수 이름을 명확하게 지정하여 코드의 가독성을 높였습니다.


"""