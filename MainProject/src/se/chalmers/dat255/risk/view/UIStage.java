package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class UIStage extends AbstractStage {

	private ChangePhase phase;
	private SwitchButton card, stat;
	private Render render;
	private Label label;
	private ColorHandler color;
	private PopUp pop;
	private Message message;
	private ConfirmDialog confirm;
	private TextButton giveUp;
	private Table table, buttonTable;

	public UIStage(IGame model) {
		super(model);
		model.addListener(this);

		table = new Table();
		table.setFillParent(true);

		buttonTable = new Table();

		phase = new ChangePhase(model);
		others.add(phase);

		card = new SwitchButton(Render.Card);
		others.add(card);

		stat = new SwitchButton(Render.Stat);
		others.add(stat);

		render = Render.Map;

		color = ColorHandler.getInstance();

		label = new Label(model.getActivePlayer().getName() + "	\nPhase: "
				+ model.getCurrentPhase().getPhase(),
				Resource.getInstance().skin, "default-font", color.getColor(0));
		label.setFontScale(label.getFontScaleX() * 1.8f);// TODO magic number

		giveUp = new TextButton("Surrender", Resource.getInstance().skin);
		others.add(giveUp);

		pop = new PopUp("Title");
		others.add(pop);

		message = new Message("Title");
		others.add(message);

		confirm = new ConfirmDialog("Title");
		others.add(confirm);

		table.add(label).expandX().center();
		table.row().expandX().row();
		buttonTable.columnDefaults(0).expand().fill()
				.width(phase.getBoundWidth());
		buttonTable.add(giveUp).row();
		buttonTable.add(stat).height(Gdx.graphics.getHeight() / 9).row();
		buttonTable.add(card).height(Gdx.graphics.getHeight() / 9).row();
		buttonTable.add(phase).height(Gdx.graphics.getHeight() / 9).row();

		table.add().expand();
		table.add(buttonTable).bottom();
		// table.debug();

		addActor(table);
	}

	public void showPopUp(String title, String msg, int maxValue, int minValue) {
		pop.setSliderStop(minValue, maxValue);
		pop.setTexts(title, msg);
		pop.show(this);
	}

	public void showPopUp(String title, String msg) {
		if (title.equalsIgnoreCase("Surrender")) {
			confirm.setTexts(title, msg);
			confirm.show(this);
		} else {
			message.setTexts(title, msg);
			message.show(this);
		}
	}

	public Render getRender() {
		return render;
	}

	public void switchRender(Render render) {
		this.render = render;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String name = event.getPropertyName();
		if (name.equalsIgnoreCase(IGame.ATTACK)) {
			showPopUp(name, "How many dice \ndo you want?",
					(Integer) event.getOldValue(), 1);
		} else if (name.equalsIgnoreCase(IGame.MOVEMENT)) {
			showPopUp(name, "How many units do \nyou want to move?",
					(Integer) event.getOldValue() - 1, 1);
		} else if (name.equalsIgnoreCase("Again?")) {
			showPopUp(name, "Do you want \nto attack again?",
					(Integer) event.getOldValue(), 1);
		} else if (name.equalsIgnoreCase(IGame.CONQUER)) {
			showPopUp("Occupy", "How many units do \nyou want to move?",
					(Integer) event.getOldValue() - 1,
					Integer.parseInt((String) event.getNewValue()));
		} else if (name.equalsIgnoreCase(IGame.WIN)) {
			showPopUp("Congratz", "You have won!");
		} else if (name.equalsIgnoreCase(IGame.SURRENDER)) {
			showPopUp(name, "Are you sure you\n want to surrender?");
		} else if (name.equalsIgnoreCase(IGame.UNITS)) {
			showPopUp(name, "You must place all your units");
		} else if (name.equalsIgnoreCase(IGame.CARDS)) {
			showPopUp(name, "You must exchange your cards");
		}

	}

	@Override
	public void draw() {
		label.setText(model.getActivePlayer().getName() + "	\nPhase: "
				+ model.getCurrentPhase().getPhase());
		label.setColor(color.getColor(model.getActivePlayer().getId()));
		super.draw();
	}

	public enum Render {
		Card("Card", "Map"), Map(), Stat("Stat", "Map");
		private String s1, s2;

		Render() {
		}

		Render(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		public String[] getStrings() {
			return new String[] { s1, s2 };
		}

	};

}
