package ALG;

import java.util.Arrays;

//稀疏算法
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr=new int[11][11];
        arr[3][3]=11;
        arr[4][6]=8;
        arr[7][2]=2;
        arr[10][3]=7;
        int sum=0;
        for (int[] row:arr) {
            for (int data:row) {
                if (data!=0)
                    sum++;
                System.out.print("\t"+data);
            }
            System.out.println();
        }
        int count=0;
        int[][] sprasearr=new int[sum+1][3];
        sprasearr[0][0]=11;
        sprasearr[0][1]=11;
        sprasearr[0][2]=sum;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
               if(arr[i][j]!=0){
                   count++;
                   sprasearr[count][0]=i;
                   sprasearr[count][1]=j;
                   sprasearr[count][2]=arr[i][j];
               }
            }
        }
        for (int[] row:sprasearr
             ) {
            for (int data:row
                 ) {
                System.out.print("\t"+data);
            }
            System.out.println();

        }
        int[][] arr2=new int[sprasearr[0][0]][sprasearr[0][1]];
        for (int i = 1; i <sprasearr.length ; i++) {
            arr2[sprasearr[i][0]][sprasearr[i][1]]=sprasearr[i][2];
        }
        for (int[] row:arr2
             ) {
            for (int data:row
                 ) {
                System.out.print("\t"+data);
            }
            System.out.println();
        }

    }
}
