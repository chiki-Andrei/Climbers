package Climbers;

import java.util.Scanner;

import static java.lang.Math.*;

public class Climber {

    private int stamina;
    private int max_height;
    private int height_difference;
    private final Scanner input =  new Scanner(System.in);

    public Climber() {
        System.out.println("Введите выносливость скалолаза (не менее трех):");
        this.stamina = input.nextInt();
        if (stamina < 3){
            stamina = 3;
        }

        System.out.println("Введите пиковую высоту скалолаза:");
        this.max_height = input.nextInt();
        if (max_height < 0){
            max_height = 0;
        }

        System.out.println("Введите максимальный перепад трех ближайших вершин:");
        this.height_difference = input.nextInt();
        if (height_difference < 0){
            height_difference = 0;
        }
        input.close();
    }

    public void createRoute(){
        int[] route = new int[stamina];

        route[0] = (int) (random()* min(height_difference,max_height)); // ST-10   MH-9   HD- 6
        route[1] = (int) (random()* min(route[0]+height_difference,max_height));
        System.out.println(route[0]);
        for(int i = 2; i < stamina; i++){
            route[i] = getNextPoint(route[i-2], route[i-1]);
            System.out.println(route[i]);
        }
    }

    private int getNextPoint(int prePrevious, int previous){
        int currentPoint;
        int twoPastPointsDifference = prePrevious - previous; //2
        int max_change = height_difference - abs(twoPastPointsDifference);  //4 0-10  сколько могу прибавить к макс из 2-х пред или отнять от мин..

        if(max(prePrevious, previous)+max_change>max_height){
            if(min(prePrevious, previous)-max_change<0){
                currentPoint =1;
                return currentPoint;
            }
            else{ // макс точка - лимит высоты скалолаза.
                currentPoint =1;
                return currentPoint;
            }
        }

        return 0;

    }


}
