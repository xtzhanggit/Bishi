package ninwoo;

import java.util.*;

public class Main {
    public static int getResult(int[] arr) {
        if(arr.length <= 1) {
            return 0;
        }
        if(arr[0] < 3) {
            return 0;
        }
        int[] ints = Arrays.copyOfRange(arr, 1, arr.length);
        Arrays.sort(ints);

        int count = 0;
        int i = 0;
        while(i < ints.length - 2) {
            if(ints[i] == 0) {
                i++;
                continue;
            } else {
                ints[i + 1] -= ints[i];
                ints[i + 2] -= ints[i];
                count += ints[i];
                ints[i] = 0;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            arr[i] = new int[number+1];
            arr[i][0] = number;
            for (int j = 0; j < number; j++) {
                arr[i][j+1] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(getResult(arr[i]));
        }
    }
}
