class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primeNumbers = new boolean[right + 1];
        int primeNumberCount = 0;
        for(int i = left; i <= right; i++) {
            boolean isPrimeNumber = true;

            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber) {
                primeNumberCount++;
                primeNumbers[i] = true;
            }
        }
        primeNumbers[1] = false;

        if (primeNumberCount < 2) {
            return new int[]{-1, -1};
        }

        int prime1 = 0, prime2 = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
            if (primeNumbers[i]) {
                if (prime1 == 0) {
                    prime1 = i;
                } else if (prime2 == 0) {
                    prime2 = i;
                    map.put(prime2 - prime1, new int[]{prime1, prime2});
                } else {
                    prime1 = prime2;
                    prime2 = i;
                    if (map.containsKey(prime2 - prime1)) {
                        continue;
                    }
                    map.put(prime2 - prime1, new int[]{prime1, prime2});
                }
            }
        }

        Integer[] keys = map.keySet().toArray(Integer[]::new);
        Arrays.sort(keys);

        return map.get(keys[0]);
    }
}