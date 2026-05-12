
def solution(myString):
    return sorted(list(filter(lambda x: x, myString.split("x"))))