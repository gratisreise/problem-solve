import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static class Course{
        public final String course;
        public final int occurcences;

        public Course(String course, int occurcences){
            this.course = course;
            this.occurcences = occurcences;
        }
    }
    //가능한 모든 문자들에 대해서 체크
    private void getCourse(
        char nextMenu,
        Set<String> selectedMenus, //현재까지 생성된 메뉴
        List<Set<String>> orderList, // 주문목록
        Map<Integer, List<Course>> courses // 길이 - 길이의 문자열 모음
    ){
        //현재까지 생성한 메뉴의 등장횟수 세기
        int occurences = (int)orderList.stream()
            .filter(order -> order.containsAll(selectedMenus))
            .count();

        //현재까지 만든 메뉴의 갯수가 2회 미만이면 더이상 생성할 필요 없음
        if(occurences < 2) return;

        //현재메뉴의 길이
        int size = selectedMenus.size();

        if(courses.containsKey(size)){
            //현재 길이와 같은 길이를 가지는 코스모임들 불러오기
            List<Course> courseList = courses.get(size);
            //현재 메뉴를 문자순으로 정렬해서 붙임
            Course course = new Course(selectedMenus.stream()
                .sorted()
                .collect(Collectors.joining("")), occurences);
            //현재 메뉴의 등장횟수 이전에 저장된 코스 모음의 등장횟수 비교
            Course original = courseList.get(0);
            if(original.occurcences < occurences){
              courseList.clear();
              courseList.add(course);
            } else if(original.occurcences == occurences){
                courseList.add(course);
            }
        }

        if(size >= 10) return;
        for(char menuChar = nextMenu; menuChar <= 'Z'; menuChar++){
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourse((char)(menuChar+1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu); //원복
        }

    }
    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
            .map(String::chars)
            .map(charStream -> charStream
                .mapToObj(menu -> String.valueOf((char) menu))
                .collect(Collectors.toSet()))
            .collect(Collectors.toList());
        Map<Integer, List<Course>> courses = new HashMap<>();
        for(int length : course){
            List<Course> list = new ArrayList<>();
            list.add(new Course("",0));
            courses.put(length, list);
        }
        getCourse('A', new HashSet<>(), orderList, courses);
        return courses.values().stream()
            .filter(list -> list.get(0).occurcences > 0)
            .flatMap(List::stream)
            .map(c -> c.course)
            .sorted()
            .toArray(String[]::new);

    }
}
/* 아이디어
* 문자의 조합을 만들어 나가면서 필요없는 경우를 제거
* */