int iter = 0;
    int ans = 0;
    while (iter < a.size()) {
        int nxtIter = iter + 1;
        while (nxtIter < a.size() && a[nxtIter] == a[iter]) {
            nxtIter++;
        }
        int len = (nxtIter - iter);
        ans += len * (len - 1) / 2;
        iter = nxtIter;
    }
    cout << ans << endl;