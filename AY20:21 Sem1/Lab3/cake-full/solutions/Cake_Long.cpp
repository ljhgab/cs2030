/*input
4
4 5 4 2
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

int n, a[N], l[N], r[N];
int ans = 0;
int lpos, rpos;

signed main() {
    ios_base::sync_with_stdio(false);
    cin >> n;
    lpos = 1; rpos = n;
    loop(i, 1, n) {
        cin >> a[i];
        l[i] = r[i] = i;
    }
    loop(i, 1, n) {
        while (a[l[i] - 1] >= a[i])
            l[i] = l[l[i] - 1];
    }

    rloop(i, n, 1) {
        while (a[r[i] + 1] >= a[i])
            r[i] = r[r[i] + 1];
    }

    loop(i, 1, n)
        ans = max(ans, (r[i] - l[i] + 1) * a[i]);

    cout << ans << endl;
}
