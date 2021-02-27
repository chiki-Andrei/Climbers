package Climbers;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class Climber {
    private int stamina;
    private int max_height;
    private int height_difference;

    public Climber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выносливость скалолаза (не менее трех):");
        this.stamina = input.nextInt();
        if (stamina < 3){
            stamina = 3;
        }

        System.out.println("Введите пиковую высоту скалолаза:");
        this.max_height = input.nextInt();
        if (max_height < 0){
            max_height = 1;
        }

        System.out.println("Введите максимальный перепад трех ближайших вершин:");
        this.height_difference = input.nextInt();
        if (height_difference < 0){
            height_difference = 1;
        }
        else if (height_difference > max_height) {
            height_difference = max_height;
        }

        input.close();
    }

    public void createRoute(){
        int[] route = new int[stamina];
        route[0] = (int) Math.round(random() * height_difference);
        route[1] = (int) Math.round(random() * min(route[0]+height_difference,max_height));

        for(int i = 2; i < stamina; i++){
            route[i] = getNextPoint(route[i-2], route[i-1]);
        }

        // вывод горы

        System.out.print("\n");
        int maxNumber = 0;
        int[] routeCopy = Arrays.copyOf(route, stamina);

        for (int j : routeCopy) {
            if (j > maxNumber) {
                maxNumber = j;
            }
        }

        int max = maxNumber;
        for (int i = 0; i < maxNumber; i++){
            for (int j = 0; j < routeCopy.length; j++){
                if(routeCopy[j] == 1 && max == 1){
                    System.out.print("*");
                    routeCopy[j] = -1;
                }
                else if(routeCopy[j] == 0 && max == 1){
                    System.out.print("_");
                    routeCopy[j] = -1;
                }
                else if(routeCopy[j] == max){
                    System.out.print("*");
                    routeCopy[j]--;
                }
                else{
                    System.out.print(" ");
                }
            }
            max--;
            System.out.print("\n");
        }

        for (int j : route) {
            System.out.print(j);
        }
    }

    private int getNextPoint(int prePrevious, int previous){
        int currentPoint;
        int max_change = height_difference - abs(prePrevious - previous);
        int a = max(prePrevious, previous) + max_change;
        int b = min(prePrevious, previous) - max_change;

        if(a > max_height){

            if(b < 0){
                currentPoint = (int) Math.round(Math.random() * max_height);
            }

            else{
                currentPoint = (int) Math.round(Math.random() * (max_height - b) + b);
            }

            return currentPoint;
        }

        if (b < 0){
            currentPoint = (int) Math.round(Math.random() * a);
            return currentPoint;
        }

        currentPoint = (int) Math.round(Math.random() * (a - b) + b);
        return currentPoint;
    }
}
