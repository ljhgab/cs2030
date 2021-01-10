#include <bits/stdc++.h>
using namespace std;

class Fish {
    public:
    int _size;
    bool _hungry;

    Fish(int size, bool hungry);
    bool is_hungry();
    void eat(Fish other);
    friend ostream& operator<<(ostream& os, const Fish& f);
};

Fish::Fish(int size, bool hungry) {
    _size = size;
    _hungry = hungry;
}

bool Fish::is_hungry() {
    return _hungry;
}

void Fish::eat(Fish other) {
    _size += other._size;
}

ostream& operator<<(ostream& os, const Fish& f) {
    os << f._size;
    return os;
}

int main() {
    int n, m; cin >> n >> m;
    stack<Fish> fishes;
    stack<Fish> pool;

    for (int i = 0; i < n; i++) {
        int this_size; cin >> this_size;
        Fish* this_fish = new Fish(this_size, false);
        fishes.push(*this_fish);
    }
    for (int i = 0; i < n; i++) {
        Fish this_fish = fishes.top();
        pool.push(this_fish);
        fishes.pop();
    }
    //The hungry fishes are coming
    for (int j = 0; j < m; j++) {
        int this_size; cin >> this_size;
        Fish* hungry_fish = new Fish(this_size, true);
        while (!pool.empty() && hungry_fish->_size > pool.top()._size) {
            Fish poor_fish = pool.top();
            pool.pop();
            hungry_fish->eat(poor_fish);
        }
        hungry_fish->_hungry = false;
        pool.push(*hungry_fish);
    }
    while (!pool.empty()) {
        cout << pool.top() << " ";
        pool.pop();
    }
    cout << endl;
}