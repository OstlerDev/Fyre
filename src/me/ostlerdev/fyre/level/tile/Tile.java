package me.ostlerdev.fyre.level.tile;

import me.ostlerdev.fyre.graphics.Screen;
import me.ostlerdev.fyre.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile ocean = new OceanTile(Sprite.ocean);
	public static Tile sand = new SandTile(Sprite.sand);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	} 
}
