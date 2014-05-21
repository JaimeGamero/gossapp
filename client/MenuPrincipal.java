package gossapp.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.MenuBar;

public class MenuPrincipal extends Composite{
	
	public MenuPrincipal(Map<String, String> params){
		
		
		final DockPanel mainPanel = new DockPanel();
		initWidget(mainPanel);
		
		//Comandos para el cambio de vista
		Command cmdIni = new Command() {
		      public void execute() {
		        ViewHandler.go("inicio", new HashMap<String, String>());
		      }
		    };
		
		Command cmdDesa = new Command() {
			  public void execute() {
			    ViewHandler.go("desarrolladores", new HashMap<String, String>());
			  }
			};
		
		Command cmdInfo = new Command() {
			 public void execute() {
				ViewHandler.go("info", new HashMap<String, String>());
			 }
			};
		
			
		Command cmdApi = new Command() {
			 public void execute() {
				ViewHandler.go("api", new HashMap<String, String>());
				}
			};
			
		Command cmdBuscar = new Command() {
			public void execute() {
				ViewHandler.go("app", new HashMap<String, String>());
				}
			};

			//Menú de la parte superior (A cada uno se le añade un comando)
			MenuBar menu = new MenuBar();
		    menu.addItem("INICIO", cmdIni);
		    menu.addItem("APP", cmdBuscar);
		    menu.addItem("API", cmdApi);
		    menu.addItem("DESARROLLADORES", cmdDesa);
		    menu.addItem("INFORMACION", cmdInfo);

		    // Añadir al panel
		    mainPanel.add(menu, DockPanel.NORTH);
		    
		    mainPanel.setStyleName("content");
	}
}
