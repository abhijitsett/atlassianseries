package dsa;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        mergeArrays(arr1, arr2);

        for (int num : arr1) System.out.print(num + " ");
        System.out.println();

        for (int num : arr2) System.out.print(num + " ");
        System.out.println();
    }

    private static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0; int j = 0;
        int[] mergedArr = new int[n+m];
        int k = 0;
        while(i < n && j < m){
            if(arr1[i] < arr2[j])
                mergedArr[k++] = arr1[i++];
            else
                mergedArr[k++] = arr2[j++];
        }

        while(i < n)
            mergedArr[k++] = arr1[i++];

        while(j < m)
            mergedArr[k++] = arr2[j++];

        for(i=0;i<n;i++)
            arr1[i] = mergedArr[i];
        for(j=0;j<m;j++)
            arr2[j] = mergedArr[n+j];
    }
}
