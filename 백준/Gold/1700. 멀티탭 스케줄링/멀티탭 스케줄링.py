import sys
input = sys.stdin.readline

# 입력 받기
k, n = map(int, input().split())
a = list(map(int, input().split()))

# 방문 체크와 멀티탭 상태 관리
visited = [False] * 104  # C++ 코드에서 a[104]와 visited[104]를 사용했으므로 동일하게
multitap = []  # 현재 멀티탭에 꽂혀있는 기기들
cnt = 0  # 플러그를 뽑은 횟수

# 각 기기를 순서대로 확인
for i in range(n):
    # 이미 꽂혀있는 기기면 스킵
    if visited[a[i]]:
        continue
        
    # 멀티탭에 빈 자리가 있으면 바로 꽂기
    if len(multitap) < k:
        multitap.append(a[i])
        visited[a[i]] = True
    else:
        # 멀티탭이 꽉 찼을 때
        last_idx = 0
        to_remove = 0
        
        # 현재 멀티탭에 있는 각 기기에 대해
        for device in multitap:
            # 이후에 다시 사용되는 가장 늦은 위치 찾기
            here_pick = float('inf')
            for j in range(i + 1, n):
                if a[j] == device:
                    here_pick = j
                    break
                    
            # 더 늦게 사용되거나 사용되지 않는 기기를 찾기
            if last_idx < here_pick:
                last_idx = here_pick
                to_remove = device
        
        # 선택된 기기 제거하고 새 기기 꽂기
        visited[to_remove] = False
        multitap.remove(to_remove)
        multitap.append(a[i])
        visited[a[i]] = True
        cnt += 1

print(cnt)