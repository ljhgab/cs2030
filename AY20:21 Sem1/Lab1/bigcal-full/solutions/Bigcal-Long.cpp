/*input
6942214966785782193371498
+
-4577886852159258368196616
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

string toStr(long long X) { // improve this
    string ret; while (X) {
        ret += char(X % 10 + '0');
        X /= 10;
    }
    reverse(ret.begin(), ret.end());
    return ret;
}

void sameSize(string &a, string &b) {
    if (a.size() < b.size()) a = string(b.size() - a.size(), '0') + a;
    if (a.size() > b.size()) b = string(a.size() - b.size(), '0') + b;
}

string preout(string &a, int carry, bool neg) {
    if (carry) a += char(carry + '0');
    while (a.size() > 1 && a.back() == '0') a.pop_back();
    if (neg) a += '-'; reverse(a.begin(), a.end());
    return a;
}

string _add(string a, string b) {
    sameSize(a, b); // IMP: don't need same size, can for directly
    string ans; int carry = 0, rem;
    rloop(i, a.size() - 1, 0) {
        rem = a[i] - '0' + b[i] - '0' + carry;
        ans += char(rem % 10 + '0');
        carry = rem / 10;
    }
    return preout(ans, carry, 0);;
}

// IMP: reduce number of copy
string _sub(string a, string b) {
    sameSize(a, b); // IMP: don't need same size, can for directly
    bool neg = 0;
    if (a < b) swap(a, b), neg = 1;
    string ans; int rem, carry = 0;
    rloop(i, a.size() - 1, 0) {
        rem = a[i] - b[i] - carry;
        carry = 0;
        while (rem < 0) ++carry, rem += 10;
        ans += char(rem + '0');
    }
    return preout(ans, 0, neg);
}

string mul(string a, string b) {
    bool neg = 0;
    if (a[0] == '-') a.erase(0, 1), neg ^= 1;
    if (b[0] == '-') b.erase(0, 1), neg ^= 1;
    string ans = ""; int carry = 0, rem;
    rloop(sum, a.size() + b.size() - 2, 0) {
        int sav = 0;
        rloop(i, min(sum, (int)a.size() - 1), 0) {
            int j = sum - i; if (j >= b.size()) break;
            sav += (a[i] - '0') * (b[j] - '0');
        }
        rem = sav + carry; carry = rem / 10;
        ans += char(rem % 10 + '0');
    }
    return preout(ans, carry, neg);
}

string sub(const string &a, const string &b) {
    string ret;
    if (a[0] == '-' && b[0] == '-') ret = "-" + _sub(a.substr(1, a.size() - 1), b.substr(1, b.size() - 1));
    else if (a[0] == '-') ret = "-" + _add(a.substr(1, a.size() - 1), b);
    else if (b[0] == '-') return _add(a, b.substr(1, b.size() - 1));
    else return _sub(a, b);
    if (ret[1] == '-') ret.erase(0, 2);
    return ret;
}

string add(const string &a, const string &b) {
    if (a[0] == '-') return sub(b, a.substr(1, a.size() - 1));
    if (b[0] == '-') return sub(a, b.substr(1, b.size() - 1));
    return _add(a, b);
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    string a, b;
    cin >> a >> b;
    cout << add(a, b) << endl;
}
