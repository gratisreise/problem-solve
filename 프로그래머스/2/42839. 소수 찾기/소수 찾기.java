import java.util.*;
import java.util.stream.*;

class Solution {
    private Set<Integer> getPrimes(int acc, List<Integer> numbers){
        //종료조건
        Set<Integer> primes = new HashSet<>();
        if(isPrime(acc)) primes.add(acc);
        if(numbers.isEmpty()) return primes;
        
        //상태전이 구현
        for(int i = 0; i < numbers.size(); i++){
            //numbers.get(i)로 상태 전이 진행
            int nextAcc = acc * 10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers));
        }
        
        return primes;
    }
    
    private boolean isPrime(int n){
        if(n <= 1) return false;
        //n의 제곱근 보다 작은 수 들을 체크한다
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public int solution(String nums) {
        List<Integer> numbers = nums.chars()
            .map(c -> c - '0')
            .boxed()
            .collect(Collectors.toList());
        
        return getPrimes(0, numbers).size();
    }
}
/*
상태
1. 지금까지 만들어 놓은 숫자
2. 사용할 수 있는 종이 조각들
(acc, number)
*/