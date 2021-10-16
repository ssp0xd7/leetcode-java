package 头条热题.字符串出现次数的TopK问题;

import java.util.*;

public class Solutiong {

    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static String[][] topKstrings(String[] strings, int k) {
        // write code here
        //str,count
        for (String str : strings) {
            int count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }

        List<String> strSet = new ArrayList<>(map.keySet());
        String[] ansList = new String[k];
        int i;
        for (i = 0; i < k; i++) {
            ansList[i] = strSet.get(i);
        }
        buildHeap(ansList);

        while (i < strSet.size()) {
            String heapMin = ansList[0];
            String str = strSet.get(i);
            if (compareTo(str, heapMin)) {
                ansList[0] = str;
                adjustHeap(ansList, 0);
            }
            i++;
        }

        String[][] ans = new String[k][2];
        for (int j = k - 1; j >= 0; j--) {
            ans[k - j - 1][0] = ansList[j];
            ans[k - j - 1][1] = map.get(ansList[j]) + "";
        }
        return ans;
    }

    private static void buildHeap(String[] ansList) {
        for (int i = ansList.length / 2 - 1; i >= 0; i--) {
            adjustHeap(ansList, i);
        }
    }

    private static void adjustHeap(String[] ansList, int currPos) {
        int len = ansList.length;
        String temp = ansList[currPos];
        for (int i = currPos * 2 + 1; i < len; i = i * 2 + 1) {
            if (i + 1 < len && compareTo(ansList[i], ansList[i + 1])) {
                i++;
            }
            if (compareTo(temp, ansList[i])) {
                ansList[currPos] = ansList[i];
                currPos = i;
            } else {
                break;
            }
        }
        ansList[currPos] = temp;
    }

    //比较，str1 > str2 返回 > 0
    private static boolean compareTo(String str1, String str2) {
        if (!map.get(str1).equals(map.get(str2))) {
            return map.get(str1) - map.get(str2) > 0;
        } else {
            return str1.compareTo(str2) < 0;
        }
    }
}
