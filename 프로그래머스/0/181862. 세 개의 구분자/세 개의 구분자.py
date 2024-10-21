import re
def solution(myStr): 
    return ["EMPTY"] if not [s for s in re.split("a|b|c", myStr) if s] else [s for s in re.split("a|b|c", myStr) if s] 