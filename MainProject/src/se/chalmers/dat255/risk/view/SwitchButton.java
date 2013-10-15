package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.UIStage.Render;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class SwitchButton extends TextButton {

	private final String first;
	private final String second;
	private Render render;

	public SwitchButton(Render render) {
		super("", Resource.getInstance().skin);
		this.render = render;
		first = render.getStrings()[0];
		second = render.getStrings()[1];
		
		setText(first);
	}

	public void switchText() {
		setText(("" + getText()).equals(first) ? second : first);
	}
	
	public Render getType(){
		return render;
	}

}
