import java.util.*;
import java.util.function.Consumer;
class Solution {

    //전처리: 모든 조건에 대한 점수의 모임을 구한다-> "-"는 어떻게 처리하지??
    private Map<String, List<Integer>> buildScoresMap(String[] info){
        //문자열 검색조건 : 해당검색조건의 점수들 -> 해당하는 조건의 점수의 모임
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        //모든 조건의 조합을 찾아서 거기에 점수를 넣어준다.
        for(String s : info){
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            //scoresMap에 가능한 조건이랑 점수추가 -> 아이디어: 재귀를 돌면서
            forEachKey(0, "", tokens, key ->{
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        //정렬을 하는 이유는 나중에 이진탐색을 하기 위해서
        for(List<Integer> list : scoresMap.values()){
            Collections.sort(list);
        }

        return scoresMap;
    }

    //아이디어: 문자열 재귀 완전탐색
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action){
        if(index == tokens.length - 1){
            //prefix가 만들어진 검색 조건
            action.accept(prefix);
            return;
        }
        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }
    private int count(String query, Map<String, List<Integer>> scoresMap){
        //scoresMap을 이용하여 query에 맞는 지원자 수 세기
        String[] tokens = query.split(" (and)?");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
        if(!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }
    private int binarySearch(int score, List<Integer> scores){
        //이진 탐색으로 인덱스 찾기
        int start = 0;
        int end = scores.size() - 1;
        while(end > start){
            //중간 값에 따라 범위 좁히기
            int mid = (start + end) / 2;
            if(scores.get(mid) >= score){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if(scores.get(start) < score){
            return scores.size();
        }
        return start;
    }
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);
        int[] answer = new int[query.length];
        for(int i = 0; i < answer.length; i++){
            //정답구하기
            answer[i] = count(query[i], scoresMap);
        }
        return answer;
    }
}
/*
- 언어: cpp, java, python
- 직군: backend, frontend
- 경력: junior, senior
- 푸드: chicken, pizza
- 점수: 0~
조건을 만족하는 점수 x점 이상 받은 사람
조건 - 점수 

*/