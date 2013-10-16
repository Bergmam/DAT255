package se.chalmers.dat255.risk.view.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Resource {

	private static Resource instance;
	
	public TextureAtlas atlas = new TextureAtlas("pack/uiskin.atlas");

	public Skin skin = new Skin(Gdx.files.internal("pack/uiskin.json"));

	public Texture backGround = new Texture(
			Gdx.files.internal("Gfx/RiskMap1.png"));

	public Texture artillery = new Texture(Gdx.files.internal("Gfx/Cannon.png"));
	public Texture cavalry = new Texture(Gdx.files.internal("Gfx/Cavalry.png"));
	public Texture infantry = new Texture(Gdx.files.internal("Gfx/Soldier.png"));
	public Texture joker = new Texture(Gdx.files.internal("Gfx/Joker.png"));

	public Texture artillery2 = new Texture(
			Gdx.files.internal("Gfx/Cannon1.png"));
	public Texture cavalry2 = new Texture(
			Gdx.files.internal("Gfx/Cavalry1.png"));
	public Texture infantry2 = new Texture(
			Gdx.files.internal("Gfx/Soldier1.png"));
	public Texture joker2 = new Texture(Gdx.files.internal("Gfx/Joker1.png"));

	public Texture cardHolder = new Texture(
			Gdx.files.internal("Gfx/RiskCard.jpg"));

	public Texture circle = new Texture(Gdx.files.internal("Gfx/circle.png"));
	public Texture circleSelected = new Texture(
			Gdx.files.internal("Gfx/circleOutline.png"));
	
	public Texture border = new Texture(Gdx.files.internal("Gfx/border.png"));

	public FileHandle neighbours = Gdx.files.internal("Gfx/neighbours.txt");
	public FileHandle cords = Gdx.files.internal("Gfx/Cords.txt");
	public FileHandle continents = Gdx.files.internal("Gfx/continents.txt");
	public FileHandle missions = Gdx.files.internal("Gfx/missions_continents.txt");

	public String neighborsFile = neighbours.readString();
	public String continentsFile = continents.readString();
	public String missionsFile = missions.readString();

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

		atlas = new TextureAtlas("pack/uiskin.atlas");
		
		skin = new Skin(Gdx.files.internal("pack/uiskin.json"));

		backGround = new Texture(Gdx.files.internal("Gfx/RiskMap1.png"));

		artillery = new Texture(Gdx.files.internal("Gfx/Cannon.png"));
		cavalry = new Texture(Gdx.files.internal("Gfx/Cavalry.png"));
		infantry = new Texture(Gdx.files.internal("Gfx/Soldier.png"));
		joker = new Texture(Gdx.files.internal("Gfx/Joker.png"));

		artillery2 = new Texture(Gdx.files.internal("Gfx/Cannon.png"));
		cavalry2 = new Texture(Gdx.files.internal("Gfx/Cavalry1.png"));
		infantry2 = new Texture(Gdx.files.internal("Gfx/Soldier1.png"));
		joker2 = new Texture(Gdx.files.internal("Gfx/Joker1.png"));

		cardHolder = new Texture(Gdx.files.internal("Gfx/RiskCard.jpg"));

		circle = new Texture(Gdx.files.internal("Gfx/circle.png"));
		circleSelected = new Texture(
				Gdx.files.internal("Gfx/circleOutline.png"));
		
		border = new Texture(Gdx.files.internal("Gfx/border.png"));

		neighbours = Gdx.files.internal("Gfx/neighbours.txt");
		cords = Gdx.files.internal("Gfx/Cords.txt");
		continents = Gdx.files.internal("Gfx/continents.txt");
		missions = Gdx.files.internal("Gfx/missions_continents.txt");

		neighborsFile = neighbours.readString();
		continentsFile = continents.readString();
		missionsFile = missions.readString();

	}

	public void dispose() {
		skin.dispose();
		
		atlas.dispose();

		backGround.dispose();

		artillery.dispose();
		cavalry.dispose();
		infantry.dispose();
		joker.dispose();

		artillery2.dispose();
		cavalry2.dispose();
		infantry2.dispose();
		joker2.dispose();

		border.dispose();
		
		cardHolder.dispose();

		circle.dispose();
		circleSelected.dispose();

	}
}
