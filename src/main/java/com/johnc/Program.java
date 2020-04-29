package com.johnc;

import java.util.Scanner;

public class Program {

    private CanvasService canvasService;

    public Program(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    public void execute() {
        System.out.print("enter command: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("Q")) {
            try {
                String[] inputArray = input.split(" ");
                if (inputArray.length == 3 && inputArray[0].equals("C")) {
                    int width = Integer.parseInt(inputArray[1]);
                    int height = Integer.parseInt(inputArray[2]);
                    canvasService.createCanvas(width, height);
                    String canvas = canvasService.getCanvas();
                    System.out.println(canvas);
                } else {
                    System.out.println("please enter the shape (\"C\", \"L\", R\") and the corresponding coordinates");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for each coordinate for the canvas");
            }

            System.out.print("enter command: ");
            Scanner sc2 = new Scanner(System.in);
            input = sc2.nextLine();
            String[] secondInputArray = input.split(" ");

            try {
                if (secondInputArray.length == 5) {
                    int x1 = Integer.parseInt(secondInputArray[1]);
                    int y1 = Integer.parseInt(secondInputArray[2]);
                    int x2 = Integer.parseInt(secondInputArray[3]);
                    int y2 = Integer.parseInt(secondInputArray[4]);
                    if (secondInputArray[0].equals("L")) {
                        canvasService.drawShape(new Line(x1, y1, x2, y2));
                    } else if (secondInputArray[0].equals("R")) {
                        canvasService.drawShape(new Rectangle(x1, y1, x2, y2));
                    }
                } else {
                    System.out.println("please enter the shape (\"C\", \"L\", R\") and the corresponding coordinates");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for each coordinate for the shape");
            }
        }
    }
}
