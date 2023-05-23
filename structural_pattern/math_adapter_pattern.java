package structural_pattern;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

interface MathProcessing
{
    public void performMathOperation(String operator, List<Integer> datainput);
}

class Basicmathprocessing implements MathProcessing
{
    MathAdapter ma1 = new MathAdapter();

    public void performMathOperation(String operator, List<Integer> datainput)
    {

    }
}

class AdvancedmathProcessing
{
    public void calculateAverage(List<Integer> ls)
    {
        int sum = 0;
        for(int num:ls)
        {
            sum = sum + ls.get(num);
        }

        int average = sum / ls.size();

        System.out.println("The Average is : " + average);
    }

    public void sortData(List<Integer> ls)
    {
        Collections.sort(ls);

        System.out.println("Sorted array is : ");
        for(Integer i : ls)
        {
            System.out.println(i + " ");
        }

        System.out.println("\n");
    }

    public void searchData(List<Integer> ls, int key)
    {
        int flag = 0;

        for(int i=0; i<ls.size();i++)
        {
            if(key == ls.get(i))
            {
                System.out.println("Element " + key + " found at position " + i);
            }

            else
            {
                System.out.println(key + " not found in the array");
            }
        }
    }

    public void replaceData(List<Integer> ls, int key, int value)
    {
        for(int i=0; i<ls.size();i++)
        {
            if(key == ls.get(i))
            {
                ls.set(i, value);
            }

            else
            {
                System.out.println("Element to be replaced not found !!");
            }
        }
    }

    public void listAdd(List <Integer> ls)
    {
        int sum=0;

        for(Integer l : ls)
        {
            sum = sum + l;
        }

        System.out.println("Sum of the array is : " + sum);
    }
}

class MathAdapter implements MathProcessing
{
    AdvancedmathProcessing m1 = new AdvancedmathProcessing();

    @Override
    public void performMathOperation(String operator, List<Integer> data)
    {
        List <Integer> ls1 = new ArrayList<Integer>();

        if (operator.equalsIgnoreCase("sum") || operator.equals("+")) {
            m1.listAdd(data);
        } else if (operator.equalsIgnoreCase("avg")) {
            m1.calculateAverage(data);
        } else if (operator.equalsIgnoreCase("sort")) {
            m1.sortData(data);
        } else if (operator.equalsIgnoreCase("search")) {
            System.out.println("Enter the key to search: ");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int key = sc.nextInt();
            m1.searchData(data, key);
        } else if (operator.equalsIgnoreCase("replace")) {
            System.out.println("Enter the key to replace: ");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int key = sc.nextInt();
            System.out.println("Enter the new value to replace " + key + " with: ");
            int value = sc.nextInt();
            m1.replaceData(data, key, value);
        }
    }
}

public class math_adapter_pattern
{
    public static void main(String[] args)
    {

        // Create a list of integers
        List<Integer> data = new ArrayList<Integer>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);

        // Create an instance of the MathAdapter class
        MathAdapter mathAdapter = new MathAdapter();

        // Call the performMathOperation method to get the sum of the integers in the list
        mathAdapter.performMathOperation("sum", data);

        // Call the performMathOperation method to sort the integers in the list
        mathAdapter.performMathOperation("sort", data);

        // Call the performMathOperation method to find an element in the list
        mathAdapter.performMathOperation("search", data);

        // Call the performMathOperation method to replace an element in the list
        mathAdapter.performMathOperation("replace", data);

        // Call the performMathOperation method to get the average of the integers in the list
        mathAdapter.performMathOperation("average", data);

    }
}