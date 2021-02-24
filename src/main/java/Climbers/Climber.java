package Climbers;

import java.util.Scanner;

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

        System.out.println("Введите максимальную крутость подъема:");
        this.height_difference = input.nextInt();
        if (height_difference < 0){
            height_difference = 0;
        }
    }



}
