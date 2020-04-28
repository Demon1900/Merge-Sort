import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class MergeSort
{
	public static Scanner x;

	public static void open()
	{
	try{ x=new Scanner(new File("Unsorted.txt"));
	   }
	catch(Exception e){System.out.println ("File not found");}
	}


	public static void read() //This
	{
	ArrayList<Integer> MS=new ArrayList<Integer>();
		while(x.hasNextLine())
		{
			MS.add(x.nextInt());
		}
	System.out.println(MS);


	System.out.println(MS);

	MergeSort Nms = new MergeSort(MS);

 Nms.SortedArray();

        System.out.println("\n The Sorted Merge Array");
        for(int i:Nms.getSortedArray()){
            System.out.print(i+" ");
        }

	}


    private ArrayList<Integer> inputArray;

    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    public MergeSort(ArrayList<Integer> inputArray){
        this.inputArray = inputArray;
    }

    public void SortedArray(){
        Chop(0, this.inputArray.size()-1);
    }

    public void Chop(int FirstElem,int EndElem){


        if(FirstElem<EndElem && (EndElem-FirstElem)>=1){ //This will divide the element by two
            int mid = (EndElem + FirstElem)/2;
            Chop(FirstElem, mid);
            Chop(mid+1, EndElem);


            merger(FirstElem,mid,EndElem);    //merging Sort will start to merge together
        }
    }

    public void merger(int FirstElem,int MidElem,int EndElem){


        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>(); //This will start to sort the arrays together

        int LeftSide = FirstElem;
        int RightSide = MidElem+1;

        while(LeftSide<=MidElem && RightSide<=EndElem){
            if(inputArray.get(LeftSide)<=inputArray.get(RightSide)){
                mergedSortedArray.add(inputArray.get(LeftSide));
                LeftSide++;
            }else{
                mergedSortedArray.add(inputArray.get(RightSide));
                RightSide++;
            }
        }

        //Either of below while loop will execute
        while(LeftSide<=MidElem){
            mergedSortedArray.add(inputArray.get(LeftSide));
            LeftSide++;
        }

        while(RightSide<=EndElem){
            mergedSortedArray.add(inputArray.get(RightSide));
            RightSide++;
        }

        int i = 0;
        int j = FirstElem;
        									//This will start to sort the array
        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }


public static void close() //This will end up closing the file
	{x.close();}

	public static void main(String args[]) // This is the main element that will get the program to run
	{
	open();
	read();
	close();

	}

}