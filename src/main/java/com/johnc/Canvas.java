package com.johnc;

public class Canvas {

    private int width;
    private int height;
    private String frame;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void buildCanvas(String[] frameArray, StringBuilder sb) {
        for (int i = 0; i < frameArray.length; i++) {
            if (i % width == 0 && i != 0) {
                sb.append("\n");
            }
            sb.append(frameArray[i]);
        }

        frame = sb.toString();
        System.out.println(sb);
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
