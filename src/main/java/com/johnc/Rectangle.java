package com.johnc;

public class Rectangle implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Canvas canvas, String frame, int width) {
        String[] frameArray = frame.replace("\n", "").split("");
        StringBuilder sb = new StringBuilder();

        int rectangleTopX = width * y1 + x1;
        int rectangleTopY = width * y1 + x2;
        drawRectangleTopBottom(frameArray, rectangleTopX, rectangleTopY);

        drawRectangleSides(frameArray, x1, y1, y2, width);
        drawRectangleSides(frameArray, x2, y1, y2, width);

        int rectangleBottomX = width * y2 + x1;
        int rectangleBottomY = width * y2 + x2;
        drawRectangleTopBottom(frameArray, rectangleBottomX, rectangleBottomY);

        canvas.buildCanvas(frameArray, sb);
    }

    private void drawRectangleTopBottom(String[] frameArray, int firstCoordinate, int secondCoordinate) {
        for (int i = firstCoordinate; i <= secondCoordinate; i++) {
            if (frameArray[i].equals("|") || frameArray[i].equals("-")) {
                i++;
                fillValidPositions(frameArray, i);
            } else {
                frameArray[i] = "X";
            }
        }
    }

    private void fillValidPositions(String[] frameArray, int coordinate) {
        if (frameArray[coordinate].equals("|") || frameArray[coordinate].equals("-")) {
            coordinate++;
            fillValidPositions(frameArray, coordinate);
        } else {
            frameArray[coordinate] = "X";
        }
    }

    private void drawRectangleSides(String[] frameArray, int x1, int y1, int y2, int width) {
        if (y1 < y2) {
            fillCanvas(frameArray, x1, y1, y2, width);
        } else {
            fillCanvas(frameArray, x1, y2, y1, width);
        }
    }

    private void fillCanvas(String[] frameArray, int x1, int y1, int y2, int width) {
        for (int i = y1; i <= y2; i++) {
            int coordinate = width * i + x1;
            if (frameArray[coordinate].equals("|") || frameArray[coordinate].equals("-")) {
                coordinate++;
                fillValidPositions(frameArray, coordinate);
            } else {
                frameArray[coordinate] = "X";
            }
        }
    }
}
