package Climbers;

import java.util.Scanner;

import static java.lang.Math.min;
import static java.lang.Math.random;

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

        System.out.println("Введите максимальный перепад ближайших вершин:");
        this.height_difference = input.nextInt();
        if (height_difference < 0){
            height_difference = 0;
        }
    }

    public void createRoute(){
        int[] route = new int[stamina];

        route[0] = (int) (random()* min(height_difference,max_height)); // ST-10   MH-13   HD- 4    /  4 8
        System.out.println(route[0]);
        for(int i = 1; i < stamina; i++){
            route[i] = getNextPoint(i);
            System.out.println(route[i]);
        }
    }

    private int getNextPoint(int currentPosition){
        int twoPointDifference = 0;



        return 0;


    }

}
