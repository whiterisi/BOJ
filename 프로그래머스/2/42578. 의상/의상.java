import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int result = 1;
        HashMap<String,Integer> kind = new HashMap<>();
        for(String [] arr : clothes){
            kind.put(arr[1],kind.getOrDefault(arr[1],0)+1);          
        }
        Collection<Integer> values = kind.values();        
        Integer[] arr = values.toArray(new Integer[0]);
        
        for(Integer i : arr){
            result*=(i+1);
        }
        
        return result-1;
    }
}