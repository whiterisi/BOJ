import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        /*
        시간초과 실패 5개:  68.8점 
        ArrayList<String> list = new ArrayList<>(Arrays.asList(players));
        int idx=-1;
        for(String name: callings){
            idx = list.indexOf(name);
            list.add(idx-1, name);
            list.remove(idx+1);
        }
        return list.stream().toArray(String[]::new);
        */ 
        
        /*
        시간초과 4개 : 75점
        for(String name: callings){
             String tmp= "";
            for(int i=0; i<players.length; i++){
                if(players[i].equals(name)){
                    tmp = players[i-1];
                    players[i-1]=players[i];
                    players[i]=tmp;
                    break;
                }
            }
        }
       */
        Map<String, Integer> map  = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
        }
        
        for(String name: callings){
            int idx = map.get(name);
            String frontRunner = players[idx-1];
            
            players[idx-1]=name;
            players[idx]=frontRunner;
            
            map.put(name, idx-1);
            map.put(frontRunner, idx);
        }
        
        
        return players;
    }

}