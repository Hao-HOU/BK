package bit.houhao.sort;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/4/4 08:35
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 2, 6, 1, 8, 9, 7, 10, 11, 6};
        sort(nums, nums.length);

        for (int i = 0 ; i < nums.length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[nums.length - 1]);
    }

    private static void sort(int[] nums, int n) {
        int i;
        for (i = n / 2 - 1; i >= 0; i--) {
            generateHeap(nums, i, n);
        }

        for (i = n - 1; i > 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;

            generateHeap(nums, 0, i);
        }


    }

    private static void generateHeap(int[] nums, int i, int n) {
        int childIndex;
        int tmp;

        for ( ; getLeftChildIndex(i) < n; i = childIndex) {
            childIndex = getLeftChildIndex(i);
            //取左右子节点中的较大者
            if (childIndex < n - 1 && nums[childIndex + 1] > nums[childIndex]) {
                childIndex++;
            }

            //更新父节点
            if (nums[i] < nums[childIndex]) {
                tmp = nums[i];
                nums[i] = nums[childIndex];
                nums[childIndex] = tmp;
            } else {
                break;
            }
        }
    }

    private static int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }
}
