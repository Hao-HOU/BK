package bit.houhao.sort;

/**
 * 巩固堆排序的知识
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/4/4 09:48
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 2, 6, 1, 8, 9, 7, 10, 11, 6};
        int[] topK = getTopK(nums, 5);

        for (int i = 0; i < topK.length - 1; i++) {
            System.out.print(topK[i] + " ");
        }

        System.out.println(topK[topK.length - 1]);
    }

    private static int[] getTopK(int[] nums, int k) {
        int[] topK = new int[k];
        int length = nums.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            generateHeap(nums, i, length);
        }

        for (int i = length - 1; i > length - k - 1; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;

            generateHeap(nums, 0, i);
        }

        for (int i = 0; i < k; i++) {
            topK[i] = nums[length - 1 - i];
        }

        return topK;
    }

    private static void generateHeap(int[] nums, int i, int n) {
        int leftChildIndex;
        int tmp;

        for ( ; getLeftChildIndex(i) < n; i = leftChildIndex) {
            leftChildIndex = getLeftChildIndex(i);
            if (leftChildIndex < n - 1 && nums[leftChildIndex + 1] > nums[leftChildIndex]) {
                leftChildIndex++;
            }

            if (nums[i] < nums[leftChildIndex]) {
                tmp = nums[i];
                nums[i] = nums[leftChildIndex];
                nums[leftChildIndex] = tmp;
            } else {
                break;
            }
        }
    }

    private static int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }
}
