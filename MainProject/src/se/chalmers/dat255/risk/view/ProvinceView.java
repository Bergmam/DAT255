package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProvinceView extends AbstractView {

	private IProvince province;

	public ProvinceView(IProvince province) {
		super(Resource.getInstance().bucket, Resource.getInstance().bucket);
		this.province = province;
		setSize(width, height);
		setPosition(100, 100);
	}

	public float getCenterX() {
		return getX() + (getWidth() / 2);
	}

	public float getCenterY() {
		return getY() + (getWidth() / 2);
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		//color stuff is tmp untikl we get better images
		batch.setColor(isClicked? Color.RED : Color.BLUE);
		super.draw(batch, alpha);
		
	}

	public IProvince getProvince() {
		return province;
	}
}
