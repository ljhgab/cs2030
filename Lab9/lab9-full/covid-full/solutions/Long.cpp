/*input
7 6
1 2
1 3
2 4
3 4
5 6
5 7
2
1 5
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

int n, m;
vector<vector<int> > a(N);
queue<pair<int, int> > q;
bool vis[N];

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m;
    loop(i, 1, m) {
        int u, v; cin >> u >> v;
        a[u].push_back(v);
        a[v].push_back(u);
    }
    int k; cin >> k;
    loop(i, 1, k) {
        int u; cin >> u;
        vis[u] = true;
        q.push({u, 0});
    }

    int ans = 0;
    for (int lev = 0;; lev++) {
        if (q.empty()) {
            break;
        }
        while (!q.empty() && q.front().se == lev) {
            auto [u, _] = q.front(); q.pop();
            for (auto v : a[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.push({v, lev + 1});
                }
            }
        }
        ans = lev;
    }

    loop(i, 1, n) {
        if (!vis[i]) {
            cout << "Some are safe!" << endl;
            return 0;
        }
    }
    cout << ans << endl;
}
