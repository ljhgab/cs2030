/*input
6 8 1 6
1 2 1
2 3 2
3 6 3
4 1 4
4 5 1
5 6 1
1 3 3
5 1 7
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
const int N = 2e5 + 5;
const int INF = 1e18;
const int mod = 1e9 + 7;

int n, m, S, T;
vector<vector<pair<int, int> > > a(N);
int dis[N]; int ways[N];

void dijkstra(int root) {
    fill(dis + 1, dis + N, INF);
    dis[root] = 0; ways[root] = 1;
    priority_queue<pair<int, int> , vector<pair<int, int> >, greater<pair<int, int> > > pq;
    pq.push({0, root});
    while (!pq.empty()) {
        auto [d, u] = pq.top(); pq.pop();
        if (d != dis[u]) continue;
        for (auto [v, w] : a[u]) {
            if (dis[v] > d + w) {
                dis[v] = d + w; ways[v] = ways[u];
                pq.push({dis[v], v});
            }
            else if (dis[v] == d + w) {
                ways[v] = (ways[v] + ways[u]) % mod;
            }
        }
    }
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m >> S >> T;
    loop(i, 1, m) {
        int u, v, w;
        cin >> u >> v >> w;
        a[u].push_back({v, w});
        a[v].push_back({u, w});
    }
    dijkstra(S);
    cout << dis[T] << sp << ways[T] << endl;
}
