/*input
3
3 1 5
2 8 6
7 9 4
4
R 1
C 3
C 2
R 3
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
const int N = 505;
const int INF = 2e9;

struct Data {
    int val, x, y;
};

bool operator < (Data A, Data B) {
    return A.val < B.val;
}

int n, q;
int a[N][N];
bool del[N][N];
priority_queue<Data> pqRow[N], pqCol[N];

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n;
    loop(i, 0, n - 1)loop(j, 0, n - 1) {
        cin >> a[i][j];
        pqRow[i].push({a[i][j], i, j});
        pqCol[j].push({a[i][j], i, j});
    }
    cin >> q;
    loop(Q, 1, q) {
        char c; int x; cin >> c >> x;
        x--;
        int val = INF;
        while ((!pqCol[x].empty() && c == 'C') || (!pqRow[x].empty() && c == 'R')) {
            Data top;
            if (c == 'R') {
                top = pqRow[x].top(); pqRow[x].pop();
            }
            else {
                top = pqCol[x].top(); pqCol[x].pop();
            }
            if (del[top.x][top.y]) continue;
            val = top.val; del[top.x][top.y] = true; break;
        }
        if (val == INF) cout << "None" << endl;
        else cout << val << endl;
    }
}
