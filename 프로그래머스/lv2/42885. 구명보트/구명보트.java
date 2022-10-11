import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int low = 0;

         for (int high = people.length - 1; low <= high; high--){
            if (people[low] + people[high] <= limit) {
                low++;
            }
            answer++;
        }  
        return answer;
    }
}