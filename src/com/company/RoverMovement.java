package com.company;

import java.util.HashMap;
import java.util.Map;

public class RoverMovement {
    public void move(Rover rover, Rover[][] plateauCoordinates) {
        String instructions = rover.getInstructions();
        Map<String, String> linstructions = new HashMap<>();
        Map<String, String> rinstructions = new HashMap<>();

        linstructions.put("N", "W");
        linstructions.put("W", "S");
        linstructions.put("S", "E");
        linstructions.put("E", "N");

        rinstructions.put("N", "E");
        rinstructions.put("E", "S");
        rinstructions.put("W", "N");
        rinstructions.put("S", "W");

        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = rover;
        try {


            for (int i = 0; i < instructions.length(); i++) {
                char instruction = instructions.charAt(i);
                if (instruction == 'L') {
                    rover.setHeading(linstructions.get(rover.getHeading()));
                } else if (instruction == 'R') {
                    rover.setHeading(rinstructions.get(rover.getHeading()));
                } else if (instruction == 'M') {
                    if (rover.getHeading().equals("N")) {
                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = null;
                        int[] coordinates = rover.getCoordinates();
                        coordinates[1] = coordinates[1] + 1;
                        rover.setCoordinates(coordinates);

                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = rover;
                    }
                    if (rover.getHeading().equals("E")) {
                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = null;
                        int[] coordinates = rover.getCoordinates();
                        coordinates[0] = coordinates[0] + 1;
                        rover.setCoordinates(coordinates);

                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = rover;
                    }
                    if (rover.getHeading().equals("W")) {
                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = null;
                        int[] coordinates = rover.getCoordinates();
                        coordinates[0] = coordinates[0] - 1;
                        rover.setCoordinates(coordinates);

                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = rover;
                    }
                    if (rover.getHeading().equals("S")) {
                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = null;
                        int[] coordinates = rover.getCoordinates();
                        coordinates[1] = coordinates[1] - 1;
                        rover.setCoordinates(coordinates);

                        plateauCoordinates[rover.getCoordinates()[0]][rover.getCoordinates()[1]] = rover;
                    }
                } else {
                    System.out.println("INVALID INSTRUCTION");
                    break;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

            System.out.println("Unable to move following position.");
        }
    }

}



