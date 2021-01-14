/*input
6 2
0 1 6
0 0 7
6 7 9
5 6 5
9 10 8
1 2 6
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

struct Data {
    int l, r, val;
};

ostream &operator<<(ostream &os, Data X) {
    os << X.l << sp << X.r << sp << X.val;
    return os;
}

int n, m;
vector<Data> a, chosen;
int ans = 0;

bool isIntersect(Data A, Data B) {
    if (A.l > B.l) swap(A, B);
    if (B.l >= A.r) return false;
    return true;
}

bool checkValidSet() {
    loop(i, 0, chosen.size() - 1) {
        loop(j, i + 1, chosen.size() - 1) {
            if (isIntersect(chosen[i], chosen[j])) return false;
        }
    }
    return true;
}

void backtrack(int pos, int sum) {
    if (pos == a.size()) {
        if (!checkValidSet()) return;
        ans = max(ans, sum);
        return;
    }
    backtrack(pos + 1, sum);
    if (chosen.size() + 1 > m) return;
    chosen.push_back(a[pos]);
    backtrack(pos + 1, sum + a[pos].val);
    chosen.pop_back();

}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m;
    loop(i, 1, n) {
        int l, r, val; cin >> l >> r >> val;
        a.push_back({l, r, val});
    }
    backtrack(0, 0);
    cout << ans << endl;
}
