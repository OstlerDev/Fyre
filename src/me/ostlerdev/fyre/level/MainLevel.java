package me.ostlerdev.fyre.level;

import java.util.Random;
import me.ostlerdev.fyre.Game;
import me.ostlerdev.fyre.level.tile.TileLoader;

public class MainLevel extends Level {
	
	private final Random random = new Random();

	public MainLevel(int width, int height) {
		super(width, height);
	}

	protected void generateLevel(){
		TileLoader mainMap = new TileLoader();
		tiles = mainMap.loadFromFile(Game.mapFilePath);
	}
}
