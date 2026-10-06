class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1,e2) -> e2.getValue()-e1.getValue()); //max heap

        // add entries
        for(Map.Entry e : map.entrySet()){
            pq.add(e);
        }

        // poll top k
        while(!pq.isEmpty() && k>0){
            int top = pq.poll().getKey();
            res[--k] = top;
        }

        return res;     
    }
}
