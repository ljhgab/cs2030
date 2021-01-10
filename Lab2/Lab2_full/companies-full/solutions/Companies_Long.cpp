/*input
6 4
0 0 0 1 2 3
2
2 3
0 2
*/
#include <bits/stdc++.h>
using namespace std;
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

int n, m;
vector<int> com[N];
bool exist[N];

void Union(int u, int v) {
    if (com[u].size() < com[v].size()) com[u].swap(com[v]);
    com[u].insert(com[u].end(), com[v].begin(), com[v].end());
    com[v].clear(); exist[v] = false;
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m;
    loop(i, 0, m - 1) {
        int x; cin >> x;
        while (x--) {
            int y; cin >> y;
            com[i].push_back(y);
        }
    }
    loop(i, 0, m - 1) exist[i] = true;
    int q; cin >> q;
    while (q--) {
        int u, v; cin >> u >> v;
        Union(u, v);
    }
    int ans = 0;
    loop(i, 0, m - 1) ans += exist[i];
    cout << ans << endl;
    loop(i, 0, m - 1) {
        if (!exist[i]) continue;
        cout << i << sp << com[i].size() << sp;
        sort(com[i].begin(), com[i].end());
        for (auto it : com[i]) cout << it << sp;
        cout << endl;
    }
}
