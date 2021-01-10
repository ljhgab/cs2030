/*input
7
1 5
1 8
2
1 20
2
1 17
2
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

priority_queue<int, vector<int>, greater<int> > minPQ;
priority_queue<int> maxPQ;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int q; cin >> q;
    while (q--) {
        int type; cin >> type;
        if (type == 1) {
            int x; cin >> x;
            if (!minPQ.empty() && minPQ.top() < x) {
                maxPQ.push(minPQ.top()); minPQ.pop();
                minPQ.push(x);
            }
            else maxPQ.push(x);
        }
        else {
            if (maxPQ.empty()) {
                cout << "None" << endl;
                continue;
            }
            if ((maxPQ.size() + minPQ.size()) % 2 == 1) cout << maxPQ.top() << endl;
            else cout << maxPQ.top() << sp << minPQ.top() << endl;
        }
        if (maxPQ.size() - minPQ.size() >= 2) {
            minPQ.push(maxPQ.top()); maxPQ.pop();
        }
    }
}
