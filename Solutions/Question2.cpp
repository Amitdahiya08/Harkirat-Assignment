#include<bits/stdc++.h>
using namespace std;
int completeCyclePairs(int k, vector<int>& distances) {
    unordered_map<int, int> remainder_count;
    int count = 0;
    
    for (int distance : distances) {
        int remainder = distance % k;
        int complement = (k - remainder) % k;
        
        if (remainder_count.find(complement) != remainder_count.end()) {
            count += remainder_count[complement];
        }
        
        remainder_count[remainder]++;
    }
    
    return count;
}

int main() {
    vector<int> distances1 = {2, 8, 5, 5, 4, 6};
    int k1 = 10;
    cout << completeCyclePairs(k1, distances1) << std::endl; // Output: 3
    
    vector<int> distances2 = {3, 6, 9, 4};
    int k2 = 12;
    cout << completeCyclePairs(k2, distances2) << std::endl; // Output: 1
    
    vector<int> distances3 = {2, 4, 6, 8, 1, 3, 5};
    int k3 = 8;
    cout << completeCyclePairs(k3, distances3) << std::endl; // Output: 2
    
    return 0;
}
