package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IProvince;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ProvinceView extends AbstractView {

	private Texture image;
	private Texture image2;
	private boolean checked = false;
	private IProvince province;

	public ProvinceView(Texture texture, Texture texture2, IProvince province) {
		image = texture;
		image2 = texture2;
		this.province = province;
		setSize(10,10);
		setColor(Color.GRAY);
	}

	public float getCenterX() {
		return getX() + (getWidth() / 2);
	}

	public float getCenterY() {
		return getY() + (getWidth() / 2);
	}

	// TODO should be handled in controller
	public void addUnits() {
		province.addUnits(1);
	}

	public void check() {
		// TODO replace with methods in IProvince
		checked = !checked;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {

		/*
		 * batch.setColor(color); batch.draw(checked ? image2 : image, getX(),
		 * getY(), getWidth(), getHeight());
		 */

		// TODO check if this works or if we should have a texture instead
		// if we choose texture then the default draw() in image should suffice
		// if this works then we don't need to be an Image and could just become
		// an Actor

		shape.begin(ShapeType.Filled);
		shape.setProjectionMatrix(batch.getProjectionMatrix());
		if (checked) {
			shape.setColor(Color.YELLOW);
			shape.circle(getCenterX(), getCenterY(), 12);
		}
		shape.setColor(getColor());
		shape.circle(10, 10, 10);
		shape.end();

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
