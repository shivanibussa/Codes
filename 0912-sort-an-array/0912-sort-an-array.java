class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            if (high - low <= 10) {
                insertionSort(nums, low, high);
            } else {
                int pivot = sortingAlgo(nums, low, high);
                quicksort(nums, low, pivot - 1);
                quicksort(nums, pivot + 1, high);
            }
        }
    }

    public static int sortingAlgo(int[] nums, int low, int high) {
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        swap(nums, low, randomIndex);
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (nums[i] <= pivot && i < high) {
                i++;
            }
            while (nums[j] > pivot && j > low) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    public static void insertionSort(int[] nums, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= low && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
