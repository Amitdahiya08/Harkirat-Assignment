#include <iostream>
#include <vector>
#include <string>
#include <climits>

using namespace std;

string getMaxScoreString(vector<string>& arr) {
    string maxScoreString="";
    int maxScore = INT_MIN;
    for (const string& s : arr) {
        int score = 0;
        vector<int>index(26,0);
        for (int i = 0; i < s.length(); i++) {
            if(index[s[i]-'a']==0)index[s[i]-'a']=i+1;
            score += (s[i]-'a') * index[s[i]-'a'] ;
        }
        if (score > maxScore || (score == maxScore && s < maxScoreString)) {
            maxScore = score;
            maxScoreString = s;
        }
    }

    return maxScoreString;
}

int main() {
    vector<string> arr = {"abc", "bcd", "a"};
    cout << getMaxScoreString(arr) << endl;  // Output: bcd
    return 0;
}
