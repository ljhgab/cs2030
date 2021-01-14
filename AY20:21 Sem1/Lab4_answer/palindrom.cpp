#include <bits/stdc++.h>
using namespace std;

bool qualified(string s, int k, int left, int right) {
    if (left >= right) {
        return (k >= 0) ? true : false;
    } else if (s[left] == s[right]) {
        return qualified(s, k, left + 1, right - 1);
    } else {
        return qualified(s, k - 1, left + 1, right) || qualified(s, k - 1, left, right - 1);
    }

}

signed main() {
    vector<string> output;
    int T; cin >> T;

    for (int i = 0; i < T; i++) {
        string S; cin >> S;
        int K; cin >> K;
        string this_result = qualified(S, K, 0, S.length() - 1) ? "YES" : "NO";
        output.push_back(this_result);
    }
    for (string this_result : output) {
        cout << this_result << endl;
    }
}