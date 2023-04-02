package me.ostlerdev.fyre.level.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileLoader {

	private BufferedImage map = null;
	private int[] mapPixels = null;
	private Tile[] mapTiles = null;

	public TileLoader() {
	}

	public Tile[] loadFromFile(String path) {
		try {
			File tileFile = new File(path);
			if(tileFile.exists() && tileFile.canRead() && !fileTile.isDirectory())
			{
				map = ImageIO.read(TileLoader.class.getResource(tileFile.getPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mapPixels = new int[map.getWidth()*map.getHeight()];
		
		map.getRGB(0, 0, map.getWidth(), map.getHeight(), mapPixels, 0, map.getWidth());
		
		mapTiles= new Tile[mapPixels.length];
		
		for (int i = 0; i < mapPixels.length; i++)
		{
			int mapPixel = mapPixels[i];
			switch(mapPixel)
			{
				case -16711681:
					mapTiles[i] = Tile.ocean;
					break;
				case -256:
					mapTiles[i] = Tile.sand;
					break;
				case -16711936:
					mapTiles[i] = Tile.grass;
					break;
				default:
					break;
			}
		}
		
		return mapTiles;
	}
}
