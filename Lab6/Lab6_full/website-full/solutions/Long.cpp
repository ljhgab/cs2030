/*input
11
4 usa
3
1 224.55.212.234 vnm 3
4 singapore
1 224.55.212.234 vnm 2
4 usa
1 36.242.10.124 brazil 4
1 183.250.153.191 singapore 4
2 vnm
2 singapore
4 singapore
2 brazil
1 183.250.153.191 singapore 3
1 183.250.153.191 singapore 1
4 usa
3
2 brazil
2 usa
*/
#include <bits/stdc++.h>
using namespace std;
#define int long long
#define sp ' '
#define endl '\n'
#define fi first
#define se second
#define bit(x,y) ((x>>y)&1)
#define loop(i,l,r) for(int i=(int)l; i<=(int)r; i++)
#define rloop(i,l,r) for(int i=(int)l; i>=(int)r; i--)
#ifdef UncleGrandpa
#include <prettyprint.hpp>
void print() {cout << endl;} template<typename T, typename... Ts> void print(const T& value, const Ts&... values) {cout << value << ' ', print(values...);}
void debug() {cerr << endl;} template<typename T, typename... Ts> void debug(const T& value, const Ts&... values) {cerr << value << ' ', debug(values...);}
#endif
// const int N =;

map<string, int> totalTime;
map<string, int> maxTimeCountry;
map<string, int> numIpFromCountry;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int q; cin >> q;
    loop(Q, 1, q) {
        int type; cin >> type;
        if (type == 1) {
            string ip, country; int duration;
            cin >> ip >> country >> duration;
            if (totalTime[ip] == 0) { // first time IP
                numIpFromCountry[country]++;
            }
            totalTime[ip] += duration;
            maxTimeCountry[country] = max(maxTimeCountry[country], totalTime[ip]);
        }
        else if (type == 2) {
            string country; cin >> country;
            if (maxTimeCountry.find(country) == maxTimeCountry.end()) // country hasn't appeared yet
                cout << 0 << endl;
            else
                cout << maxTimeCountry[country] << endl;
        } else if (type == 3) {
            cout << maxTimeCountry.size() << endl; // number of different country
        } else if (type == 4) {
            string country; cin >> country;
            if (numIpFromCountry.find(country) == numIpFromCountry.end()) // country hasn't appeared yet
                cout << 0 << endl;
            else
                cout << numIpFromCountry[country] << endl;
        }
    }
}
