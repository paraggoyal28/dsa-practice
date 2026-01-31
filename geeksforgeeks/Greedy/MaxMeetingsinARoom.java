/*
problem: https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
author: parag kumar goyal
TC: O(NlogN)
SC: O(N)
*/

class Meeting {
    int start;
    int end;
    int id;

    Meeting (int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;  
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        List<Meeting> meetings = new ArrayList<>();

        // 1. Map raw arrays to a list of Meeting objects
        for (int i = 0; i < n; ++i) {
            meetings.add(new Meeting(S[i], F[i], i));
        }

        // 2. Sort by end time. If end times are equal,
        // sort by original ID
        // This handles the tie-breaking logic
        meetings.sort(Comparator.comparingInt((Meeting m) -> m.end)
                        .thenComparingInt(m -> m.id));

        ArrayList<Integer> selectedMeetingIds = new ArrayList<>();

        //3. Greedy selection
        int currentTimeLimit = -1;
        for (Meeting m: meetings) {
            if (m.start > currentTimeLimit) {
                selectedMeetingIds.add(m.id);
                currentTimeLimit = m.end;
            }
        }

        //4. Sort the IDs as required 
        Collections.sort(selectedMeetingIds);

        return selectedMeetingIds;
    }
}