/*
problem: https://www.geeksforgeeks.org/problems/black-and-white-1587115620/1
author: parag kumar goyal
TC: O(1)

The problem asks for the number of ways to place a black knight and a white knight on an n*m
chessboard such that they cannot attack each other
Total Valid Ways = Total Unrestricted Ways - Conflicting (Attacking Ways)

Total Unrestricted Ways
There are n*m total squares.
The first knight can be placed on any of the n*m squares
The second knight can be placed on remaining n*m-1 squares
Total unrestricted ways = (n*m) * (n*m-1)

Conflicting Ways
A knight attacks another knight using an "L shaped" move. An attack pair can be framed 
as the two opposite corners of either a 3*2 rectangle grid or 2*3 rectangle.

1. For 3*2 subgrid (3 rows, 2 columns)
There are exactly 2 attacking pairs (diagonally opposite L moves)
The number of ways to place such a sub-grid on an n*m board is (n-2)*(m-1)
Since each subgrid contains 2 attacking pairs, and the knights are distinct 
there are 2*2 = 4 attacking configurations
Total = Math.max(0, (n-2) * (m-1)) * 4 


2. Within a 2*3 subgrid 
Similarly there are 2 attacking pairs
The number of ways to place this subgrid is (n-1)*(m-2)
Same here also 2 distinct knights give 4 configurations
Total = Math.max(0, (n-1) * (m-2)) * 4


Flaw: Integer Overflow
If n = 10^5 and m = 10^5, then n * m = 10^10
The total ways would be roughly (10^10) * (10^10) ~ 10^20
A standard 32 bit int can only hold up to 2*10^9. Even a 64 bit long (up to 9*10^18)
will overflow if the problem asks for the result modulo 10^9 + 7 at the end

*/

class Solution {
    public int numOfWays(int n, int m) {
        long mod = 1000000007;
        long N = n; 
        long M = m;

        // Calculate total combinations safely with modulo
        long totalSquares = (N * M) % mod;
        long totalWays = (totalSquares * ((N * M - 1) % mod)) % mod;


        // Calculate conflicting combinations safely with modulo
        long Type1Rectangles = Math.max(0L, (N-2) * (M-1)) % mod;
        long Type2Rectangles = Math.max(0L, (N-1) * (M-2)) % mod;
        long conflictingWays = ((Type1Rectangles + Type2Rectangles) % mod * 4)  % mod; 

        // Add mod 
        return (totalWays - conflictingWays + mod) % mod;  

    }
]


