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
"""
### 코드 설명

### **목표**

- N개의 단어와 배울 수 있는 글자 수 K가 주어졌을 때, 필수 글자 a, n, t, i, c를 포함해 최대 읽을 수 있는 단어 수를 구한다.

### **입력 처리**

- **N, K**: 단어 수와 배울 글자 수 입력.
- **words**: 각 단어를 비트마스크로 저장 (최대 50개).
    - 단어의 각 글자를 ord(char) - ord('a')로 비트 위치 계산.
    - | 연산으로 단어의 모든 글자를 정수로 표현.
- **all_chars**: 단어에서 등장하는 필수 글자 제외 글자 집합 (최대 21개).
    - 기본 글자 a, n, t, i, c (비트: 0, 13, 19, 8, 2) 제외.

### **함수**

1. **count(mask)**:
    - **역할**: 현재 선택된 글자 마스크(mask)로 읽을 수 있는 단어 수 계산.
    - **동작**: 각 단어의 비트마스크(word)가 mask에 모두 포함되면 카운트 증가.
    - **조건**: (word & mask) == word → 단어의 모든 글자가 mask에 포함.
    - **반환**: 읽을 수 있는 단어 수.
2. **solve(index, k, mask, chars)**:
    - **역할**: 백트래킹으로 최대 단어 수 탐색.
    - **매개변수**:
        - index: 현재 탐색 중인 글자 인덱스 (chars 기준).
        - k: 남은 선택 가능 글자 수.
        - mask: 현재 선택된 글자의 비트마스크.
        - chars: 탐색할 글자 리스트.
    - **종료 조건**:
        - k <= 0: 더 선택 불가 → 현재 결과 반환.
        - index == len(chars): 모든 글자 탐색 완료 → 결과 반환.
    - **동작**:
        - 현재 글자 선택: mask | (1 << chars[index])로 추가, k-1.
        - 선택 안 함: 다음 글자로 이동.
        - 두 경우 중 최대값 반환.
    - **반환**: 가능한 최대 단어 수.

### **메인 로직**

- **기본 마스크**: base_mask로 필수 글자 a, n, t, i, c 설정.
- **조건 체크**: K < 5면 필수 글자 충족 불가 → 0 출력.
- **탐색**: K-5개 글자를 추가 선택하며 최대 단어 수 계산.

### **출력**

- 최대 읽을 수 있는 단어 수 출력.
"""