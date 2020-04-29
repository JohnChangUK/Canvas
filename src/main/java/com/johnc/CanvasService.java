package com.johnc;

public class CanvasService {

    private Canvas canvas;

    public void createCanvas(int width, int height) {
        canvas = new Canvas(width, height);
    }

    public void drawShape(Shape shape) {
        if (shape instanceof Line) {
            canvas.drawLine(shape);
        } else if (shape instanceof Rectangle) {
            canvas.drawRectangle(shape);
        }
    }

    public String getCanvas() {
        StringBuilder canvasBuilder = new StringBuilder();
        StringBuilder canvasTop = new StringBuilder();
        StringBuilder canvasMiddle = new StringBuilder();
        StringBuilder canvasBottom = new StringBuilder();
        StringBuilder spaces = new StringBuilder();

        // Construct Top of the canvas
        for (int i = 0; i < 20; i++) {
            canvasTop.append("-");
            canvasBottom.append("-");
            spaces.append(" ");
        }

        int spacesLength = spaces.length();
        spaces.setCharAt(0, '|');
        spaces.setCharAt(spacesLength - 1, '|');
        for (int i = 0; i < 5; i++) {
            canvasMiddle.append(spaces);
            canvasMiddle.append("\n");
        }

        canvasBuilder.append(canvasTop);
        canvasBuilder.append("\n");
        canvasBuilder.append(canvasMiddle);
        canvasBuilder.append(canvasBottom);

        canvas.setFrame(canvasBuilder);
        return canvas.getFrame();
    }
}
