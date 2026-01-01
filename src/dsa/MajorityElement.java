package dsa;

class MajorityElement{
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] arr){
        int candidate = -1;
        int n = arr.length;
        int count = 0;

        for(int num : arr){
            if(count == 0){
                candidate = num;
                count = 1;
            }else if(candidate == num){
                count++;
            }else{
                count--;
            }
        }

        // validate the candidate
        count = 0;
        for(int num:arr){
            if(candidate == num)
                count++;
        }

        if(count > n/2){
            return candidate;
        }else{
            return -1;
        }
    }
}