class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // ["act","pots","tops","cat","stop","hat"]
        HashMap<String, List<String>> map = new HashMap();

        for (String word: strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = String.valueOf(chars);

            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
