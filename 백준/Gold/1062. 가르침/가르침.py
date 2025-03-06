import sys

input = sys.stdin.readline

# 읽을 수 있는 단어 수 계산
def count(mask):
    return sum(1 for word in words if word and (word & mask) == word)

# 백트래킹으로 최대 단어 수 찾기
def solve(index, k, mask, chars):
    if k <= 0:  # 남은 글자 수 없으면 현재 결과 반환
        return count(mask)
    if index == len(chars):
        return count(mask)
    
    # 현재 글자 선택
    ret = solve(index + 1, k - 1, mask | (1 << chars[index]), chars)
    # 선택 안 함
    ret = max(ret, solve(index + 1, k, mask, chars))
    return ret

# 입력 처리
N, K = map(int, input().split())
words = [0] * N
all_chars = set()

for i in range(N):
    s = input().strip()
    for char in s:
        bit = ord(char) - ord('a')
        words[i] |= (1 << bit)
        if bit not in [0, 2, 8, 13, 19]:  # 필수 글자 제외
            all_chars.add(bit)

all_chars = list(all_chars)  # 탐색할 글자 목록

# 기본 글자 포함 초기 마스크
base_mask = (1 << 0) | (1 << 2) | (1 << 8) | (1 << 13) | (1 << 19)

# K < 5면 읽을 수 없음
if K < 5:
    print(0)
else:
    result = solve(0, K - 5, base_mask, all_chars)
    print(result)