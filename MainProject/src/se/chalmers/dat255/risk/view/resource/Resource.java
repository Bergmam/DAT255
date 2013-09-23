package se.chalmers.dat255.risk.view.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Resource {

	private static Resource instance;
	
	public Texture backGround = new Texture(Gdx.files.internal("Gfx/RiskMap.png"));
			
	public static Resource getInstance(){
		if(instance == null){
			instance = new Resource();
		}
		return instance;
	}
	
	public Resource(){
		loadResources();
	}
	
	public void loadResources(){
		
	}
}
