package com.johnc;

public class Main {

    public static void main(String[] args) {
        Program program = new Program(new CanvasService());
        program.execute();
    }
}
