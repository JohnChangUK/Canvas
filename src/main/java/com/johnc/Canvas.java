package com.johnc;

public class Canvas {

    private int width;
    private int height;
    private String frame;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawLine(Shape shape) {
        String trimmedFrame = frame.replace("\n", "");
        int x1 = shape.getX1();
        int y1 = shape.getY1();
        int x2 = shape.getX2();
        int y2 = shape.getY2();
        String[] frameArray = trimmedFrame.split("");
        StringBuilder sb = new StringBuilder();

        if (y1 == y2) {
            int firstCoordinate = width * y1 + x1;
            int secondCoordinate = width * y2 + x2;
            for (int i = firstCoordinate; i <= secondCoordinate; i++) {
                frameArray[i] = "X";
            }
        } else {
            if (y1 < y2) {
                for (int i = y1; i <= y2; i++) {
                    int coordinate = width * i + x1;
                    frameArray[coordinate] = "X";
                }
            } else {
                for (int i = y2; i <= y1; i++) {
                    int coordinate = width * i + x1;
                    frameArray[coordinate] = "X";
                }
            }
        }

        buildCanvas(frameArray, sb);
    }

    public void drawRectangle(Shape shape) {
        String[] frameArray = frame.replace("\n", "").split("");
        int x1 = shape.getX1();
        int y1 = shape.getY1();
        int x2 = shape.getX2();
        int y2 = shape.getY2();
        StringBuilder sb = new StringBuilder();

        int rectangleTopX = width * y1 + x1;
        int rectangleTopY = width * y1 + x2;
        drawRectangleTopBottom(frameArray, rectangleTopX, rectangleTopY);

        drawRectangleSides(frameArray, x1, y1, y2);
        drawRectangleSides(frameArray, x2, y1, y2);

        int rectangleBottomX = width * y2 + x1;
        int rectangleBottomY = width * y2 + x2;
        drawRectangleTopBottom(frameArray, rectangleBottomX, rectangleBottomY);

        buildCanvas(frameArray, sb);
    }

    private void buildCanvas(String[] frameArray, StringBuilder sb) {
        for (int i = 0; i < frameArray.length; i++) {
            if (i % width == 0 && i != 0) {
                sb.append("\n");
            }
            sb.append(frameArray[i]);
        }

        frame = sb.toString();
        System.out.println(sb);
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

    private void drawRectangleSides(String[] frameArray, int x1, int y1, int y2) {
        if (y1 < y2) {
            fillCanvas(frameArray, x1, y1, y2);
        } else {
            fillCanvas(frameArray, x1, y2, y1);
        }
    }

    private void fillCanvas(String[] frameArray, int x1, int y1, int y2) {
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

    public String getFrame() {
        return frame;
    }

    public int getWidth() {
        return width;
    }

    public void setFrame(StringBuilder canvas) {
        frame = canvas.toString();
    }
}
