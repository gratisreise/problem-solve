def solution(genres, plays):
    genre_count = {g:0 for g in set(genres)}
    genre_num = {g:[] for g in set(genres)}
    genre = list(set(genres))
    #장르 내림차
    
    
    # 장르별 고유번호 리스트 저장
    for i,g in enumerate(genres):
        genre_count[g] += plays[i]
        genre_num[g].append(i)
    
    # 장르별 고유번호 리스트 조회수 별로 내림차
    for k in genre_num.keys():
        arr = genre_num[k]
        genre_num[k] = sorted(arr, key=lambda x: plays[x], reverse=True)
    print(genre_num)
    
    genre = sorted(genre, key=lambda x: genre_count[x], reverse=True)
    ret = []
    for g in genre:
        ret.extend(genre_num[g][:2])
    return ret
    
    # return sorted(ret, key=lambda i:(genre_count[genres[i]], plays[i]), reverse=True)

# 재생된 장르 내림차, 노래별 횟수 내림차, 고유번호 오름차
# 장르-고유번호리스트, 장르이름 내림차, 장르 - 재생횟수
# 장르이름 내림차
# 