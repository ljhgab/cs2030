#include <bits/stdc++.h>
using namespace std;

int main() {
    int len; cin >> len;
    vector<int> columns;

    for (int i = 0; i < len; i++) {
        int this_col; cin >> this_col;
        columns.push_back(this_col);
    }
    columns.push_back(0);
    
    stack<int> pstack, hstack;
    int max_area = 0;
    for (int i = 0; i < len + 1; i++) {
        int last_position = numeric_limits<int>::max();

        while (!hstack.empty() && hstack.top() > columns[i]) {
            last_position = pstack.top();
            max_area = max(max_area, (i - pstack.top()) * hstack.top());
            pstack.pop();
            hstack.pop();
        }
        if (hstack.empty() || hstack.top() < columns[i]) {
            hstack.push(columns[i]);
            pstack.push(min(last_position, i));
        }
    }
    cout << max_area << endl;
}