#include<iostream>
using namespace std;
int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	for (int i = 1; i < 1000; i++)
	{
		if (i%a == 0 && i%b == 0 && i%c == 0)
		{
			cout << i;
			return 0;
		}
	}
}