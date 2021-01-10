/*input
5 3
1 3 18 25 26
3 2 8
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

int n, m;
stack<int> st;
vector<int> a;
signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m;
    loop(i, 1, n) {
        int t; cin >> t; a.push_back(t);
    }
    rloop(i, a.size() - 1, 0) {
        st.push(a[i]);
    }
    loop(i, 1, m) {
        int t; cin >> t;
        while (!st.empty() && st.top() < t) {
            t += st.top(); st.pop();
        }
        st.push(t);
    }
    while (!st.empty()) {
        cout << st.top() << sp;
        st.pop();
    }
    cout << endl;
}
