<구조체 기반 정렬연산 필요>
struct Point{ //구조체를 기반으로 정렬하는 연산이 필요할 때
    int y, x;
    Point(int y, int x) : y(y), x(x){}
    Point(){y = -1; x = -1;} // 정해지지 않는 경우 기본값으로 -1 설정
    bool operator <(const Point & a) const{ // 연산자 오버로딩
        if(x == a.x) return y < a.y; // x가 같다면 y기반으로 정렬
        return x < a.x;
    }
}

<3개>
struct Point{ //세개로 했을 때
    int y, x, z;
    point(int y, int x, int z) : y(y), x(x), z(z){}
    point(){y = -1; x = -1; z = -1;}
    bool operator < (const Point & a) const{
        if(x == a.x){ //x가 같다면
            if(y == a.y) return z < a.z; //y가 같다면
            return y > a.y;
        }
        return x < a.x;
    }
}

struct Point{
    int y, x;
}

bool cmp(const Point &a, const Point &b){
    return a.x > b.x;
}
