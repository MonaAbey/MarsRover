package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First enter the plateau coordinates :");
        String inputCoordinates = scanner.nextLine();
        int[] coordinates = new int[2];
        coordinates[0] = Integer.parseInt(inputCoordinates.split(" ")[0]) + 1;
        coordinates[1] = Integer.parseInt(inputCoordinates.split(" ")[1]) + 1;
        Rover[][] plateauCoordinates = new Rover[coordinates[0]][coordinates[1]];


        System.out.print("Now enter rover one position :");
        String inputR1Position = scanner.nextLine();
        int[] rover1Position = new int[2];
        rover1Position[0] = Integer.parseInt(inputR1Position.split(" ")[0]);
        rover1Position[1] = Integer.parseInt(inputR1Position.split(" ")[1]);
        String rover1Heading = inputR1Position.split(" ")[2];

        System.out.print("Enter the rover one instructions:");
        String rover1Instructions = scanner.nextLine();


        System.out.print("Now enter rover two position :");
        String inputR2Position = scanner.nextLine();
        int[] rover2Position = new int[2];
        String[] s = inputR2Position.split(" ");
        rover2Position[0] = Integer.parseInt(s[0]);
        rover2Position[1] = Integer.parseInt(s[1]);
        String rover2Heading = s[2];

        System.out.print("Enter the rover two instructions:");
        String rover2Instructions = scanner.nextLine();


        Rover r1 = new Rover();
        r1.setName("r1");
        r1.setInstructions(rover1Instructions);
        r1.setHeading(rover1Heading);
        r1.setCoordinates(rover1Position);

        Rover r2 = new Rover();
        r2.setName("r2");
        r2.setInstructions(rover2Instructions);
        r2.setHeading(rover2Heading);
        r2.setCoordinates(rover2Position);

        System.out.println("\n*****Output*****");

        RoverMovement roverMovement = new RoverMovement();
        roverMovement.move(r1, plateauCoordinates);
        System.out.println(r1.getCoordinates()[0] + " " + r1.getCoordinates()[1] + " " + r1.getHeading());
        roverMovement.move(r2, plateauCoordinates);
        System.out.println(r2.getCoordinates()[0] + " " + r2.getCoordinates()[1] + " " + r2.getHeading());

        System.out.println("\n*****Plateau and rover representation.*****");
        System.out.println("Bottom left corner is 0,0\n");

        for (int y = plateauCoordinates[0].length-1; y >=0 ; y--) {
            for (int x = 0; x < plateauCoordinates[1].length; x++) {
                if (plateauCoordinates[x][y] == null) {
                    System.out.print("*** ");
                } else {
                    System.out.print(plateauCoordinates[x][y].getName() + plateauCoordinates[x][y].getHeading() + " ");

                }
            }
            System.out.println();
        }



    }
}















