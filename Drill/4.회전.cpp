
<이차원 배열이 정사각일 때>
//왼쪽으로 90도
void rotate(vector<vector<int>> &key){
    int m = key.size();
    vector<vector<int>> temp(m, vector<int>(m, 0));
    for(int i = 0; i < m; i++){
        for(int j = 0; j < m; j++){
            temp[i][j] = key[j][m - i - 1];
        }
    }
    key = temp;
    return;
}

//오른쪽으로 90도
void rotate(vector<vector<int>> &key){
    int m = key.size();
    vector<vector<int>> temp(m, vector<int>(m, 0));
    for(int i = 0; i < m; i++){
        for(int j = 0; j < m; j++){
            temp[i][j] = key[m - j - 1][i];
        }
    }
    key = temp;
    return;
}

void _rotate90(){
        int temp[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = a[n - j - 1][i];
            }
        }
        memcpy(a, temp, sizeof(a));
    }