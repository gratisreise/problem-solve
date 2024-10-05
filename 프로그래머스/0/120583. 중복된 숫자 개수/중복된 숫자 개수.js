function solution(array, n) {
    var answer = 0;
    for(var i of array) if(i == n) answer++;
    return answer;
}