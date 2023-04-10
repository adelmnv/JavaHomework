package Dz4;

import java.io.IOException;
import java.lang.reflect.Method;

class Printer<T>
{
    public void printArray(T[] array){
        for(int i=0; i < array.length;i++){
            System.out.println(array[i]);
        }
    }
}

class Switch<T>{
    public T[] switchArray(T[] array, int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        return array;
    }
}
public class Solution {


    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");

        //1
        Switch mySwitch = new Switch();
        myPrinter.printArray(mySwitch.switchArray(intArray,0,2));
        myPrinter.printArray(mySwitch.switchArray(stringArray,0,1));
    }
}
