package 基础算法.八大排序;


import util.TreeNode;

public class SortFunctions {

    /**
     * 选择排序
     * 选择最小的与当前位置替换
     *
     * @param a
     */
    public static void selectSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            int currMin = a[i];
            int currIndex = i;

            for (int j = i + 1; i < a.length; i++) {
                // 记录当前轮次的最小值和最小值所在的位置
                if (a[j] < currMin) {
                    currMin = a[j];
                    currIndex = j;
                }

                //判断最小值的位置是否是当前位置
                //如果是当前位置则说明排序结束；否则交换当前轮次位置与当前轮次最下值位置的值
                if (currIndex != i) {
                    a[currIndex] = a[i];
                    a[i] = currMin;
                }
            }
        }
    }

    /**
     * 插入排序
     * 当前位置向左侧顺序列表插入
     *
     * @param a
     */
    public static void insertSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int curr = a[i];
            int currIndex = i;

            //判断当前位置的值是否小于左侧顺序子数组的最大值
            //若小于，则需要将当前位置的值，插入到左侧顺序子数组中
            if (a[currIndex - 1] > curr) {
                while (currIndex >= 1 && a[currIndex - 1] > curr) {
                    //当前顺序子数组的最大值，向右移动
                    a[currIndex] = a[currIndex - 1];
                    currIndex--;
                }

                //插入
                a[currIndex] = curr;
            }
        }
    }


    /**
     * 希尔排序
     * 插入排序进阶，利用插入排序的两个特点
     * 目标数组足够小时，效率高
     * 目标数组整体越有序，效率越高
     *
     * @param a
     */
    public static void shellSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        int length = a.length;
        int temp, i, j, step;

        //步长
        for (step = length / 2; step > 0; step /= 2) {
            for (i = step; i < length; i++) {
                temp = a[i];
                for (j = i - step; j >= 0 && temp < a[j]; j -= step) {
                    a[j + step] = a[j];
                }
                a[j + step] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     * 交换左右相邻两个位置
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        int temp;
        //a.length-1个位置需要冒泡出最大值或最小值
        for (int times = 0; times < a.length - 1; times++) {
            //每个轮次交换a.length-1-times个位置，因为times个位置已经冒泡成为最大或者最小了
            for (int i = 0; i < a.length - 1 - times; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    //-----------------归并排序-----------------//

    /**
     * 归并排序
     * 拆成足够小的子数组后（足够小后即有序），进行数组合并
     *
     * @param a
     * @param left
     * @param right
     */
    public static void mergeSort(int a[], int left, int right, int[] temp) {
        if (a == null || a.length == 1) {
            return;
        }

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid + 1, right, temp);

            merge(a, left, mid, right, temp);
        }
    }

    /**
     * 合并
     */
    public static void merge(int[] a, int left, int mid, int right, int[] temp) {
        //左右子序列首位
        int i = left, j = mid + 1;
        //临时数组指针
        int t = 0;

        //合并
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        //左边剩余填进temp
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        //右边剩余填进temp
        while (j <= right) {
            temp[t++] = a[j++];
        }
        //temp全部copy到结果a中
        t = 0;
        while (left <= right) {
            a[left++] = temp[t++];
        }
    }
    //-----------------归并排序-----------------//


    //-----------------快速排序-----------------//

    /**
     * 快速排序
     * 以左侧首位为target，进行左右比较、交换
     *
     * @param a
     * @param low
     * @param high
     */
    public static void quickSort(int[] a, int low, int high) {
        if (a == null || a.length == 1) {
            return;
        }
        if (low >= high) {
            return;
        }

        int partition = partition(a, low, high);
        //递归
        quickSort(a, low, partition - 1);
        quickSort(a, partition + 1, high);
    }

    public static int partition(int[] a, int low, int high) {
        int left = low;
        int right = high;
        int target = a[left];
        while (left < right) {
            //找到右侧第一个小于target
            while (left < right && a[right] > target) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] < target) {
                left++;
            }
            //找到左侧第一个大于targe
            a[right] = a[left];
        }
        //此时left左侧都比target小，右侧都比target大，targe为中心值
        a[left] = target;
        return left;
    }
    //-----------------快速排序-----------------//

    //-----------------堆排序-----------------//

    /**
     * 堆排序
     * <p>
     * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     * <p>
     * 第一个非叶子节点
     * 完全二叉树的性质之一是：如果节点序号为i，在它的左孩子序号为2*i+1，右孩子序号为2*i+2
     * - 左孩子的序号为n-1，则n-1=2*i+1，推出i=n/2-1
     * - 左孩子的序号为n-2，在n-2=2*i+1，推出i=(n-1)/2-1；右孩子的序号为n-1，则n-1=2*i+2，推出i=(n-1)/2-1
     *
     * @param a
     */
    public static void heapSort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        //构建大顶堆
        int firstNotLeaf = a.length / 2 - 1;
        for (int i = firstNotLeaf; i >= 0; i--) {
            //从第一个非叶子节点开始，自下而上、自右向左 调整堆
            adjustMaxHeap(a, i, a.length);
        }

        //交换堆顶与末尾元素，并调整堆
        for (int j = a.length - 1; j >= 0; j--) {
            //交换
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;

            //交换过后调整堆
            adjustMaxHeap(a, 0, j);
        }
    }

    /**
     * 调整大顶堆，使当前数组生成的堆满足堆定义（大堆或者小堆）
     *
     * @param a
     * @param currPos
     * @param length
     */
    public static void adjustMaxHeap(int[] a, int currPos, int length) {
        int temp = a[currPos];
        //从当前位置的左子节点开始
        for (int k = currPos * 2 + 1; k < length; k = 2 * k + 1) {
            //左小于右，则将k移动到右子节点
            if (k + 1 < length && a[k] < a[k + 1]) {
                k++;
            }
            //判断当前节点与当前父节点值
            if (a[k] > temp) {
                a[currPos] = a[k];
                currPos = k;
            } else {
                break;
            }
        }

        //最后将temp会写到当前对应的正确位置
        a[currPos] = temp;
    }
    //-----------------堆排序-----------------//
}


















































































