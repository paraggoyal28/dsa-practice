/*
problem: https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
author: parag kumar goyal
TC: O(logn)
SC: O(1)
*/

public long countStrings(int n) {
    if (n == 0) return 0;
    if (n == 1) return 2;
    
    long[][] T = {{1, 1}, {1, 0}};
    long[][] result = power(T, n + 1); // We need the (n+2)th Fibonacci
    
    // The answer is result[0][0] (which corresponds to Fib(n+2))
    return result[0][0];
}

// Function to multiply two 2x2 matrices
long[][] multiply(long[][] A, long[][] B) {
    long[][] C = new long[2][2];
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 2; j++)
            for (int k = 0; k < 2; k++)
                C[i][j] += A[i][k] * B[k][j];
    return C;
}

// Matrix Exponentiation in O(log n)
long[][] power(long[][] A, int p) {
    long[][] res = {{1, 0}, {0, 1}};
    while (p > 0) {
        if (p % 2 == 1) res = multiply(res, A);
        A = multiply(A, A);
        p /= 2;
    }
    return res;
}

/*
TC: O(n)
SC: O(1)
*/

public long countStrings(int n) {
    if (n == 0) return 0;
    if (n == 1) return 2;
    
    int a = 1;
    int b = 2;
    for (int i = 2; i <= n; ++i) {
        int c = a + b;
        a = b;
        b = c; 
    }
    return b;
}