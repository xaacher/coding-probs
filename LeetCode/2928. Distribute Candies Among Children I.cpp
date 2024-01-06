class Solution {
public:
    int distributeCandies(int n, int limit) {
        // 0, 1, 2, 3
        int count = 0;
        for(int i = 0; i <= limit; i ++) {
            for(int j = 0; j <= limit; j ++) {
                for(int k = 0; k <= limit; k ++) {
                if(i + j + k == n) {
                    count ++;
                }
            }
            }
        }

        return count;

        // n= 3, limit = 3
        //(0, 0, 3)
        // (0, 1, 2)
        // (0, 2, 1)
        // (0, 3, 0)
        // (1, 0, 2), (1, 1, 1), (1, 2, 0), (2, 0, 1), (2, 1, 0) and (3, 0, 0)
    }
};
