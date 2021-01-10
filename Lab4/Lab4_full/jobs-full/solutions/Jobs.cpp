/*input
5
1 2 4 1 3
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

vector<int> a;
int n;
int ans = numeric_limits<int>::max() / 2;

void backtrack(int pos, int w1, int w2, int w3) {
    if (pos == a.size()) {
        ans = min(ans, max(w1, max(w2, w3)));
        return;
    }
    backtrack(pos + 1, w1 + a[pos], w2, w3);
    backtrack(pos + 1, w1, w2 + a[pos], w3);
    backtrack(pos + 1, w1, w2, w3 + a[pos]);
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n;
    loop(i, 1, n) {
        int t; cin >> t; a.push_back(t);
    }
    backtrack(0, 0, 0, 0);
    cout << ans << endl;
}
