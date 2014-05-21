package gossapp.client;

import java.util.HashMap;

import java.util.Map;

import gossapp.client.ViewUser;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ViewHandler implements EntryPoint {

	public void onModuleLoad() {
		go("inicio", new HashMap<String, String>());
	}

	public static void go(String token, Map<String, String> params) {
		Panel p = RootPanel.get();
		p.clear();
		p.add(new MenuPrincipal(params));
		if (token == "app") {
			p.add(new ViewApp(params));
		} else {
			p.add(new ViewUser(params, token));
		}
	}

}
