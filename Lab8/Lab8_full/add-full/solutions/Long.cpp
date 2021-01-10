/*input
6
1 5
1 8
2 3
1 7
3
3
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

int q, sumAdded = 0;
priority_queue<int, vector<int>, greater<int> > pq;
signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> q;
    while (q--) {
        int type; cin >> type;
        if (type == 1) {
            int x; cin >> x;
            x -= sumAdded;
            pq.push(x);
        }
        else if (type == 2) {
            int x; cin >> x;
            sumAdded += x;
        }
        else {
            if (pq.empty()) {
                cout << "None" << endl;
            }
            else {
                int u = pq.top(); pq.pop();
                cout << u + sumAdded << endl;
            }
        }
    }
}
