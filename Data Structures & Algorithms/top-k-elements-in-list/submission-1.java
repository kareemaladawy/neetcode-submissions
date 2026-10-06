class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use a hashmap to store key value pair for 
        // each number -> its count
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
                continue;
            }

            map.put(nums[i], 1);
        }

        // sort unique numbers by frequency descending and take top k
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
