def solution(num, total):
    ret = []
    mid = int(total/num)
    t = 1
    if num % 2 != 0:
        ret.append(mid)
        while sum(ret) != total or len(ret) != num: 
            print(mid-t, mid, mid +t)
            ret.append(mid - t)
            ret.append(mid + t)
            t += 1
    else:
        l = mid
        r = mid + 1
        while sum(ret) != total or len(ret) != num:
            print(l, r)
            ret.append(l)
            ret.append(r)
            l-=1
            r+=1
    ret.sort()
    return ret