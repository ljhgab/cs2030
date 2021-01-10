#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    int id;
    int val;
    Node* left;
    Node* right;

    Node(int index, int value);
};

Node::Node(int index, int value) {
    id = index;
    val = value;
    left = right = NULL;
}

vector<int> a;

void insert(Node* root, char direction, int index, int child_index) {
    if (root->id == index) {
        if (direction == 'L') {
            root->left = new Node(child_index, a[child_index - 1]);
        } else {
            root->right = new Node(child_index, a[child_index - 1]);
        }
        return;
    } else {
        int value = a[index - 1];
        if (value < a[root->id - 1]) {
            insert(root->left, direction, index, child_index);
        } else {
            insert(root->right, direction, index, child_index);
        }
    }
}

int solve(Node* root, int uval, int vval) {
    if (root->val > vval) {
        return solve(root->left, uval, vval);
    } else if (root->val < uval) {
        return solve(root->right, uval, vval);
    } else if (root->val == uval || root->val == vval) {
        return root->id;
    } else {
        return root->id;
    }
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, q; cin >> n >> q;
    for (int i = 0; i < n; i++) {
        int t; cin >> t;
        a.push_back(t);
    }
    Node* root = new Node(1, a[0]);
    for (int i = 2; i <= n; i++) {
        char direction; int p, u;
        cin >> direction >> p >> u;
        insert(root, direction, p, u);
    }
    for (int i = 0; i < q; i++) {
        int u, v; cin >> u >> v;
        int uval, vval;
        uval = a[u - 1];
        vval = a[v - 1];
        cout << solve(root, uval, vval) << endl;
    }
}