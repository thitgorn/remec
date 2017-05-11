package touchyou.util;

import touchyou.App;
import touchyou.Command;
import touchyou.gui.ModelPanel;
import touchyou.gui.SettingPanel;
import touchyou.gui.WidgetPanel;

/**
 * A Controller class that contains every Panel's reference, in order to
 * communicate between each Panel. Every communication must be invoked using
 * this class.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Controller {
    private static Controller controller = new Controller();
    private App app;
    private SettingPanel settingPanel;
    private WidgetPanel widgetPanel;
    private ModelPanel modelPanel;
    private int id;

    /**
     * Update every panels to point at the same Command.
     * 
     * @param command
     *            is the command that is being dealt with
     */
    public void update(Command command) {
	settingPanel.update(command);
	widgetPanel.update(command);
	modelPanel.update(command);
    }

    /**
     * Add new Command to the profile.
     */
    public void addCommand() {
	/* Create new Command */
	Command command = new Command();
	command.setId(id++);
	app.getProfile().addCommand(command);
	/* notify other Panels */
	modelPanel.addCommand(command);
	widgetPanel.addCommand(command);
	update(command);
    }

    /**
     * Return an instance of the Controller.
     * 
     * @return Controller instance
     */
    public static Controller getInstance() {
	return controller;
    }

    public void setSettingPanel(SettingPanel settingPanel) {
	this.settingPanel = settingPanel;
    }

    public void setWidgetPanel(WidgetPanel widgetPanel) {
	this.widgetPanel = widgetPanel;
    }

    public void setModelPanel(ModelPanel modelPanel) {
	this.modelPanel = modelPanel;
    }

}
