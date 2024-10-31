def solution(genres, plays):
    answer = [ ]
    genres_dict = {}
    play_dict = {}
    
    #장르별 총 재생 횟수와 각 곡의 재생 횟수 저장
    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]
        if genre not in genres_dict:
            genres_dict[genre] = []
            play_dict[genre] = 0
        genres_dict[genre].append((i, play))
        play_dict[genre] += play
    
    # 총 재생 횟수가 많은 장르순으로 정렬
    sorted_genres = sorted(play_dict.items(), key=lambda x: x[1], reverse=True)
    
    # 각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
    for genre, _ in sorted_genres:
        sorted_songs = sorted(genres_dict[genre], key=lambda x:(-x[1], x[0]))
        answer.extend([idx for idx,_ in sorted_songs[:2]])
        
    return answer
    
        
    
    
"""
- 총 재생 횟수를 기준으로 장르를 내림차순으로 정렬
- 각 장르별로 2곡씩 선정해서 플레이리스트 만들기
  **요소를 -붙여서 정렬의 순서를 반대로 가능**
"""