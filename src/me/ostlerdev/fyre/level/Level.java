package me.ostlerdev.fyre.level;

import me.ostlerdev.fyre.graphics.Screen;
import me.ostlerdev.fyre.level.tile.Tile;
import me.ostlerdev.fyre.level.tile.TileLoader;

public class Level {

	protected int width, height;
	protected Tile[] tiles;
	public int[] levelPixels;
	public final int MAP_SIZE = 100;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width * height];
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {
	}

	private void loadLevel(String path) {
		TileLoader mainMap = new TileLoader();
		tiles = mainMap.loadFromFile(path);
		
		for (int y = 0; y < MAP_SIZE; y++)
			for (int x = 0; x <  MAP_SIZE; x++) {
				renderTile(y, x, tiles[x*y]);
			}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		System.out.println(tile);
		if (tile == null) return;
		renderImage(tile.sprite.pixels, tile.sprite.SIZE, tile.sprite.SIZE, xp * tile.sprite.SIZE, yp * tile.sprite.SIZE);
		/*
		 * for (int y = 0; y < tile.sprite.SIZE; y++) { int ya = y + yp; for (int x = 0; x < tile.sprite.SIZE; x++)
		 * { 
		 * 	int xa = x + xp;
		 *  if (xa < 0 || xa >= width || ya < 0 || ya >= height) break;
		 *   pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
		 *    }
		 *     }
		 */
	}

	public void renderImage(int[] imagePixels, int pwidth, int pheight, int posX, int posY) {
		// Row rendering, do this for each row of the image
		for (int k = 0; k < pheight; k++) {
			// Now for each row we put in the row into the pixel array
			for (int i = 0; i < pwidth; i++) {
				levelPixels[posX + i + ((posY + k) * width)] = imagePixels[(k * pwidth) + i];
			}
		}

	}

	public void update() {
	}

	private void time() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
	}
}
