import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int count = 0;

        // Iterate over all possible pairs (i, j)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];

                // If the product exists in the map, add its count to the result
                count += productCount.getOrDefault(product, 0);

                // Store this product occurrence in the hashmap
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Multiply by 8 as each pair can form 8 unique tuples
        return count * 8;
    }
}
