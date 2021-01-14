#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k; cin >> n >> k;
    vector<int> numbers;
    vector<int> result;

    for (int i = 0; i < n; i++) {
        int this_num; cin >> this_num;
        numbers.push_back(this_num);
    }
    for (int i = 0; i < n - k + 1; i++) {
        bool found = false;
        for (int j = 0; j < k; j++) {
            int index = i + j;
            if (numbers[index] % 2 == 1) {
                result.push_back(index + 1);
                found = true;
                break;
            }
        }
        if (!found) { 
            result.push_back(-1);
        }
    }
    for (int ele : result) {
        cout << ele << " ";
    }
    cout << endl;
}