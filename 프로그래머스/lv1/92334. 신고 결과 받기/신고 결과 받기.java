import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length];
        HashMap<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        int idx=0;
        for(String name : id_list){
            Set<String> set = new HashSet<>();
            map.put(name, set);
            index.put(name, idx++);
        }
        
        for(String str: report){
            StringTokenizer st = new StringTokenizer(str);
            String from = st.nextToken();
            String to = st.nextToken();
            Set<String> set = map.get(to);
            set.add(from);
            map.put(to, set);
        }
        
        for(String name: id_list){
            Set<String> tmp = map.get(name);
            if(tmp.size()>=k){
                for(String from: tmp){
                    answer[index.get(from)]++;
                }
            }
        }
        return answer;
    }
}