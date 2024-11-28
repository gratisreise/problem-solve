def solution(record):
    actions = []
    output_str = {"Enter":"님이 들어왔습니다.", "Leave":"님이 나갔습니다."}
    names = {}
    for r in record:
        srr = r.split()
        if len(srr) == 2:
            actions.append((srr[0], srr[1]))
        else:
            names[srr[1]] = srr[2]
            if srr[0] == "Enter":
                actions.append((srr[0], srr[1]))
    return [(names[action[1]] + output_str[action[0]]) for action in actions]
"""
아이디 - 이름
행동 - 출력 문자열
행동리스트 (행동, 아이디)


"""