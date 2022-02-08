package service;

import constant.MessageConstants;
import exception.IllegalMoveException;
import exception.IllegalPlacementException;
import exception.NotYetPlacedException;
import model.Coordinates;
import model.area.PlayArea;
import model.robot.Direction;
import model.robot.ToyRobot;
import utils.PlayAreaHelper;
import utils.ToyHelper;

import java.util.Scanner;

public class ToyAppService {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        displayInstructions();

        ToyRobot toyRobot = new ToyRobot();
        PlayArea playArea = PlayAreaHelper.getDefaultSquarePlayArea();
        toyRobot.setPlayArea(playArea);

        while (true) {

            System.out.println("-------------------");
            System.out.println("What is your COMMAND? ");
            String commandStr = scanner.nextLine().trim();

            if (commandStr.isEmpty()) {
                System.out.println("Command is Empty! Try again. ");
                continue;
            }

            if (commandStr.length() > 5) {
                if (commandStr.substring(0, 5).equalsIgnoreCase("PLACE")) {
                    String[] splitStr = commandStr.split("[\\s,]+");
                    try {
                        int x = Integer.parseInt(splitStr[1]);
                        int y = Integer.parseInt(splitStr[2]);
                        String direction = splitStr[3].toUpperCase();
                        toyRobot.place(new Coordinates(x, y), Direction.valueOf(direction), playArea);
                    } catch (IllegalPlacementException e) {
                        System.out.println(MessageConstants.CANNOT_PLACE_IGNORE);
                    } catch (IllegalArgumentException argEx) {
                        System.out.println("Invalid PLACE Command. Check PLACE arguments. ");
                    }
                    continue;
                } else if (commandStr.equalsIgnoreCase("REPORT")) {
                    if (toyRobot.isPlaced()) {
                        int x = toyRobot.getCoordinates().getX();
                        int y = toyRobot.getCoordinates().getY();
                        System.out.println("Robot is in (" + x + "," + y + ") facing " + toyRobot.getDirection());
                        draw(toyRobot);
                    } else {
                        System.out.println(MessageConstants.NOT_YET_PLACED_MESSAGE);
                    }
                    continue;
                }


            } else {
                if (commandStr.equalsIgnoreCase("MOVE")) {
                    try {
                        ToyHelper.move(toyRobot);
                    } catch (IllegalMoveException e) {
                        System.out.println(MessageConstants.CANNOT_MOVE_IGNORE);
                    } catch (NotYetPlacedException e) {
                        System.out.println(MessageConstants.NOT_PLACED_IGNORE);
                    }
                    continue;
                } else if (commandStr.equalsIgnoreCase("LEFT")
                        || commandStr.equalsIgnoreCase("L")) {
                    try {
                        ToyHelper.turnLeft(toyRobot);
                    } catch (NotYetPlacedException e) {
                        System.out.println(MessageConstants.NOT_PLACED_IGNORE);
                    }
                    continue;
                } else if (commandStr.equalsIgnoreCase("RIGHT") ||
                        commandStr.equalsIgnoreCase("R")) {
                    try {
                        ToyHelper.turnRight(toyRobot);
                    } catch (NotYetPlacedException e) {
                        System.out.println(MessageConstants.NOT_PLACED_IGNORE);
                    }
                    continue;
                }
            }

            System.out.println("Invalid Command. Please Try again. ");

        }


    }

    private void displayInstructions() {
        System.out.println("=============================================================");
        System.out.println("Welcome to ToyRobot App. COMMANDs available are: ");
        System.out.println("PLACE x,y,direction(choose one: NORTH, SOUTH, EAST, WEST). e.g. PLACE 0,1,NORTH");
        System.out.println("MOVE - to move one square in the current direction");
        System.out.println("LEFT - to turn 90 degrees left. e.g. LEFT or simply L");
        System.out.println("RIGHT - to turn 90 degrees right. e.g. RIGHT or simply R");
        System.out.println("REPORT - display toy robot status");
        System.out.println("All COMMANDS are case-insensitive");
        System.out.println("=============================================================");
    }

    private void draw(ToyRobot toyRobot) {
        int robotX = toyRobot.getCoordinates().getX();
        int robotY = toyRobot.getCoordinates().getY();

        //reverse y because the origin is
        for (int y = 4; y >= 0; y--) {
            System.out.print('|');

            for (int x = 0; x < 5; x++) {
                if(robotX==x && robotY==y){
                    switch(toyRobot.getDirection()){
                        case NORTH: System.out.print('^'); break;
                        case SOUTH: System.out.print('v'); break;
                        case EAST: System.out.print('>'); break;
                        case WEST: System.out.print('<'); break;
                    }
                }else{
                    System.out.print('_');
                }
                System.out.print('|');
            }
            System.out.println();
        }
    }
}
