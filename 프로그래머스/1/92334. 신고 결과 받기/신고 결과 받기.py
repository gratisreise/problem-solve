def solution(id_list, report, k):
    report_name = {}
    report_count = {}
    
    for id in id_list:
        report_name[id] = set()
        report_count[id] = 0
    
    # 신고한 유저의 이름저장
    for s in report:
        arr = s.split( )
        report_name[arr[0]].add(arr[1])
    
    # 신고받은 횟수 카운팅
    for id in report_name.keys():
        for report in report_name[id]:
            report_count[report] += 1
    
    # 이메일 발송 횟수 세기
    ret = []
    for id in report_name.keys():
        cnt = 0
        for name in report_name[id]:
            if report_count[name] >= k:
                cnt += 1
        ret.append(cnt)
        
    return ret
"""
한번에 한 명의 유저신고
    - 신고 횟수 제한x,
    - 동일 유저 신고 가능 -> 1회로 처리
k번 이상 신고된 유저는 게시판 이용 정지 -> 신고한 모든 유저에게 정지 이메일 발송
    - 신고 내용 모두 취합 하여 마지막에 정지와 동시에 이메일 발송
유저 - 신고한유저
유저 - 신고받은 횟수
정지대상 리스트

report에 대해 - 유저 - set(신고한 유저이름 저장)
유저 신고한 유저를 돌면서 -> 유저의 신고한 횟수 카운팅 
유저 - 신고한 유저를 돌면서 -> 신고횟수가 k이상이면 카운팅
"""