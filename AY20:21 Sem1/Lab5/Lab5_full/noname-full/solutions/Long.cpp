/*input
4 8
3 1 5 7
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

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, T; cin >> n >> T;
    vector<int> a;
    loop(i, 1, n) {
        int t; cin >> t; a.push_back(t);
    }
    sort(a.begin(), a.end());
    int iter = a.size() - 1;
    int ans = 0;
    loop(i, 0, a.size() - 1) {
        while (iter >= 0 && a[i] + a[iter] > T) iter--;
        ans += (iter + 1);
        if (iter >= i) ans -= 1;
    }
    cout << ans / 2 << endl;
}
