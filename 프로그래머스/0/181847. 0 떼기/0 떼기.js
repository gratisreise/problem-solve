function solution(n_str) {
    let flag = false;
    let ret = '';
    for(let c of n_str){
        if(c != 0) flag = true;
        if(!flag && c == '0') continue;
        ret += c;
    }
    return ret;
}