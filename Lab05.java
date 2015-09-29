/*
Programmer: Franco Lavares
Title:      Lab 5   
Date:       September 29, 2015
Filename:   Lab05.java
*/

//package javalab5;

import java.util.*;

public class Lab05 
{
    
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        int arrayLength, count1, count2, zeros;

        System.out.print("Enter the first number: ");
        
        String num1 = input.next();
        
        System.out.print("Enter the second number: ");
        
        String num2 = input.next();

        //gets the lengths of the two strings
        count1 = num1.length();
        count2 = num2.length();

        /*
        The if else statement finds the longer string and stores it as 
        arrayLength. zeros is used to calculate the difference in digits if 
        one string is shorter than the other.
        */   
        if (count1 > count2)
	{
            arrayLength = count1;
            zeros = count1 - count2;
	}
	else
	{
            arrayLength = count2;
            zeros = count2 - count1;
        }

        //this indexes the strings into arrays with the same length
        int[] numArray1 = new int[arrayLength];
        int[] numArray2 = new int[arrayLength];

        //if the first string is longer than the second
        if (count1 > count2)
        {
            for (int i = 0; i < zeros; i++)//fills the empty indexes with zeros
            {
                numArray2[i] = 0;
            }
            for (int i = zeros; i < arrayLength; i++)
            {
                numArray2[i] = Integer.parseInt     
                    (String.valueOf(num2.charAt(i-zeros)));
            }
            for (int i = 0; i < arrayLength; i++)
            {
                numArray1[i] = Integer.parseInt(String.valueOf(num1.charAt(i)));
            }
        }
        
        //if the second string is longer than the first
        else if (count2 > count1)
        {
            for (int i = 0; i < zeros; i++)//fills the empty indexes with zeros
            {
		numArray1[i] = 0;
            }
            for (int i = zeros; i < arrayLength; i++)
            {
                numArray1[i] = Integer.parseInt
                    (String.valueOf(num1.charAt(i-zeros)));
            }
            for (int i = 0; i < arrayLength ; i++)
            {
                numArray2[i] = Integer.parseInt(String.valueOf(num2.charAt(i)));
            }

        }
        
        /*
        if the two strings are equal in length, the program doesn't need to
        fill empty indexes with zeros
        */
        else
        {
            for (int i = 0; i < num1.length(); i++)
            {
            	numArray1[i] = Integer.parseInt(String.valueOf(num1.charAt(i)));
            }
            
            for (int i = 0; i < num2.length(); i++)
            {
                numArray2[i] = Integer.parseInt(String.valueOf(num2.charAt(i)));
            }
	}
        
        System.out.print("  " + num1);//alignment
        System.out.println();
        System.out.print("+ " + num2);
        
        sumOfArrays(arrayLength, numArray1, numArray2);
    }
    
    public static int[] sumOfArrays
        (int arrayLength, int[] numArray1, int[] numArray2)
    {
        int carry = 0;
        int[] numArray3 = new int[arrayLength+1];
        //numArray3[0] = 0; unnecessary?

        for (int i = arrayLength-1; i >= 0; i--)
        {
            //this is where the addition is done
            numArray3[i] = numArray1[i] + numArray2[i] + carry;
            carry = 0;
            
            //a 1 will carry over to the next iteration if the sum is > 9
            if(numArray3[i] > 9 && i > 0)
            {
                numArray3[i] = numArray3[i] - 10;
                carry = 1;
            }
        }
        
        //used to append the elements in numArray3 into a single string 
        //for some reason, this always caused the output to have a trailing zero
//        StringBuilder builder = new StringBuilder();
//        for (int i : numArray3)
//        {
//            builder.append(i);
//        }
//        
//        String sum = builder.toString();
//      
//        System.out.print("= " + sum);
//        System.out.println();
        
        System.out.println();
        System.out.print("= ");

        for (int i = 0; i < arrayLength; i++)
        {
            System.out.print(numArray3[i]);
        }
       
        System.out.println();
        
        return numArray3;
    }
}
