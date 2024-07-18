package com.jtc;
public class App {
    public static void main(String[] args) {
      /*
       //prime no
       Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int counter = 0;
        if (num <= 2) {
            System.out.println("prime less than 3");
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                counter++;
            }
        }
        if (counter > 0) {
            System.out.println("not prime");
            System.out.println(counter);
        }else {
        System.out.println("prime");

    }
}*/
        //2nd way prime number
       /* int n=6;
        int divisioncount=0;
        for (int i=1;i<=n;i++) {
            if (n%i==0)
                divisioncount++;
        }
        if (divisioncount==2)
            System.out.println("prime");
        else
            System.out.println("not prime");*/


        //reverse string
       /* String a="pawan";
        String b="";
        for (int i=a.length()-1;i>=0;i--){
           b=b+a.charAt(i);
        }
        System.out.println(b); */

        /*
        //swap string
        String a="shilpii";
         String b="shikha";
         a=a+b;
         b=a.substring(0,a.length()-b.length());
         a=a.substring(b.length());
         System.out.println(a);
         System.out.println(b);*/


        //sum of digits
      /* int num=11111;
        int sum=0,evendigitssum=0,oddsum=0;
        while (num!=0){
            int rem=num%10;
            sum=sum+rem;
           if (rem%2==0)
               evendigitssum=evendigitssum+rem;
           else
               oddsum=oddsum+rem;
            num=num/10;
        }
        System.out.println(sum);
        System.out.println(evendigitssum);
        System.out.println(oddsum);*/

       /*
        //palindrome string
        String s = "nanan";
        String s2 = "";
for (int i=s.length()-1;i>=0;i--) {
    s2 =s2+ s.charAt(i);
}
        System.out.println(s2);
if (s.equals(s2)){
    System.out.println("string is palindrome" );
}*/

        // palindrome number
        /*int num=101;
        int num1=num;
        int num2=0;
        while(num>0) {
            int rem = num % 10;
            num2 = num2 * 10 + rem;
            num = num / 10;
        }
        System.out.println(num2);
if (num2 == num1){
    System.out.println("pali");
}else {
    System.out.println("not pali");
}*/

        //swap 2 numbers
      /*  int a=5;
        int b=9;
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a);
        System.out.println(b);*/

        //reverse number
        /*Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int rem=0;
        int num1=0;
        int temp=num;
        while (num>0){
            rem=num%10;
            num1=num1*10+rem;
            num=num/10;
        }
System.out.println(num1);
        if(temp==num1){
            System.out.println("no is palindrome");
        }*/

        //armstrong number
    /*  int num = 371;
        int temp = num;
       int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum = (int) (sum + Math.pow(rem, 3));
            num = num / 10;
        }
        System.out.println(sum);
        if (temp == sum) {
            System.out.println("armstrong");
        }*/

//reverse array
        /*String s1 = "1011";
        char[] s3 = s1.toCharArray();
        for (int i=s3.length-1;i>=0;i--){
            System.out.print(s3[i]);
        }
        System.out.println();*/

//array palindrome
       /* int [] s2={1,0,1,8};
                int flag=0;
                int n=s2.length-1;
        for (int i=0,j=n;i<j;j--,i++){
      if (s2[i]!=s2[j]){
          flag=1;
          break;
      }}
        if (flag>0){
            System.out.println("not palindrome");
        } else  {
System.out.println("palindrome");
        }
        */
        //fibonacci series approach 1
        /*int fiblenght;
        Scanner sc=new Scanner(System.in);
        fiblenght=sc.nextInt();
        int num[]=new int[fiblenght];
        num[0]=0;
        num[1]=1;
        for (int i=2; i<fiblenght;i++){
            num[i]=num[i-1]+num[i-2];
        }
        for (int i=0;i<fiblenght;i++) {
            System.out.print(num[i]+" ");
        }*/
        //fibonacci approach 2
       /* int a,first=0,second=1,next,no;
        Scanner sc=new Scanner(System.in);
        no=sc.nextInt();
        for (int i=0;i<no;i++){
            System.out.println(first);
            next=first+second;
            first=second;
            second=next;
        }*/
        //factorial of a number
        /*int num=4,fect=1;
        for (int i=1;i<=num;i++){
            //for(i=num;i>=1;i--
            fect=fect*i;
        }
        System.out.println(fect);*/

        //no of digits in a number
       /* int num=0,count=0,temp;
        if(num<0){
            num=num*-1;
        } else if (num==0) num = 1;
        while (num>0){
            temp=num/10;
            num=temp;
            count++;
        }
        System.out.println(count);*/


        //get the count of capitalized Words in a string
       /* String s="Hello how Are you?";
        int count=0;
        char ch[]=s.toCharArray();
        for (int i=0;i<ch.length;i++){
            if (ch[i]>='A' && ch[i]<='Z'){
                count++;
            }
        }
        System.out.println("no of capitalized word "+count);*/
        //Write a Java Program to generate Output "aabbbcccc" with the input "a2b3c4"
       /* String s="a2b3c4";
        char ch[]=s.toCharArray();
        for (int i=0;i<=ch.length-1;i++){
            if (Character.isAlphabetic(ch[i])){
             System.out.print(ch[i]);
            }
            else {
                int n = Character.getNumericValue(ch[i]);
                for (int j = 1; j < n; j++) {
                    System.out.print(ch[i - 1]);
                }
            }}*/
//Write a Java Program to print the product of an array except self?
       /* int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int[] prefixes = new int[n];
        int[] suffixes = new int[n];
        int[] output_array = new int[n];
        prefixes[0] = 1;
        suffixes[n -1] = 1;
        for(int i = 1; i < n; i++) {
            prefixes[i] = arr[i-1] * prefixes[i-1];
        }
        for(int i = n -2; i >=0; i--) {
            suffixes[i] = arr[i+1] * suffixes[i+1];
        }
        for(int i = 0; i < n; i++) {
            output_array[i] = prefixes[i] * suffixes[i];
        }
        for(int i = 0; i < n; i++) {
            System.out.print(output_array[i] + " ");
        }*/
       //sug's approach
       /* int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int[] brr = new int[n];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product = product * arr[j];
                }
                brr[i] = product;
            }
            System.out.print(brr[i]+" ");
        }*/

        //star pattern
       /* for (int i=0;i<=4;i++){
            for (int j=4;j>=i;j--){
                System.out.print(" ");
            }
            for (int k=0;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=0;i<=4;i++){
            for (int j=0;j<=i;j++){
                System.out.print(" ");
            }
            for (int k=4;k>=i;k--){
                System.out.print("*");
            }
            System.out.println();
        }*/
        // star pattern pyramid
        /*for (int i=0;i<=4;i++){
            for (int j=4-i;j>0;j--){
                System.out.print(" ");
            }
            for (int k=0;k<=i;k++){
                System.out.print("* ");
            }
            System.out.println();
        }*/
        // Write a Java Program to find the longest consecutive occurrence of integers in a given array.
        /*int[] arr = { 4, 3, 25, 6, 7, 8, 9, 2, 3, 10 };
        int count = 0;
        int max =0;
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] +1== arr[i+1]) {
                count++;
            }else {
                count = 0;
            }
           max = Math.max(max, count+1);
        }
        System.out.println(max);*/
        //character frequency in a string
       /* String str = "hello world";
        int[] temp = new int[256]; // Array to store character count
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            temp[ch]++;
        }
        // Print the character frequency
        System.out.println("Character frequencies in the string \"" + str + "\":");
        for (int i = 0; i < 256; i++) {
            if (temp[i] != 0) {
                System.out.println("'" + (char) i + "' : " + temp[i]);
            }}*/
        String s="lellllol";
        char ch[]=s.toCharArray();
        int counter=0;
        for (int i=0;i<=s.length()-1;i++){
            if (s.charAt(i)=='l'){
                counter++;
            }
        }System.out.println(counter);


        }}