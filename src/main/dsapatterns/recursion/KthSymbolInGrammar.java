package main.dsapatterns.recursion;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int result = calculateKthSymbolInGrammar(n, k);
    }
    public  static int calculateKthSymbolInGrammar(int n, int k) {
            if(n == 1) return 0;

            int half = 1 << ( n - 2);

            if(k <  half) return calculateKthSymbolInGrammar(n - 1, k);

            return 1 - calculateKthSymbolInGrammar(n - 1, k - half);
    }
}
