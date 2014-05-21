package gossapp.client;

import java.util.Map;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

public class ViewUser extends Composite {

	public ViewUser(Map<String, String> params, String opcion) {
		final DockPanel mainPanel = new DockPanel();
		initWidget(mainPanel);

		// OCULTAR DIVs del HTML
		DOM.getElementById("textoDesarrolladores").getStyle()
				.setDisplay(Display.NONE);
		DOM.getElementById("textoInicio").getStyle()
				.setDisplay(Display.NONE);
		DOM.getElementById("textoApi").getStyle()
				.setDisplay(Display.NONE);
		DOM.getElementById("textoInfo").getStyle()
				.setDisplay(Display.NONE);
		
		
		//Según el parámetro 'opcion' que se indique se muestra una u otra
		if (opcion == "inicio") {
			DOM.getElementById("textoInicio").getStyle()
					.setDisplay(Display.BLOCK);
		} else if (opcion == "desarrolladores") {
			DOM.getElementById("textoDesarrolladores").getStyle()
					.setDisplay(Display.BLOCK);
		} else if (opcion == "info") {
			DOM.getElementById("textoInfo").getStyle()
					.setDisplay(Display.BLOCK);
		} else if (opcion == "api") {
			DOM.getElementById("textoApi").getStyle()
					.setDisplay(Display.BLOCK);
		}

	}

}
