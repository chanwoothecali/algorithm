class ProductOfNumbers {

    private List<Integer> arr = new ArrayList<>();
        private int length = 0;

        public ProductOfNumbers() {

        }

        public void add(int num) {
            arr.add(num);
            length++;
        }

        public int getProduct(int k) {
            int multiple = 1;
            for (int i = 1; i <= k; i++) {
                multiple *= arr.get(length - i);
            }

            return multiple;
        }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */