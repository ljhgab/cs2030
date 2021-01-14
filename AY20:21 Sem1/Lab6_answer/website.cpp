#include <bits/stdc++.h>
using namespace std;

signed main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int q; cin >> q;
    map<string, set<string> > unique_ip;
    set<string> unique_country;
    map<string, int> ip_max_duration;
    map<string, int> country_max_duration;
    for (int i = 0; i < q; i++) {
        int index; cin >> index;
        if (index == 1) {
            string ip, country; int duration;
            cin >> ip >> country >> duration;
            if (unique_country.find(country) == unique_country.cend()) {
                unique_country.insert(country);
            }
            unique_ip[country].insert(ip);
            ip_max_duration[ip] += duration;
            country_max_duration[country] = max(country_max_duration[country], ip_max_duration[ip]);
        } else if (index == 2) {
            string country; cin >> country;
            cout << country_max_duration[country] << endl;
        } else if (index == 3) {
            cout << unique_country.size() << endl;
        } else if (index == 4) {
            string country; cin >> country;
            if (unique_ip.find(country) == unique_ip.end()) {
                cout << 0 << endl;
            } else {
                cout << unique_ip[country].size() << endl;
            }
        }
    }
}