class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> items = new ArrayList();
        int k = 0;
        for(String str: strs){
            // key 생성하기.
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = new String(strChars);

            if(map.get(key) != null){
                int n = map.get(key);
                List<String> item = items.get(n);
                item.add(str);
                items.set(n, item);
            }else{
                map.put(key, k++);
                ArrayList<String> item = new ArrayList<>();
                item.add(str);
                items.add(item);
            }
        }
        return items;
    }
}