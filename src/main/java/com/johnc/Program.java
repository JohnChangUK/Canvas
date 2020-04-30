package com.johnc;

import java.util.Scanner;

public class Program {

    private CanvasService canvasService;
    private String canvas;

    public Program(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    public void execute() {
        System.out.print("enter command: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("Q")) {
            if (canvas == null) {
                input = drawCanvas(sc, input);
            } else {
                System.out.print("enter command: ");
                input = sc.nextLine();
                String[] secondInputArray = input.split(" ");
                if (input.equals("Q")) {
                    break;
                }
                drawShape(secondInputArray);
            }
        }

        System.out.println("Program terminated");
    }

    private void drawShape(String[] secondInputArray) {
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

    private String drawCanvas(Scanner sc, String input) {
        try {
            String[] inputArray = input.split(" ");
            if (inputArray.length == 3 && inputArray[0].equals("C")) {
                int width = Integer.parseInt(inputArray[1]);
                int height = Integer.parseInt(inputArray[2]);
                canvasService.createCanvas(width, height);
                canvas = canvasService.getCanvas();
                System.out.println(canvas);
            } else {
                System.out.println("please enter the shape (\"C\", \"L\", R\") and the corresponding coordinates");
                System.out.print("enter command: ");
                input = sc.nextLine();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for each coordinate for the canvas");
        }
        return input;
    }
}
