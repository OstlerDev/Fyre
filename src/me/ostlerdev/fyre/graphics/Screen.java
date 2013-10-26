package me.ostlerdev.fyre.graphics;

import me.ostlerdev.fyre.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 100;

	public Tile[] tiles = new Tile[MAP_SIZE * MAP_SIZE];

	public Screen(int w, int h) {
		width = w;
		height = h;

		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset) {
		/*
		 * for (int y = 0; y < height; y++) { int yp = y + yOffset; if (yp < 0
		 * || yp >= height) continue; for (int x = 0; x < width; x++) { int xp =
		 * x + xOffset; if (xp < 0 || xp >= width) continue;
		 * 
		 * renderImage(Sprite.grass.pixels, Sprite.grass.SIZE,
		 * Sprite.grass.SIZE, 15, 50); // pixels[xp + yp * width] =
		 * Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE]; } }
		 */
	}

	public void renderImage(int[] imagePixels, int pwidth, int pheight, int posX, int posY) {
		// Row rendering, do this for each row of the image
		for (int k = 0; k < pheight; k++) {
			// Now for each row we put in the row into the pixel array
			for (int i = 0; i < pwidth; i++) {
				pixels[posX + i + ((posY + k) * width)] = imagePixels[(k * pwidth) + i];
			}
		}

	}
}
