#include <bits/stdc++.h>
using namespace std;

vector<int> jobs;

int backtrack(int index, int w1, int w2, int w3) {
    if (index == jobs.size()) {
        return max(w1, max(w2, w3));
    }
    return min(backtrack(index + 1, w1 + jobs[index], w2, w3),
        min(backtrack(index + 1, w1, w2 + jobs[index], w3), backtrack(index + 1, w1, w2, w3 + jobs[index])));
}

int main() {
    int n; cin >> n;

    for (int i = 0; i < n; i++) {
        int job; cin >> job;
        jobs.push_back(job);
    }
    cout << backtrack(0, 0, 0, 0) << endl;
}