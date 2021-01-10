#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int count;
    Node* left;
    Node* right;

    Node();
};

Node::Node() {
        count = 1;
        left = right = NULL;
}

void insert(Node* root, string s) {
    if (s.size() == 0) {
        return;
    }
    if (s[0] == 'a') {
        if (root->left == NULL) {
            root->left = new Node();
        } else {
            root->left->count++;
        }
        insert(root->left, s.substr(1));
    } else {
        if (root->right == NULL) {
            root->right = new Node();
        } else {
            root->right->count++;
        }
        insert(root->right, s.substr(1));
    }
}

int solve(Node* root, string s) {
    if (s.size() == 0) {
        return root->count;
    } else {
        if (s[0] == 'a') {
            return solve(root->left, s.substr(1));
        } else {
            return solve(root->right, s.substr(1));
        }
    }
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, q; cin >> n >> q;
    Node* root = new Node();
    for (int i = 0; i < n; i++) {
        string s; cin >> s;
        insert(root, s);
    }
    for (int i = 0; i < q; i++) {
        string query; cin >> query;
        cout << solve(root, query) << endl;
    }
}