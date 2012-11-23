package me.ostlerdev.fyre.graphics;

import java.util.Random;

public class Screen {

	private int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	private Random r = new Random();

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int w, int h) {
		width = w;
		height = h;

		pixels = new int[width * height];

		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = r.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yy = y + yOffset;
			//if (yy >= height || yy < 0) break;
			for (int x = 0; x < width; x++) {
				int xx = x + xOffset;
				//if (xx >= width || xx < 0) break;
				int tileIndex = ((xx >> 4) & 63) + ((yy >> 4) & 63) * 64;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
}
