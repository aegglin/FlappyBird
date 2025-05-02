package com.flappy;

public class Main implements Runnable {
    public Window window;


    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void run() {
        window = new Window(800, 600, "Flappy Bird");
        window.init();

        while (!window.shouldClose()) {
            window.update();
        }
        window.destroy();
    }
}
