package Dz3.Task2;


class Arithmetic{
    public int add(int a, int b){
        return a+b;
    }
    public String name(){
        return "Мой суперкласс: Арифметика";
    }
}

class Adder extends Arithmetic{

}

public class Solution {
    public static void main(String args[]){
        Adder adder = new Adder();
        System.out.println(adder.name());
        System.out.printf("%d %d %d",adder.add(20,22), adder.add(10,3), adder.add(9,11));

    }

}