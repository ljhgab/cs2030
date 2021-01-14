#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
    int _val;
    int _height;
    Node* _left;
    Node* _right;

    Node(int value);
};

Node::Node(int value) {
    _val = value;
    _height = 0;
    _left = NULL;
    _right = NULL;
}
/*
int diameter(Node* root) {
    int this_d = 0;
    if (root->_left != NULL) {
        this_d = max(this_d, diameter(root->_left));
        root->_height = max(root->_height, root->_left->_height + 1);
    }
    if (root->_right != NULL) {
        this_d = max(this_d, diameter(root->_right));
        root->_height = max(root->_height, root->_right->_height + 1);
    }
    this_d = max(this_d, root->_height);
    if (root->_left && root->_right) {
        this_d = max(this_d, root->_left->_height + root->_right->_height + 2);
    }
    return this_d;
}
*/

int diameter(Node* root) {
    int this_d = 0;
    int leftd, rightd; leftd = rightd = 0;
    if (root->_left != NULL) {
        leftd = diameter(root->_left);
        root->_height = max(root->_height, root->_left->_height + 1);
    }
    if (root->_right != NULL) {
        rightd = diameter(root->_right);
        root->_height = max(root->_height, root->_right->_height + 1);
    }
    this_d = max(max(leftd, rightd), root->_height);
    if (root->_left && root->_right) {
        this_d = max(this_d, root->_left->_height + root->_right->_height + 2);
    }
    return this_d;
}

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    Node* root = new Node(1);
    vector<Node*> tree;
    tree.push_back(root);
    for (int i = 1; i < n; i++) {
        int t; cin >> t;
        Node* this_node = new Node(i + 1);
        tree.push_back(this_node);
        if (tree[t - 1]->_left == NULL) {
            tree[t - 1]->_left = this_node;
        } else if (tree[t - 1]->_right == NULL) {
            tree[t - 1]->_right = this_node;
        }
    }

    cout << diameter(root) << endl;
}