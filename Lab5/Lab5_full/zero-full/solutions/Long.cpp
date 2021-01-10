/*input
5
1 -1 1 -1 1
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

int n;
vector<int> a;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n;
    int curSum = 0;
    a.push_back(curSum);
    loop(i, 1, n) {
        int t; cin >> t;
        curSum += t;
        a.push_back(curSum);
    }
    sort(a.begin(), a.end());
    int iter = 0;
    int ans = 0;
    while (iter < a.size()) {
        int nxtIter = iter + 1;
        while (nxtIter < a.size() && a[nxtIter] == a[iter]) {
            nxtIter++;
        }
        int len = (nxtIter - iter);
        ans += len * (len - 1) / 2;
        iter = nxtIter;
    }
    cout << ans << endl;
}
