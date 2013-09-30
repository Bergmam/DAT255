package se.chalmers.dat255.risk.view.resource;

import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class Resource {

	private static Resource instance;

	public Texture backGround = new Texture(
			Gdx.files.internal("Gfx/RiskMap1.png"));
	public Texture cardStageBg2 = new Texture(
			Gdx.files.internal("Gfx/RiskMap.png"));
	public Texture card1 = new Texture(Gdx.files.internal("Gfx/card1.png"));
	public Texture card2 = new Texture(Gdx.files.internal("Gfx/card1.png"));
	public Texture card3 = new Texture(Gdx.files.internal("Gfx/card3.jpg"));
	public Texture diamond = new Texture(Gdx.files.internal("Gfx/diamond.png"));
	public Texture cardHolder = new Texture(
			Gdx.files.internal("Gfx/RiskCard.jpg"));
	public Texture circle = new Texture(Gdx.files.internal("Gfx/circle3.png"));
	public Texture triangle = new Texture(
			Gdx.files.internal("Gfx/triangle.png"));
	public FileHandle neighbours = Gdx.files.internal("Gfx/neighbours.txt");
	public FileHandle cords = Gdx.files.internal("Gfx/Cords.txt");
	public FileHandle continents = Gdx.files.internal("Gfx/continents.txt");

	public String neighborsFile = neighbours.readString();
	public String continentsFile = continents.readString();

	public static Resource getInstance() {
		if (instance == null) {
			instance = new Resource();
		}
		return instance;
	}

	public Resource() {
		loadResources();
	}

	public void loadResources() {
		backGround = new Texture(Gdx.files.internal("Gfx/RiskMap1.png"));
		card1 = new Texture(Gdx.files.internal("Gfx/card1.png"));
		card2 = new Texture(Gdx.files.internal("Gfx/card1.png")); // Will be
																	// card2
																	// later.
		card3 = new Texture(Gdx.files.internal("Gfx/card3.jpg"));
		diamond = new Texture(Gdx.files.internal("Gfx/diamond.png"));
		cardHolder = new Texture(Gdx.files.internal("Gfx/RiskCard.jpg"));
		circle = new Texture(Gdx.files.internal("Gfx/circle3.png"));
		triangle = new Texture(Gdx.files.internal("Gfx/triangle.png"));
		neighbours = Gdx.files.internal("Gfx/neighbours.txt");
		cords = Gdx.files.internal("Gfx/Cords.txt");
		continents = Gdx.files.internal("Gfx/continents.txt");

		neighborsFile = neighbours.readString();
		continentsFile = continents.readString();

	}

	public void dispose() {
		backGround.dispose();
	}
}
