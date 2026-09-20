package InterviewPrep.Day3;

import java.util.*;
public class RemoveDuplicates {
    

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1000, 1000, 2, 2, 30000, 3, 3, 4);
        
        List<Integer> withoutDuplicates = new ArrayList<>();

        for (int i = 0, n = list.size(); i < n; ++i) {
            if (!withoutDuplicates.contains(list.get(i))) {
                withoutDuplicates.add(list.get(i));
            }
        }

        System.out.println(withoutDuplicates);

        Set<Integer> uniqueNumbers = new LinkedHashSet<>(list);
        
        List<Integer> uniqueList = new ArrayList<>(uniqueNumbers);

        System.out.println(uniqueList);
    }
}
