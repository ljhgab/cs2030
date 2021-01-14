#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k; cin >> n >> k;
    int numbers[n];
    queue<int> window;

    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }
    for (int i = 0; i < k - 1; i++) {
        if (numbers[i] % 2 == 1) {
            window.push(i);
        }
    }
    for (int i = k - 1; i < n; i++) {
        if (!window.empty() && i - window.front() + 1 > k) {
            window.pop();
        }
        if (numbers[i] % 2 == 1) {
            window.push(i);
        }
        if (window.empty()) {
            cout << -1 << " ";
        } else {
            cout << window.front() + 1 << " ";
        }
    }    
    cout << endl;
}