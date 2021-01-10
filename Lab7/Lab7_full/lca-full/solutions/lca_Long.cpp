/*input
7 3
10 7 12 5 8 14 20
L 1 2
R 1 3
L 2 4
R 2 5
R 3 6
R 6 7
4 5
6 7
2 3
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

struct Node {
    int left, right, par;
    int id;
    Node() {
        left = right = par = -1;
    }
};

int val[N];
Node node[N];

int find(int u, int v) {
    vector<int> pu, pv;
    while (u != -1) {
        pu.push_back(u); u = node[u].par;
    }
    while (v != -1) {
        pv.push_back(v); v = node[v].par;
    }
    loop(i, 0, pu.size() - 1) {
        loop(j, 0, pv.size() - 1) {
            if (pu[i] == pv[j]) return pu[i];
        }
    }
    assert(false);
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, q; cin >> n >> q;
    loop(i, 1, n) cin >> val[i];
    loop(i, 1, n) node[i].id = i;
    loop(i, 1, n - 1) {
        char c; int p, u;
        cin >> c >> p >> u;
        if (c == 'R') node[p].right = u;
        else node[p].left = u;
        node[u].par = p;
    }
    loop(i, 1, q) {
        int u, v; cin >> u >> v;
        cout << find(u, v) << endl;
    }
}
