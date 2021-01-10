/*input
10
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 8 0
1
1 2 8 9
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
const double eps = 1e-6;
int n, q;
int a[2][N];
int linearSum[2][N];
int squaredSum[2][N];
double logSum[2][N];

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n;
    loop(k, 0, 1)loop(i, 1, n) cin >> a[k][i];
    loop(k, 0, 1) {
        loop(i, 1, n) {
            linearSum[k][i] = linearSum[k][i - 1] + a[k][i];
            squaredSum[k][i] = squaredSum[k][i - 1] + a[k][i] * a[k][i];
            logSum[k][i] = logSum[k][i - 1] + (a[k][i] == 0 ? -1 : log(a[k][i]));
        }
    }
    cin >> q;
    loop(Q, 1, q) {
        int l, r, u, v; cin >> l >> r >> u >> v;
        bool ok1 = (linearSum[0][r] - linearSum[0][l - 1] == linearSum[1][v] - linearSum[1][u - 1]);
        bool ok2 = (squaredSum[0][r] - squaredSum[0][l - 1] == squaredSum[1][v] - squaredSum[1][u - 1]);
        bool ok3 = abs((logSum[0][r] - logSum[0][l - 1]) - (logSum[1][v] - logSum[1][u - 1])) <= eps;
        if (ok1 && ok2 && ok3) cout << "Yes" << endl;
        else cout << "No" << endl;
    }
}
