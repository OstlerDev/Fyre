package me.ostlerdev.fyre;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Start extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Fyre";
	
	private Game game;

	public int xOffset = 0, yOffset = 0;

	private Thread gameThread;
	private JFrame frame;
	private boolean running = false;

	public Start() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		frame = new JFrame();
		
		game = new Game();
	}

	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		requestFocus();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				game.update();
				updates++;
				delta--;
			}
			game.render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}


	public static void main(String[] args) {
		Start start = new Start();
		start.frame.setResizable(false);
		start.frame.setTitle(Start.title);
		start.frame.add(start);
		start.frame.pack();
		start.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.frame.setLocationRelativeTo(null);
		start.frame.setVisible(true);

		start.start();
	}

}
