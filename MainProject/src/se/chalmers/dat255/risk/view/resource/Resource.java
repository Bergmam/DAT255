package se.chalmers.dat255.risk.view.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Resource {

	private static Resource instance;

	public TextureAtlas atlas = new TextureAtlas(
			Gdx.files.internal("pack/uiskin.atlas"));
	public Skin skin = new Skin(Gdx.files.internal("pack/uiskin.json"));

	public Texture backGround = new Texture(
			Gdx.files.internal("Gfx/RiskMap1.png"));
	public Texture cardStageBg2 = new Texture(
			Gdx.files.internal("Gfx/RiskMap.png"));

	public Texture artillery = new Texture(Gdx.files.internal("Gfx/Cannon.png"));
	public Texture cavalry = new Texture(Gdx.files.internal("Gfx/Cavalry.png"));
	public Texture infantry = new Texture(Gdx.files.internal("Gfx/Soldier.png"));
	public Texture joker = new Texture(Gdx.files.internal("Gfx/Joker.png"));
	
	public Texture artillery2 = new Texture(
			Gdx.files.internal("Gfx/Cannon.png"));
	public Texture cavalry2 = new Texture(
			Gdx.files.internal("Gfx/Cavalry1.png"));
	public Texture infantry2 = new Texture(
			Gdx.files.internal("Gfx/Soldier1.png"));
	public Texture joker2 = new Texture(Gdx.files.internal("Gfx/Joker1.png"));

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
		// skin.addRegions(atlas);

		backGround = new Texture(Gdx.files.internal("Gfx/RiskMap1.png"));
		
		artillery = new Texture(Gdx.files.internal("Gfx/Cannon.png"));
		cavalry = new Texture(Gdx.files.internal("Gfx/Cavalry.png"));
		infantry = new Texture(Gdx.files.internal("Gfx/Soldier.png"));
		joker = new Texture(Gdx.files.internal("Gfx/Joker.png"));
		
		artillery2 = new Texture(Gdx.files.internal("Gfx/Cannon.png"));
		cavalry2 = new Texture(Gdx.files.internal("Gfx/Cavalry1.png"));
		infantry2 = new Texture(Gdx.files.internal("Gfx/Soldier1.png"));
		joker2 = new Texture(Gdx.files.internal("Gfx/Joker1.png"));
		
		
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
