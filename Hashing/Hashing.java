import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        //Create HashMap
        // HashMap<String,Integer> map= new HashMap<>();
        // //insert
        // map.put("India",100);
        // map.put("USA",50);
        // map.put("China",150);

        // System.out.println("HashMap: " + map);

        // //Get value for a key
        // System.out.println(map.get("India"));

        
        // //Check if key exists cotainsKey
        // if(map.containsKey("USA")){
        //     System.out.println("USA exists in the map with value: " + map.get("USA"));
        // } else {
        //     System.out.println("USA does not exist in the map.");
        // }

        // // Remove a key-value pair
        // map.remove("China");
        // System.out.println("After removing China: " + map);
        // // size of the map
        // System.out.println("Size of the map: " + map.size());
        // // clear th map 
        // map.clear();
        // // Check if the map is empty
        // if(map.isEmpty()){
        //     System.out.println("The map is empty.");
        // } else {
        //     System.out.println("The map is not empty.");
        // }



        // Looping through the map
        // TreeMap<String, Integer> map = new TreeMap<>(); 
        // map.put("India", 100);

        // map.put("USA", 50);
        // map.put("China", 150);
        // map.put("Japan", 80);
        // map.put("Germany", 120);

        // Set<String> keys=map.keySet();
        // System.out.println("map: " + map);
        // System.out.println("Keys in the map:"); 
        // for(String k: keys){
        //     System.out.println("key:"+k+"  value:"+map.get(k));
        // }

        // Majority Element
        int nums[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer, Integer> Map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(Map.containsKey(nums[i])){
                Map.put(nums[i],Map.get(nums[i])+1);
            }else{
                Map.put(nums[i], 1);
            }

             //Map.put(nums[i], Map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> keys=Map.keySet();
        for(Integer key:keys){
            if(Map.get(key)>nums.length/3){
                System.out.println("Majority Element: " + key + " with count: " + Map.get(key));
            }
        }
    }
    
}
