from collections import defaultdict

def solution(message, spoiler_ranges):
    n = len(message)

    # 각 문자 위치가 몇 번째 스포 구간에 속하는지 기록
    reveal_idx = [0] * n
    for idx, (s, e) in enumerate(spoiler_ranges, start=1):
        for i in range(s, e + 1):
            reveal_idx[i] = idx

    normal_words = set()      # 스포 구간이 아닌 영역에서 등장한 단어
    spoiler_words = []        # (공개시점, 시작위치, 단어)

    i = 0
    while i < n:
        if message[i] == ' ':
            i += 1
            continue

        start = i
        while i < n and message[i] != ' ':
            i += 1
        end = i - 1

        word = message[start:i]

        reveal_time = 0
        is_spoiler = False

        for pos in range(start, end + 1):
            if reveal_idx[pos] > 0:
                is_spoiler = True
                reveal_time = max(reveal_time, reveal_idx[pos])

        if is_spoiler:
            spoiler_words.append((reveal_time, start, word))
        else:
            normal_words.add(word)

    # 공개 순서: 스포 구간 클릭 순서 -> 같은 시점이면 왼쪽부터
    spoiler_words.sort(key=lambda x: (x[0], x[1]))

    revealed = set()
    answer = 0

    for _, _, word in spoiler_words:
        if word not in normal_words and word not in revealed:
            answer += 1

        # 중요 여부와 상관없이 이미 공개된 스포 단어로 취급
        revealed.add(word)

    return answer