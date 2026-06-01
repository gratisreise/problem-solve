def solution(arr, query):
    for i,x in enumerate(query):
        if i % 2 == 0:
            arr = arr[:x+1]
        else:
            arr = arr[x:]
    return arr
            
        
    