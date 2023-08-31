#include <bits/stdc++.h>
using namespace std;

bool cmp(pair<int, string> age, pair<int, string> name)
{
	return age.first < name.first;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, age;
	string name;
	vector<pair<int, string>> vec;

	cin >> N;
	for (auto i = 0; i < N; i++)
	{
		cin >> age >> name;
		vec.push_back(make_pair(age, name));
	}
	stable_sort(vec.begin(), vec.end(), cmp);

	for (auto i = 0; i < vec.size(); i++)
	{
		cout << vec[i].first << " " << vec[i].second << "\n";
	}
}