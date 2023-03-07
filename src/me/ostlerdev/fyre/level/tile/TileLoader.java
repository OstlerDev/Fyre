package me.ostlerdev.fyre.level.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;

public class TileLoader {

	private BufferedImage map = null;
	private int[] mapPixels = null;
	private Tile[] mapTiles = null;

	public TileLoader(Tile[] array) {
		
		array = loadFromFile("/maps/mapTest.png");

	}

	public Tile[] loadFromFile(String path) {
		try {
			if(new File(path).exists())
				map = ImageIO.read(TileLoader.class.getResource(path));
			else
				throw new IOException("File existence check failed before attempting to read the file on: " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mapPixels = new int[map.getWidth()*map.getHeight()];
		
		map.getRGB(0, 0, map.getWidth(), map.getHeight(), mapPixels, 0, map.getWidth());
		
		mapTiles= new Tile[mapPixels.length];
		
		for (int i = 0; i < mapPixels.length; i++){
			//if (mapPixels[i] != -16711681) System.out.println(mapPixels[i]);
			//Ocean Tile
			if (mapPixels[i] == -16711681) mapTiles[i] = Tile.ocean;
			//Sand Tile
			if (mapPixels[i] == -256) mapTiles[i] = Tile.sand;
			//Grass Tile
			if (mapPixels[i] == -16711936) mapTiles[i] = Tile.grass;
		}
		
		return mapTiles;
	}
}
