package com.johnc;

public class Line implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Canvas canvas, String frame, int width) {
        String[] frameArray = frame.replace("\n", "").split("");
        StringBuilder sb = new StringBuilder();

        if (y1 == y2) {
            int firstCoordinate = width * y1 + x1;
            int secondCoordinate = width * y2 + x2;
            for (int i = firstCoordinate; i <= secondCoordinate; i++) {
                frameArray[i] = "X";
            }
        } else {
            if (y1 < y2) {
                drawLine(width, frameArray, y1, y2);
            } else {
                drawLine(width, frameArray, y2, y1);
            }
        }

        canvas.buildCanvas(frameArray, sb);
    }

    private void drawLine(int width, String[] frameArray, int y1, int y2) {
        for (int i = y1; i <= y2; i++) {
            int coordinate = width * i + x1;
            frameArray[coordinate] = "X";
        }
    }
}
