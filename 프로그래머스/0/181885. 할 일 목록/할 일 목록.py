def solution(todo_list, finished):
    return [x for i, x in enumerate(todo_list) if not finished[i]]
    