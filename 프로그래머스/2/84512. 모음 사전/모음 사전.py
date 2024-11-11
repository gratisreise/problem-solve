def make_word(s, c, words):
    if len(s) == 5:
        return words.append(''.join(s))
    if len(s) >= 0:
        words.append(''.join(s))
    for char in c:
        s.append(char)
        make_word(s, c, words)
        s.pop()

def solution(word):
    c = ['A', 'E', 'I', 'O', 'U']
    words = []
    make_word([], c, words)
    return words.index(word)