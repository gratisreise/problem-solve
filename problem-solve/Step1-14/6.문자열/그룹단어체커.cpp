#include <bits/stdc++.h>
using namespace std;
int main() { 
	int N;                                // 입력받을 단어의 개수
	string word;                          // 입력받은 단어
	int count = 0;                        // 그룹 단어가 아니라면 카운트

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> word;
        
		// 단어에서 알파벳 문자의 출현유무를 나타내는 배열 (출현없으면 false)
		bool alphabet[26] = { false, };        
		alphabet[(int)(word[0]) - 97] = true;  // 첫번째 단어값을 true로 설정

		for (int i = 1; i < word.size(); i++) {
        
			// 1. i번째 문자가 i-1번째 문자와 같으면 연속이므로 넘어간다.
			if (word[i] == word[i - 1]) {
				continue;
			}
            
			// 2. i번째 문자가 i-1번째 문자와 같지 않고, (연속하지 않고)
			//    해당 배열값이 true라면 (이미 나왔던 문자라면)
			else if(word[i] != word[i - 1] && alphabet[(int)(word[i]) - 97] == true){
				count++;	// 그룹단어가 아니므로 카운트
				break;
			}
            
			// 3. 위의 두 경우에 해당하지 않는 경우
			//    처음 등장한 문자인 경우
			else {
				alphabet[(int)(word[i]) - 97] = true;
			}
		}
	}

	// 그룹 단어의 개수 = 전체단어의 개수 - 그룹단어가 아닌 단어의 개수
	cout << N - count;

	return 0;
}