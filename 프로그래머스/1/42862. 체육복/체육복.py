def solution(n, lost, reserve):
    student = [1] * n
    
    for x in lost:
        student[x-1] -= 1

    for x in reserve:
        student[x-1] += 1
        
    limit = len(student)
    for i in range(limit):
        if student[i] == 0:
            if i == 0:
                if student[i+1] > 1:
                    student[i+1] -= 1
                    student[i] += 1
            elif i == limit-1:
                if student[i-1] > 1:
                    student[i-1] -= 1
                    student[i] += 1
            else:
                if student[i-1] > 1:
                    student[i-1] -= 1
                    student[i] += 1
                elif student[i+1] > 1:
                    student[i+1] -= 1
                    student[i] += 1
                    
    return sum(1 for x in student if x >= 1)
                    

"""
가장많은 학생이 체육 수업을 듣게

1. 모든 학생1
2. lost 처리
3. reserve 처리
4. 앞뒤로 빌려보기


"""