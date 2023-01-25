import java.util.*;
public class may {
    static void grab(int a[][],int m,int n){
        int i,j;
        Scanner sc=new Scanner(System.in);
        for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                a[i][j]=sc.nextInt();

            }
        }
    }
    static void show(int a[][],int m,int n){
        int i,j;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of rows and columns of matrix 1 : ");
        int m=sc.nextInt(),n=sc.nextInt();
       int a[][]=new int[2][2];
       System.out.println("Enter no.of rows and columns of matrix 2 : ");
       int c=sc.nextInt(),d=sc.nextInt();
       int b[][]=new int[2][2];
      
        if(n!=c){
        System.out.println("Matrix multiplication not possible");

       }
       else{
        System.out.println("Enter elements of matrix 1:");
        grab(a,m,n);
        System.out.println("Enter elements of matrix 2");
        grab(b,c,d);
        int s[][]=new int[m][d];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            for(int k=0;k<n;k++){
                s[i][j]+=a[i][k]*b[k][j];
            }
        }
    }
    System.out.println("1st matrix: ");
    show(a,m,n);
    System.out.println("2nd matrix: ");
    show(b,c,d);
    System.out.println("Resultant matrix: ");
    show(s,m,d);
       }
    }
    
}
