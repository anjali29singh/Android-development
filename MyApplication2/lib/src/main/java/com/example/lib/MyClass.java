package com.example.lib;

import java.util.Scanner;

//import anotherPackage.Text;
//parent class


public class MyClass {
    public static void  main(String[] args){
//         System.out.println("hello world");
         int age = 23;
            byte x = 20;
//    type casting

        //implicit
//        int num=20;
//        num='a'
//        System.out.println(num);
//        explicit
        //strings

        String  name="anjali singh";
        String  middle="kumari";
//        System.out.println(name+middle);
//        System.out.println(name.length());

//        if(age>=18) {
//            System.out.println("you are adult");
//        } else {System.out.println("you are young");

//        while(num!=0){
//            System.out.println(num);
//            num--;
//
//    }

//        datatype  [] arrayName = new datatype[datasice]
        int[] nos =  new int[5];
        int[][] array = new int[3][4];
//        greet();
//        System.out.println(fullName());
//
//        System.out.println("the average of numbers is: " + average(new int[]{1, 2, 3, 4, 5}));
        //creating object
        //className object = new className()
//        com.example.lib.Car redCar = new com.example.lib.Car(2018,50);


        Scanner  a = new Scanner(System.in);
        /******************************** exercise 1***************************/
        /*System.out.println("enter first number");
        int n1= a.nextInt();
        System.out.print("enter second number");

        int n2= a.nextInt();
        int div1 = n1/n2, mod = n1%n2;

        System.out.println(div1);
        System.out.println(mod);

        */
         /******************** exercise 2 *******/

        /*System.out.println("Enter radius of circle");
        double radius = a.nextDouble();

        double area = 3.14*radius*radius;
        System.out.println("Area of circle is:" + area);
*/
//        /* exercise 3*/
     /*   System.out.println("Enter a positive integer ");
        int num = a.nextInt();
        int bin_num=0;

        while(num!=0){

            bin_num = (bin_num*10) + (num%2);
            num=num/2;
        }
        System.out.println("binary number is " + bin_num);
*/
        //exercise 4
        System.out.println("enter a string ");
        String str = a.nextLine();
//        count(str);
//

//        exercise 5

        
    }
    public static  void count(String str){

        char[] charArray = str.toCharArray();
        int letters=0,spaces=0,others =0 ;

            for(int i = 0; i < str.length(); i++) {

              if(Character.isLetter(charArray[i])) letters++;
              else if(Character.isSpaceChar(charArray[i])) spaces++;
              else others++;
            }

            System.out.println("number of letters in word is: " +letters);
        System.out.println("number of spaces in word is: " +spaces);
        System.out.println("number of others in word is: " + others);

    }

    static void greet(){

        System.out.println("hello everyone this is anjali singh ");
    }

    //return type method

    static String fullName(){

        return "Anjali Singh";
    }

    static int average(int[]arr){

        int sum =0;
        for (int j : arr) {
            sum = sum + j;
        }
        return sum/arr.length;
    }

    //method overloading means multiple method can have same name but different parametes

//    static double average(double[]arr){
//
//    }


}

