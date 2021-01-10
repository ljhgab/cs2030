#include <bits/stdc++.h>
using namespace std;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    int result[n];
    vector<int> a;
    map<int, int> m;
    for (int i = 0; i < n; i++) {
        int t; cin >> t;
        a.push_back(t);
    }
    for (int i = 0; i < n; i++) result[i] = n + 1;
    for (int i = 0; i < n; i++) {
        if (m.find(a[i]) != m.end()) {
            result[i] = min(result[i], i - m[a[i]]);
        }
        m[a[i]] = i;
    }
    m.clear();
    for (int i = n - 1; i >= 0; i--) {
        if (m.find(a[i]) != m.end()) {
            result[i] = min(result[i], m[a[i]] - i);
        }
        m[a[i]] = i;
    }
    for (int i = 0; i < n; i++) {
        if (result[i] == n + 1) {
            cout << -1 << endl;
        } else {
            cout << result[i] << endl;
        }
    }
    
}