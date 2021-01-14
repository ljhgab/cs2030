/*input
7
1 1 2 2 3 6
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

struct Node {
    Node* left;
    Node* right;
    Node() {
        left = right = NULL;
    }
};



int ans = 0;

int solve(Node* u) {
    if (u == NULL) return 0;
    int le = solve(u->left); int ri = solve(u->right);
    ans = max(ans, le + ri);
    return max(le, ri) + 1;
}

Node node[1005];
signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    loop(i, 2, n) {
        int p; cin >> p;
        if (node[p].left == NULL) node[p].left = &node[i];
        else node[p].right = &node[i];
    }
    solve(&node[1]);
    cout << ans << endl;
}
