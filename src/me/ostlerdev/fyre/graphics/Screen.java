package me.ostlerdev.fyre.graphics;

import java.util.Random;

import me.ostlerdev.fyre.level.tile.Tile;

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
			int yp = y + yOffset;
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xOffset;
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
			}
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
		}
	}
}
