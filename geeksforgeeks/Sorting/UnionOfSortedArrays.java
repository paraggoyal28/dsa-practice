/*
problem: https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
author: parag kumar goyal
TC: O(NlogN + MlogM) where N and M are sizes of both arrays
SC: O(1)
*/

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        ArrayList<Integer> union = new ArrayList<>();
        
        while (i < n && j < m) {
            int current;
            if (a[i] < b[j]) {
                current = a[i++];
            } else if (b[j] < a[i]) {
                current = b[j++];
            } else {
                current = a[i++];
                j++;
            }
            
            // Only add if the list is empty or the element is new
            if (union.isEmpty() || union.get(union.size() - 1) != current) {
                union.add(current);
            }
        }
        
        while (i < n) {
            if (union.get(union.size()-1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        }
        
        while(j < m) {
            if (union.get(union.size()-1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }
        
        return union;
    }
}