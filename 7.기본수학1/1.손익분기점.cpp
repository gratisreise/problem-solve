#include <iostream>
using namespace std;
int main(){
    int A, B, C;
    cin>>A>>B>>C;
    if(B >= C){
        cout << -1<<'\n';
        return 0;//종료시점을 여기다 걸어줌
    }
    cout<<A/(C-B) + 1<<'\n';
}
