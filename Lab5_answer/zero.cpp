#include <bits/stdc++.h>
using namespace std;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);

    int n; cin >> n;
    int ans = 0;
    int cursum = 0;
    vector<int> cumsum;

    cumsum.push_back(cursum);
    for (int i = 0; i < n; i++) {
        int t; cin >> t;
        cursum += t;
        cumsum.push_back(cursum);
    }
    sort(cumsum.begin(), cumsum.end());
    int i = 0;
    
    while (i < cumsum.size()) {
        int j = i + 1;
        while (j < cumsum.size() && cumsum[i] == cumsum[j]) {
            j++;
        }
        int k = j - i;
        ans += k * (k - 1) / 2;
        i = j;
    }
    cout << ans << "\n";
}