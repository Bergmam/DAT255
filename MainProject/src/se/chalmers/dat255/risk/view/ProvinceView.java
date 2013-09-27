package se.chalmers.dat255.risk.view;


import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProvinceView extends AbstractView {

	private IProvince province;

	public ProvinceView(IProvince province, int x, int y) {
		super(Resource.getInstance().bucket, Resource.getInstance().bucket);
		this.province = province;
		setSize(width, height);
		setPosition(x, y);
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
		java.awt.Color color =java.awt.Color.getColor(province.getColor());
		
		//batch.setColor(new Color(c));
		batch.draw(isClicked? imageUp : imageDown, getX(), getY(), width/2,height/2);
		super.draw(batch, alpha);
		
	}

	public IProvince getProvince() {
		return province;
	}
}
