package com.flappy;

import com.flappy.util.ShaderUtils;

import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengl.GL20.glUseProgram;

public class Main implements Runnable {
    public Window window;

    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void run() {
        window = new Window(800, 600, "Flappy Bird");

        window.init();
        //Vertex array object
        int vao = glGenVertexArrays();
        glBindVertexArray(vao);

        int shader = ShaderUtils.load("src/shaders/shader.vert", "src/shaders/shader.frag");
        glUseProgram(shader);

        while (!window.shouldClose()) {
            window.render();
            window.update();
        }
        window.destroy();
    }
}
