import java.util.*;

public class Hashing {
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map= new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }else{
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        return map.isEmpty();
    }
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
        // int nums[]={1,3,2,5,1,3,1,5,1};
        // HashMap<Integer, Integer> Map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(Map.containsKey(nums[i])){
        //         Map.put(nums[i],Map.get(nums[i])+1);
        //     }else{
        //         Map.put(nums[i], 1);
        //     }

        //      //Map.put(nums[i], Map.getOrDefault(nums[i], 0) + 1);
        // }

        // Set<Integer> keys=Map.keySet();
        // for(Integer key:keys){
        //     if(Map.get(key)>nums.length/3){
        //         System.out.println("Majority Element: " + key + " with count: " + Map.get(key));
        //     }
        // }

    //     String s = "care";
    //     String t = "rate";
    //     if(isAnagram(s, t)){
    //         System.out.println(s + " and " + t + " are anagrams.");
    //     } else {
    //         System.out.println(s + " and " + t + " are not anagrams.");
    //     }
         //Iterating through a HashSet
        //  HashSet<String> set = new HashSet<>();
        //     set.add("apple");
        //     set.add("banana");
        //     set.add("cherry");
        //     set.add("date");
        //     set.add("apple"); // Duplicate, will not be added
        //     System.out.println("HashSet: " + set); 
            
            // using iterator to loop through the HashSet
            // Iterator<String> it= set.iterator();
            // System.out.println("Iterating through HashSet:");
            // while(it.hasNext()){
            //     System.out.println(it.next());
            // }
            // using for-each loop to loop through the HashSet
            // for(String c:set){
            //     System.out.println( c);
            // }

            int[] arr1={7,3,9};
            int[] arr2={7,3,9,6,2,4};
            HashSet<Integer> set1 = new HashSet<>();

            for(int i=0;i<arr1.length;i++){
                set1.add(arr1[i]);
            }
            for(int i=0;i<arr2.length;i++){
                set1.add(arr2[i]);
            }

            System.out.println("Union of two arrays: " + set1);
            System.out.println("Size of union: " + set1.size());

            set1.clear();
            for(int i=0;i<arr1.length;i++){
                set1.add(arr1[i]);
            }
          int count=0;
            for(int i=0;i<arr2.length;i++){
                if(set1.contains(arr2[i])){
                    count++;
                    set1.remove(arr2[i]);
                }
            }
            System.out.println("Intersection of two arrays: " + (count > 0 ? count : "No intersection found"));
            System.out.println("Size of intersection: " + count);

    }
    
}
