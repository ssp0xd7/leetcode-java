package 剑指offer_2.最小的k个数;


public class Solution_2 {

    /**
     * 用大顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0) {
            return new int[0];
        }
        int[] maxHeapArr = new int[k];
        int i;
        for (i = 0; i < k; i++) {
            maxHeapArr[i] = arr[i];
        }

        buildMaxHeap(maxHeapArr);
        while (i < arr.length) {
            if (arr[i] < maxHeapArr[0]) {
                maxHeapArr[0] = arr[i];
                adjustMaxHeap(maxHeapArr, 0);
            }
            i++;
        }

        return maxHeapArr;
    }

    public void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(a, i);
        }
    }

    /**
     * 调整堆，构建最大堆
     *
     * @param a
     * @param currPos
     */
    public void adjustMaxHeap(int[] a, int currPos) {
        int len = a.length;

        int tempRoot = a[currPos];
        //从当前节点的左子节点开始
        for (int k = currPos * 2 + 1; k < len; k = 2 * k + 1) {
            //如果左子节点小于右子节点，则右移一位，然后比较最大的子节点与当前的跟大小，小于当前跟则替换，使其满足大顶堆条件
            if (k + 1 < len && a[k] < a[k + 1]) {
                k++;
            }
            if (a[k] > tempRoot) {
                a[currPos] = a[k];
                currPos = k;
            } else {
                break;
            }
        }
        a[currPos] = tempRoot;
    }
}
