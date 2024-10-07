function solution(num_list) {
    let sum = 0;
    let product = 1;
    for(let i of num_list){
        sum += i;
        product *= i;
    }
    return product < sum * sum ? 1 : 0;
}