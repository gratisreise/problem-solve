function solution(n) {
    var answer = [];
    for(let i = 0; i < n / 2; i++) answer[i] = 2 * i + 1;
    return answer;
}