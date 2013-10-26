package me.ostlerdev.fyre;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import me.ostlerdev.fyre.graphics.Screen;
import me.ostlerdev.fyre.input.Keyboard;
import me.ostlerdev.fyre.level.Level;
import me.ostlerdev.fyre.level.MainLevel;

public class Game extends Canvas{

	private static final long serialVersionUID = 3370105497890777468L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private Level currentLevel;
	private Keyboard key;
	private Screen screen;
	private JFrame frame;
	
	private BufferStrategy bs;
	
	public int xOffset = 0, yOffset = 0;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game(){
		currentLevel = new MainLevel(0, 0);
		key = new Keyboard();
		frame = new JFrame();

		addKeyListener(key);
		
		screen = new Screen(width, height);
	}
	
	public void update() {
		key.update();
		if (key.up) yOffset--;
		if (key.down) yOffset++;
		if (key.left) xOffset--;
		if (key.right) xOffset++;
	}
	
	public void render() {
		bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		screen.render(xOffset, yOffset);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		// start graphics
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		// end graphics
		g.dispose();
		bs.show();
	}
}
