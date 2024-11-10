import re
def solution(new_id):
    #1
    new_id = new_id.lower()
    #2
    new_id = re.sub(r'[^a-z0-9\-\_\.]', '', new_id)
    #3
    new_id = re.sub(r'\.{2,}', '.', new_id)
    #4
    new_id = re.sub(r'^\.|\.$','', new_id)
    #5
    if not new_id: new_id = 'a'
    #6
    if len(new_id) >= 16: new_id = new_id[:15]
    if new_id[-1] == '.':new_id = new_id[:-1]
    #7
    while len(new_id) <= 2: new_id = new_id + new_id[-1]
    return new_id
