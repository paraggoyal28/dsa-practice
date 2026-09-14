/*
problem: https://www.geeksforgeeks.org/dsa/c-program-for-tower-of-hanoi/ 
author: parag kumar goyal
TC: O(2^n) 
SC: O(n)
*/

class GFG {
    public void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Disk " + n + " moved from " + fromRod + " to " + toRod);
        towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }

    public static void main(String args[]){
        int n = 9;
        
        // A, B and C are names of rods
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}
// Total Operations - 2^n-1

