import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //1
        boolean check = false;
        for(int i=2; i < 101; i++){
            for(int j=2; j < i; j++){
                if(i%j==0) {
                    check = true;
                    break;
                }
            }
            if(!check)
                System.out.printf("%d, ",i);
            check = false;
        }
        System.out.println();

        //2
        //каждый раз генерируется новая гирлянда так как возникли проблемы с преобразованием из 2 системы в int (слишком большое число)
        Scanner in = new Scanner(System.in);
        int option = 1;
        while(option != 0){
            option = in.nextInt();
            switch(option){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    lampsBlink();
                    break;
                case 2:
                    lampsCheck();
                    break;
                case 3:
                    lampsRun();
                    break;
                case 4:
                    lampsShow();
                    break;
            }
        }

        //3
        //Exception in thread "main" java.lang.NumberFormatException: For input string: "10001100000011100001001000011111" under radix 2
        //Если число начинается с 1 выходит такая ошибка
        for(int i=0; i < 10; i++){
            lampsBlink();
        }
        System.out.println();
        for(int i=0; i < 10; i++){
            lampsRun();
        }
    }


    public static void lampsBlink(){
        String lamps = createLamps();
        while(tryParse(lamps) == 0){
            lamps = createLamps();
        }
        lamps = blink(Integer.parseInt(lamps,2));
        System.out.println(toGraphicalView(lamps));
    }

    public static void lampsCheck(){
        String lamps = createLamps();
        while(tryParse(lamps) == 0){
            lamps = createLamps();
        }
        isFirstLampOn(Integer.parseInt(lamps,2));
    }

    public static void lampsRun(){
        String lamps = createLamps();
        while(tryParse(lamps) == 0){
            lamps = createLamps();
        }
        lamps = run(Integer.parseInt(lamps,2));
        System.out.println(toGraphicalView(lamps));
    }

    public static void lampsShow(){
        String lamps = createLamps();
        while(tryParse(lamps) == 0){
            lamps = createLamps();
        }
        System.out.println(toGraphicalView(lamps));
    }
    public static String createLamps(){
        String lamps = "";
        for(int i=0;i<32; i++){
            lamps += Integer.toBinaryString((int)(Math.random() * 2));
        }
        return lamps;
    }

    public static String blink(int arr){
        arr = ~arr;
        return Integer.toBinaryString(arr);
    }


    public static String toGraphicalView(String currentState) {
        String graphicalView = "";
        for (int i = 0; i < currentState.length(); i++) {
            switch (currentState.charAt(i)) {
                case '1':
                    graphicalView += '*';
                    break;
                case '0':
                    graphicalView += 'о';
                    break;
            }
            if (i < currentState.length() - 1) {
                graphicalView += '-';
            }
        }
        return graphicalView;
    }



    public static long tryParse(String n){
        int x = 0;
        try{
            x = Integer.parseInt(n,2);
        }
        catch(Exception e){

        }
        return x;
    }

    public static String run(int currentState) {
        int signBitMask = Integer.reverse(1);
        currentState = (currentState >>> 1) | signBitMask;
        return Integer.toBinaryString(currentState);
    }

    public static void isFirstLampOn(int currentState){
        int res = (currentState>>31) & 1;
        if(res == 1){
            System.out.println("First Lamp is on");
        }
        else if(res == 0){
            System.out.println("First Lamp is off");
        }
    }
}



