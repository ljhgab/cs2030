/*input
5 2
ababa
baaa
abaaa
abb
bab
aba
ba
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
    Node* child[2];
    int cnt;
    Node() {
        child[0] = child[1] = NULL; cnt = 0;
    }
} *root = new Node();

void add(string s) {
    Node* cur = root;
    for (int i = 0; i < s.size(); i++) {
        if (cur->child[s[i] - 'a'] == NULL) cur->child[s[i] - 'a'] = new Node();
        cur = cur->child[s[i] - 'a']; cur->cnt++;
    }
}

int solve(string s) {
    Node* cur = root;
    for (int i = 0; i < s.size(); i++) {
        if (cur->child[s[i] - 'a'] == NULL) return 0;
        cur = cur->child[s[i] - 'a'];
    }
    return cur->cnt;
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, q; cin >> n >> q;
    loop(i, 1, n) {
        string s; cin >> s;
        add(s);
    }
    loop(i, 1, q) {
        string s; cin >> s;
        cout << solve(s) << endl;
    }
}
