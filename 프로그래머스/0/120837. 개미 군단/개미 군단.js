function solution(hp) {
    var answer = 0;
    answer += Math.floor(hp / 5);
    hp %= 5;
    answer += Math.floor(hp / 3);
    hp %= 3;
    answer += hp;
    return answer;
}