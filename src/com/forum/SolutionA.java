package com.forum;

import java.util.Scanner;

/**
 * Part A:
 *
 * You are given an array of integers that represents the IDs of the users that have registered in “UpgradBook,”
 * a private social network created for all the students who have graduated from Upgrads’ programs.
 *
 * The array of integers has the following properties:
 *
 * With a known length N
 *
 * The array is sorted in an ascending order
 *
 * The array holds distinct integers (i.e. there are no repeating numbers)
 *
 * The array is 1-indexed, i.e. the first element is stored in A[1] (not A[0])
 *
 * Find the first positive integer M (where 1 <= M <= N) such that when M is used as the array index,
 * the result from the array is the the integer M itself. i.e. A[M] = M
 *
 * In other words, find the first positive integer M where M is both a user’s ID and its index in the array of user ids.
 *
 * Write a program to find M, if it exists, in O(log N) time. If M does not exist, please return NOT_FOUND
 *
 */
public class SolutionA {
    /**
     * This method returns the element in the array where its equal to the array index
     * @param inputArr: the input array which needs to be searched
     * @return the element in the array if found else return -1
     */
    public static int getBinarySearchUserComparisonWithArrayIndex(int[] inputArr) {
        //Start index for search
        int start = 1;
        //End index for search
        int end = inputArr.length - 1;
        //Mid variable initialized to 0
        int mid = 0;

        while(start <= end){

            //Calculate the mid value from start and end index
            mid = start + (end - start) / 2;

            //If element in the array equals the index return the array element
            if(inputArr[mid] == mid){
                return inputArr[mid];
            }
            //If mid variable is greater then the element at mid index in the array, search on the right side
            else if(mid > inputArr[mid]){
                start = mid + 1;
            }
            //If mid variable is less then the element at mid index in the array, search on the left side
            else if(mid < inputArr[mid]){
                end = mid - 1;
            }
        }
        //If element not found return -1
        return -1;
    }
    /**
     * This method returns the input array by the user defaulting the first element as 0 as array is 1-indexed
     * @param size: the size of the array
     * @param s: the scanner object to get the integer array elements from the user
     * @return the array
     */
    public static int[] getArrayInput(int size, Scanner s){

        int array[] = new int[size];

        //Default dummy value for first element as array is 1-indexed
        array[0] = 0;

        //Store the elements in the array given by the user
        for (int i = 1; i < size; i++) {
            array[i] = s.nextInt();
        }
        //Return the populated array
        return array;
    }
    //Default execution of the program
    public static void main(String[] args) {
        //Scanner object to get the input from the user via command line
        Scanner scanner = new Scanner(System.in);

        //Get the size of the array from the user
        int sizeArray = scanner.nextInt();

        //Array size increased by 1 to consider all the elements as array is 1-indexed
        sizeArray++;

        //Get the sorted array as input from the user
        int sortedArray[] = getArrayInput(sizeArray, scanner);

        //Binary Search the element where element is equal to the index itself
        int result = getBinarySearchUserComparisonWithArrayIndex(sortedArray);

        //Element not found
        if (result == -1)
            System.out.println("NOT_FOUND");
            //If element found, print it
        else
            System.out.println(result);

    }
}
