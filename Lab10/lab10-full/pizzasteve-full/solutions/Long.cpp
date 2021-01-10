/*input
6 6 1 6
1 2 3
2 3 2
1 4 2
6 5 3
5 4 1
6 3 5
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

int n, m, S, T;
vector<vector<pair<int, int> > > a(N);

void dijkstra(int root, vector<int>& dis) {
    fill(dis.begin(), dis.end(), INF);
    dis[root] = 0;
    priority_queue<pair<int, int> , vector<pair<int, int> >, greater<pair<int, int> > > pq;
    pq.push({0, root});
    while (!pq.empty()) {
        auto [d, u] = pq.top(); pq.pop();
        if (d != dis[u]) continue;
        for (auto [v, w] : a[u]) {
            if (dis[v] > d + w) {
                dis[v] = d + w;
                pq.push({dis[v], v});
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
    }
    vector<vector<int> > dis(2, vector<int>(n + 1, 0));
    dijkstra(S, dis[0]); dijkstra(T, dis[1]);
    int ans = INF;
    loop(i, 1, n) {
        ans = min(ans, max(dis[0][i], dis[1][i]));
    }
    if (ans == INF) cout << "Sad" << endl;
    else cout << ans << endl;
}
