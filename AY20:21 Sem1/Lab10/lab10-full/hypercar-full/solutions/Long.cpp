/*input
6 7 1 6
1 2 6
2 3 5
3 6 1
1 3 2
2 4 2
1 4 3
4 6 4
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

struct dsu { // union by rank + path compress
    vector<int> par, sz;
    void init(int n) {
        par.assign(n + 5, 0); sz.assign(n + 5, 1);
        iota(par.begin(), par.end(), 0);
    }
    int find(int x) {
        return par[x] = (par[x] == x ? x : find(par[x]));
    }
    void uni(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) {
            if (sz[x] > sz[y]) swap(x, y);
            sz[y] += sz[x]; sz[x] = 0;
            par[x] = y;
        }
    }
} d;

struct Edge {
    int u, v, w;
};
int n, m, S, T;
vector<Edge> e;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m >> S >> T;
    d.init(n);
    loop(i, 1, m) {
        int u, v, w;
        cin >> u >> v >> w;
        e.push_back({u, v, w});
    }
    sort(e.begin(), e.end(), [](Edge A, Edge B) {
        return A.w > B.w;
    });
    for (auto &it : e) {
        d.uni(it.u, it.v);
        if (d.find(S) == d.find(T)) {
            cout << it.w << endl;
            return 0;
        }
    }
    cout << "Impossible" << endl;
}
