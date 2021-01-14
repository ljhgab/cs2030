#include <bits/stdc++.h>
using namespace std;

signed int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, T; cin >> n >> T;
    vector<int> a;
    int ans = 0;

    for (int i = 0; i < n; i++) {
        int t; cin >> t;
        a.push_back(t);
    }
    sort(a.begin(), a.end());
    int y = n;
    for (int x = 1; x < n; x++) {
        while (y > 0 && a[x] + a[y] > T) {
            y--;
        }
        ans += min(y, x - 1);
    }
    cout << ans << endl;
}