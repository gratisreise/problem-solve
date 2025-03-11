def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    n = int(data[0])  # 사람의 수
    heights = list(map(int, data[1:n+1]))  # 각 사람의 키

    stack = []  # 스택 (키, 동일 키의 등장 횟수)
    result = 0  # 서로 볼 수 있는 쌍의 총 개수

    for height in heights:
        # 현재 사람보다 작은 사람들을 스택에서 제거하며 쌍 개수 추가
        while stack and stack[-1][0] < height:
            result += stack.pop()[1]

        # 스택이 비어있지 않고, 현재 사람과 키가 같은 경우 처리
        if stack and stack[-1][0] == height:
            count = stack.pop()[1]
            result += count
            if stack:  # 스택에 남아 있는 사람과도 쌍을 이룸
                result += 1
            stack.append((height, count + 1))
        else:
            # 스택이 비어있지 않으면 현재 사람과 스택의 top이 서로 볼 수 있음
            if stack:
                result += 1
            stack.append((height, 1))

    print(result)

if __name__ == "__main__":
    main()
