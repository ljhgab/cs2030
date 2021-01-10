#include <bits/stdc++.h>
using namespace std;

class Movie {
    public:
    int _start;
    int _end;
    int _score;

    Movie(int start, int end, int score);
    bool intersect(Movie other);
};

Movie::Movie(int start, int end, int score) {
    _start = start;
    _end = end;
    _score = score;
}

bool Movie::intersect(Movie other) {
    if (this->_end <= other._start || other._end <= this->_start) {
        return false;
    }
    return true;
}

vector<Movie> movies;
int n, m;
int ans = 0;

void backtrack(int pos, bool chosen[], int taken, int sum) {
    if (pos == n) {
        ans = max(ans, sum);
        return;
    }

    chosen[pos] = false;
    backtrack(pos + 1, chosen, taken, sum);
    
    if (taken < m) {
        for (int i = 0; i < pos; i++) {
            if (chosen[i] && movies[pos].intersect(movies[i])) {
                return;
            }
        }
        chosen[pos] = true;
        backtrack(pos + 1, chosen, taken + 1, sum + movies[pos]._score);
    }
}

int main() {
    cin >> n >> m;
    bool chosen[n];

    for (int i = 0; i < n; i++) {
        int start, end, score; cin >> start >> end >> score;
        Movie* this_movie = new Movie(start, end, score);
        movies.push_back(*this_movie);
    }
    backtrack(0, chosen, 0, 0);
    cout << ans << endl;
}