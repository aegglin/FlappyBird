package com.flappy;

import com.flappy.util.ShaderUtils;

import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Main implements Runnable {
    public Window window;

    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void run() {
        window = new Window(800, 600, "Flappy Bird");

//        int shader = ShaderUtils.load("shaders/shader.vert", "shaders/shader.frag");

        window.init();
        //Vertex array object
        int vao = glGenVertexArrays();
        glBindVertexArray(vao);

        int shader = ShaderUtils.load("shaders/shader.vert", "shaders/shader.frag");
        glUseProgram(shader);

        while (!window.shouldClose()) {
            window.render();
            window.update();
        }
        window.destroy();
    }
}
