def solution(genres, plays):
    answer = []

    info = {} # 장르 - (고유번호, 재생횟수)
    gens = {} # 장르 - 재생횟수

    # 숨은 오름차순 -> 고
    for idx, (gen, play) in enumerate(zip(genres, plays)):
        if gen not in info:
            info[gen] = [(idx, play)]
        else:
            info[gen].append((idx, play))
        
        # 장르 재생횟수
        gens[gen] = gens.get(gen, 0) + play
        
    # 장르별 내림차순
    for (gen, _) in sorted(gens.items(), key=lambda x:x[1], reverse=True):
        for (idx, _) in sorted(info[gen], key=lambda x:x[1], reverse=True)[:2]:
            answer.append(idx)

    return answer

