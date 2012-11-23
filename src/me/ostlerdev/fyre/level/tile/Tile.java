package me.ostlerdev.fyre.level.tile;

import me.ostlerdev.fyre.graphics.Screen;
import me.ostlerdev.fyre.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}

}
