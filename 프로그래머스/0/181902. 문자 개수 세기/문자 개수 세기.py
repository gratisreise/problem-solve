def solution(my_string):
    count = [0] * 52
    for char in my_string:
        if char.isupper():
            count[ord(char) - ord('A')] += 1
        elif char.islower():
            count[ord(char) - ord('a')+26] += 1
    return count