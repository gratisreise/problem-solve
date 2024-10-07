function solution(n, numlist) {
    let ret = [];
    for(let i of numlist){
        if(i % n != 0) continue;
        ret.push(i);
    }
    return ret;
}