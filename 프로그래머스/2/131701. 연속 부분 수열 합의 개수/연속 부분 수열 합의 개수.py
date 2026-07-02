def solution(elements):
    l = len(elements)
    elements = elements * 2
    psum = [0] * (len(elements)+1)
    
    for i in range(1, len(elements)+1):
        psum[i] = psum[i-1] + elements[i-1]
    print(psum)
    ret = set(elements)
    for size in range(2, l+1):
        st = set()
        for i in range(size, l+size):
            ret.add(psum[i] - psum[i - size])
            st.add(psum[i] -psum[i-size])
    return len(ret)