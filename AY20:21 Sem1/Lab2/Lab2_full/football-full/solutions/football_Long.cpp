/*input
5
2 4 1 0 3
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
const int N = 1e5 + 5;

int p[N];
bool mark[N];

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n;
    cin >> n;
    loop(i, 0, n - 1)cin >> p[i];
    int u = p[0]; mark[0] = true;
    while (true) {
        if (u == 0) {
            cout << "YES" << endl;
            return 0;
        }
        if (mark[u]) {
            cout << "NO" << endl;
            return 0;
        }
        mark[u] = true;
        u = p[u];
    }
}
