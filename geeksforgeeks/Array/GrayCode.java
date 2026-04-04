/*
problem: https://www.geeksforgeeks.org/problems/gray-code-1611215248/1
author: parag kumar goyal
TC: O(n*2^n)
SC: O(n*2^n)
*/


public List<String> graycode(int n) {
    if (n == 0) return new ArrayList<>(List.of("")); 
    if (n == 1) return new ArrayList<>(List.of("0", "1"));

    List<String> prev = graycode(n - 1);
    List<String> ans  = new ArrayList<>(2 * prev.size());

    for (String s : prev) {
        ans.add("0" + s);
    }
    for (int i = prev.size() - 1; i >= 0; --i) {
        ans.add("1" + prev.get(i));
    }
    return ans;
}