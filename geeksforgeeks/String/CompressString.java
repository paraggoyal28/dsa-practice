/*
problem: geeksforgeeks.org/problems/easy-string2212/1
author: parag kumar goyal
TC: O(n)
*/

public class CompressString {
    
    public String compressString(String originalStr) {
        StringBuilder compressedStr = new StringBuilder();

        int count = 1;

        for (int i = 1, n = originalStr.length(); i <= n; ++i) {
            if (i < n && 
                Character.toLowerCase(originalStr.charAt(i-1)) == 
                    Character.toLowerCase(originalStr.charAt(i))) {
                count++;
            } else {
                compressedStr.append(Character.toLowerCase(originalStr.charAt(i-1)))
                    .append(count);
                count = 1;
            }
        }

        return compressedStr.toString();
    }

}
