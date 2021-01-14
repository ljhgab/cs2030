/*input
4 5 1 2
3 2 4 1
1 2
3 4
2 3
1 4
3 1
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
const int N = 3e5 + 5;

int n, m, S, T;
int val[N]; bool vis[N];
vector<vector<int> > a(N);

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m >> S >> T;
    loop(i, 1, n) cin >> val[i];
    loop(i, 1, m) {
        int u, v; cin >> u >> v;
        a[u].push_back(v);
        a[v].push_back(u);
    }
    queue<int> q; q.push(S); vis[S] = true;
    while (!q.empty()) {
        auto u = q.front(); q.pop();
        for (auto v : a[u]) {
            if (!vis[v] && val[v] > val[u]) {
                vis[v] = true;
                q.push(v);
            }
        }
    }
    if (vis[T]) cout << "YES" << endl;
    else cout << "NO" << endl;
}
