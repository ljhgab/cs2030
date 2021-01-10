/*input
3
pulalaup 2
madame 2
daevobvecd 1
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
string s;

bool isKPalin(int l, int r, int k) {
    if (l >= r) return true;
    if (s[l] == s[r] && isKPalin(l + 1, r - 1, k)) return true;
    if (k >= 1 && isKPalin(l + 1, r, k - 1)) return true;
    if (k >= 1 && isKPalin(l, r - 1, k - 1)) return true;
    return false;
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int T; cin >> T;
    while (T--) {
        int k;
        cin >> s >> k;
        if (isKPalin(0, s.size() - 1, k)) cout << "YES";
        else cout << "NO";
        cout << endl;
    }
}
