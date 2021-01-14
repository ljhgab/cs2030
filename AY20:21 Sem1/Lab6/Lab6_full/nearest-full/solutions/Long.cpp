/*input
6
1 4 1 5 5 1
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
const int INF = 1e9;
int n; int a[N];
int ans[N];
map<int, int> mark;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n;
    loop(i, 1, n) cin >> a[i];
    loop(i, 1, n) ans[i] = INF;
    loop(i, 1, n) {
        if (mark[a[i]] != 0)
            ans[i] = min(ans[i], i - mark[a[i]]);
        mark[a[i]] = i;
    }
    mark.clear();
    rloop(i, n, 1) {
        if (mark[a[i]] != 0)
            ans[i] = min(ans[i], mark[a[i]] - i);
        mark[a[i]] = i;
    }
    loop(i, 1, n) {
        if (ans[i] == INF) ans[i] = -1;
        cout << ans[i] << endl;
    }
}
