package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProvinceView extends AbstractView {

	private IProvince province;

	public ProvinceView(IProvince province) {
		super(Resource.getInstance().bucket, Resource.getInstance().bucket);
		this.province = province;
		setSize(imageUp.getWidth(), imageUp.getHeight());
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

		batch.setColor(Color.RED);
		batch.draw(isClicked ? imageDown : imageUp, getX(), getY(), getWidth(),
				getHeight());

		// TODO check if this works or if we should have a texture instead
		// if we choose texture then the default draw() in image should suffice
		// if this works then we don't need to be an Image and could just become
		// an Actor

		/*
		 * font.drawMultiLine(batch, "Country: " + province.getId() +
		 * "\nUnits: " + province.getUnits(), getCenterX() - (getWidth() / 3),
		 * getCenterY());
		 */
	}

	public IProvince getProvince() {
		return province;
	}
}
