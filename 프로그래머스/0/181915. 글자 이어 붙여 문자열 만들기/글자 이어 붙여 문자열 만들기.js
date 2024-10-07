function solution(my_string, index_list) {
    let ret = '';
    for(let i of index_list) ret += my_string[i];
    return ret;
}