class Solution {
    Map<Integer, Integer> mono = new HashMap<>();

    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int fn1 = mono.containsKey(n - 1) ? mono.get(n - 1) : fib(n - 1);
        int fn2 = mono.containsKey(n - 2) ? mono.get(n - 2) : fib(n - 2);
        int result =  fn1 + fn2;
        mono.put(n, result);
        return result;
    }
}
