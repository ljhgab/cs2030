#include <bits/stdc++.h>
using namespace std;

vector<int> a;

int countswaps() {
    int count = 0, n = a.size();
    bool sorted = false;
    
    int i = 0;
    while(i < n && !sorted) {
        sorted = true;
        for (int j = 0; j < n - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                swap(a[j], a[j + 1]);
                sorted = false;
                count++;
            }
        }
        i++;
    }
    return count;
}

signed main() {
    int n; cin >> n;

    for (int i = 0; i < n; i++) {
        int this_int; cin >> this_int;
        a.push_back(this_int);
    }
    cout << countswaps() << endl;
}
