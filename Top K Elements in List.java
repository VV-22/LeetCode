class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    List<Integer>[] freq = new List[nums.length + 1];
    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        // System.out.println(freq[entry.getValue()]);
        freq[entry.getValue()].add(entry.getKey());
    }
    // System.out.println(freq);
    int[] returnVal = new int[k];
    int valueCount = 0;
    for (int i = freq.length - 1; i >= 0 && valueCount < k; i--) {
      for (int j = 0; j < freq[i].size(); j++) {
        returnVal[valueCount] = freq[i].get(j);
        valueCount++;
        if (valueCount == k) {
          return returnVal;
        }
      }
    }
    return returnVal;

    }
}
