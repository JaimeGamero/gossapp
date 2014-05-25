package gossapp.client;

import gossapp.client.services.FacebookAuthenticatedService;
import gossapp.client.services.FacebookAuthenticatedServiceAsync;
import gossapp.client.services.InstagramAuthenticatedService;
import gossapp.client.services.InstagramAuthenticatedServiceAsync;
import gossapp.client.services.TwitterAuthenticatedService;
import gossapp.client.services.TwitterAuthenticatedServiceAsync;
import gossapp.shared.domain.facebook.Data;
import gossapp.shared.domain.facebook.FacebookPhoto;
import gossapp.shared.domain.facebook.Images;
import gossapp.shared.domain.instaFeed.FeedData;
import gossapp.shared.domain.instaFeed.InstaFeed;
import gossapp.shared.domain.instaInfo.InstaInfo;

import java.util.Iterator;
import java.util.Map;

import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;

public class ViewApp extends Composite {

	// Inicialización de los servicios
	private final TwitterAuthenticatedServiceAsync twitterService = GWT
			.create(TwitterAuthenticatedService.class);
	private final FacebookAuthenticatedServiceAsync facebookService = GWT
			.create(FacebookAuthenticatedService.class);
	private final InstagramAuthenticatedServiceAsync instagramService = GWT
			.create(InstagramAuthenticatedService.class);

	// Inicializacion de la vista
	final DockPanel mainPanel = new DockPanel();

	// Elementos de twitter
	private final FlexTable tweetsTable;

	// Elementos de Facebook
	private static final Auth AUTH = Auth.get();
	final Label labelAccessTokenFace = new Label("");
	final FlowPanel menuFacebook;

	// Elementos de Instagram
	private static final Auth AUTH2 = Auth.get();
	final Label labelAccessTokenInsta = new Label("");
	
	//Elementos Generales
	private Button botonTwitter = new Button("Compartir en Twitter");
	private Button botonFace = new Button("Compartir en Facebook");
	private FlowPanel fotos = new FlowPanel();
	private HTML res = new HTML("");
	private FlowPanel fotosFace = new FlowPanel();
	private Button botonTwitter2 = new Button("Compartir en Twitter");
	private Button botonFace2 = new Button("Compartir en Facebook");
	
	public ViewApp(Map<String, String> params) {
		// Parámetros para registro en Facebook
		final String FACEBOOKAUTH_URL = "https://www.facebook.com/dialog/oauth";
		final String FACEBOOKCLIENT_ID = "1479269382295100";
//		final String FACEBOOK_SCOPE = "read_stream";
		final String FACEBOOK_SCOPE_PHOTOS = "user_photos";
//		final String FACEBOOK_SCOPE_PUBLISHED = "publish_";
		// Parámentros para registro en Instagram
		final String INSTAGRAM_ID = "d748330bec874eafbc13498f87ee30e0";
		final String REDIRECT_URI = "http://goss-app.appspot.com/pruebas/oauthWindow.html";
		final String INSTAGRAMAUTH_URL = "https://api.instagram.com/oauth/authorize/?client_id="
				+ INSTAGRAM_ID
				+ "&redirect_uri="
				+ REDIRECT_URI
				+ "&response_type=code";
		final String INSTAGRAM_SCOPE = "basic";

		// Inicializar panel principal
		initWidget(mainPanel);
		botonTwitter.addStyleName("btnCT");
		botonTwitter.setVisible(false);
		botonFace.addStyleName("btnCF");
		botonFace.setVisible(false);

		// OCULTAR DIVs del HTML
		DOM.getElementById("textoDesarrolladores").getStyle()
				.setDisplay(Display.NONE);
		DOM.getElementById("textoInicio").getStyle().setDisplay(Display.NONE);
		DOM.getElementById("textoApi").getStyle().setDisplay(Display.NONE);
		DOM.getElementById("textoInfo").getStyle().setDisplay(Display.NONE);

		// Panel de busqueda

		// MENU TWITTER
		FlowPanel menuTwitter = new FlowPanel();
		Button botonRT = new Button("Iniciar Sesi&oacuten");
		botonRT.addStyleName("btnRT");
		botonRT.addClickHandler(new ClickHandler() { // INICIO DE SESIÓN
			@Override
			public void onClick(ClickEvent event) {
				twitterService.inicioSesion(new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						Window.alert("Ha iniciado seisi&oacuten correctamente.");
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error: " + caught.getMessage());

					}
				});
			}
		});

		Button botonFAV = new Button("Timeline de Twitter");
		botonFAV.addStyleName("btnFAV");
		botonFAV.addClickHandler(new ClickHandler() { // TIMELINE

			@Override
			public void onClick(ClickEvent event) {
				twitterService.getTimeLine(10,
						new AsyncCallback<Map<String, String>>() {

							@Override
							public void onFailure(Throwable caught) {
							}

							@Override
							public void onSuccess(Map<String, String> result) {
								showTweets(result);
							}
						});
			}
		});

		Image logo_twitter = new Image();
		logo_twitter.setUrl("../img/twitter_logo.png");
		logo_twitter.setWidth("200px");
		logo_twitter.setStyleName("logo");
		menuTwitter.add(logo_twitter);
		menuTwitter.add(botonRT);
		menuTwitter.add(botonFAV);
		tweetsTable = new FlexTable();
		menuTwitter.add(tweetsTable);

		// MENU FACEBOOK
		menuFacebook = new FlowPanel();
		final Label labelFB = new Label("");
		Button botonLike = new Button("Iniciar Sesi&oacuten");
		botonLike.addStyleName("btnLike");
		botonLike.addClickHandler(new ClickHandler() {
			
			
			
			public void onClick(ClickEvent event) {
				

				
				final AuthRequest req = new AuthRequest(FACEBOOKAUTH_URL,
						FACEBOOKCLIENT_ID).withScopes(FACEBOOK_SCOPE_PHOTOS);
				AUTH.login(req, new Callback<String, Throwable>() {

					@Override
					public void onSuccess(String result) {
						labelAccessTokenFace.setText(result);

					}

					@Override
					public void onFailure(Throwable reason) {

					}
				});

			}
		});

//		Button botonComent = new Button("Lista de Amigos");
//		botonComent.addStyleName("btnComment");
//		botonComent.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				if (labelAccessTokenFace.getText() == "")
//					Window.alert("Please, login before getting post with more likes");
//				else {
//					facebookService.findFriends(labelAccessTokenFace.getText(),
//							new AsyncCallback<FacebookFriends>() {
//
//								@Override
//								public void onSuccess(FacebookFriends result) {
//									showFriends(result);
//								}
//
//								@Override
//								public void onFailure(Throwable caught) {
//
//								}
//							});
//				}
//			}
//		});
//////////////////////////////////////////////////////////////////////
		Button botonPrueba = new Button("Prueba");
		botonPrueba.addStyleName("btnComment");
		botonPrueba.addClickHandler(new ClickHandler() {

			@Override
		public void onClick(ClickEvent event) {
				
				fotosFace.clear();
				
				
				final AuthRequest req = new AuthRequest(FACEBOOKAUTH_URL,
						FACEBOOKCLIENT_ID).withScopes(FACEBOOK_SCOPE_PHOTOS);
				AUTH.login(req, new Callback<String, Throwable>() {

					@Override
					public void onSuccess(String result) {
						labelAccessTokenFace.setText(result);
						facebookService.findPhoto(labelAccessTokenFace.getText(),
								new AsyncCallback<FacebookPhoto>(){

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										Window.alert("no funciona");
									}

									@Override
									public void onSuccess(FacebookPhoto result) {
										
										showFeed(result);
										botonTwitter2.setVisible(true);
										botonFace2.setVisible(true);
									}
							
						});

					}

					@Override
					public void onFailure(Throwable reason) {

					}
				});

			}
		});
		Image logo_face = new Image();
		logo_face.setUrl("../img/face_logo.png");
		logo_face.setWidth("200px");
		logo_face.setStyleName("logo");
		menuFacebook.add(logo_face);
		menuFacebook.add(botonLike);
		menuFacebook.add(botonPrueba);
		menuFacebook.add(labelFB);

		// MENU INSTAGRAM
		FlowPanel menuInstagram = new FlowPanel();
		Button botonLike2 = new Button("Foto con mas Likes");
		botonLike2.addStyleName("btnLike2");

		botonLike2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				final AuthRequest req = new AuthRequest(INSTAGRAMAUTH_URL,
						INSTAGRAM_ID).withScopes(INSTAGRAM_SCOPE);
				AUTH2.login(req, new Callback<String, Throwable>() {

					@Override
					public void onFailure(Throwable reason) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						labelAccessTokenInsta.setText(result);

						instagramService.getFeed(
								labelAccessTokenInsta.getText(),
								new AsyncCallback<InstaFeed>() {

									@Override
									public void onFailure(Throwable caught) {

										Window.alert("Esto no Funciona");
									}

									@Override
									public void onSuccess(final InstaFeed feed) {
										fotos.clear();
										procesaFotos(feed, "likes");
										botonTwitter.setVisible(true);
										botonFace.setVisible(true);

									}
								});

					}

				});
			}
		});

		Button botonComment2 = new Button("Foto con mas Comentarios");
		botonComment2.addStyleName("btnComment2");
		
		botonComment2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				final AuthRequest req = new AuthRequest(INSTAGRAMAUTH_URL,
						INSTAGRAM_ID).withScopes(INSTAGRAM_SCOPE);
				AUTH2.login(req, new Callback<String, Throwable>() {

					@Override
					public void onFailure(Throwable reason) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						labelAccessTokenInsta.setText(result);

						instagramService.getFeed(
								labelAccessTokenInsta.getText(),
								new AsyncCallback<InstaFeed>() {

									@Override
									public void onFailure(Throwable caught) {

										Window.alert("Esto no Funciona");
									}

									@Override
									public void onSuccess(final InstaFeed feed) {
										fotos.clear();
										procesaFotos(feed, "comments");
										botonTwitter.setVisible(true);
										botonFace.setVisible(true);

									}
								});

					}

				});
			}
		});

		
		Image logo_insta = new Image();
		logo_insta.setUrl("../img/insta_logo.jpg");
		logo_insta.setWidth("200px");
		logo_insta.setStyleName("logo");
		menuInstagram.add(logo_insta);
		menuInstagram.add(botonLike2);
		menuInstagram.add(botonComment2);
		menuInstagram.add(fotos);

		// PESTAÑAS
		// Pestaña twitter
		FlowPanel fp = new FlowPanel();
		fp.addStyleName("fp");
		final Image image = new Image();
		image.setUrl("../img/twitter2.png");
		image.addStyleName("img");
		Label lbl_twitter = new Label("Twitter");
		lbl_twitter.addStyleName("lbl_twitter");
		fp.add(image);
		fp.add(lbl_twitter);

		// Pestaña Facebook
		FlowPanel fp2 = new FlowPanel();
		fp2.addStyleName("fp2");
		final Image image2 = new Image();
		image2.setUrl("../img/face.png");
		image2.addStyleName("img");
		Label lbl_facebook = new Label("Facebook");
		lbl_facebook.addStyleName("lbl_twitter");
		fp2.add(image2);
		fp2.add(lbl_facebook);

		// Pestaña Instagram
		FlowPanel fp3 = new FlowPanel();
		fp3.addStyleName("fp3");
		final Image image3 = new Image();
		image3.setUrl("../img/insta.png");
		image3.addStyleName("img");
		Label lbl_insta = new Label("Instagram");
		lbl_insta.addStyleName("lbl_twitter");
		fp3.add(image3);
		fp3.add(lbl_insta);

		// Creación del Menú de pestañas
		TabPanel panelBuscar = new TabPanel();
		panelBuscar.add(menuTwitter, fp);
		panelBuscar.add(menuFacebook, fp2);
		panelBuscar.add(menuInstagram, fp3);
		// Muestra inicialmente el menu TWITTER
		panelBuscar.selectTab(0);

		// Añadir al panel
		mainPanel.add(panelBuscar, DockPanel.CENTER);

		mainPanel.setStyleName("content");

	}

	void showTweets(Map<String, String> result) {
		int i = 0;
		tweetsTable.setWidget(0, 0, new Label("Usuario"));
		tweetsTable.setWidget(0, 1, new Label("Tweet"));
		if (result != null) {
			Iterator<String> it = result.values().iterator();
			for (String s : result.keySet()) {
				tweetsTable.setWidget(i + 1, 0, new Label(s));
				tweetsTable.setWidget(i + 1, 1, new Label(it.next()));
				i++;
			}
		}
	}

//	void showFriends(FacebookFriends result) {
//		String output = "<fieldset>";
//		output += "<legend>Amigos de Facebook</legend>";
//		if (result != null) {
//			for (Data a : result.getData()) {
//				output += "<span>" + a.getName() + "</span><br/>";
//			}
//		} else {
//			output = "<span> No tienes Amigos!!! -> Es bastante triste :( </span>";
//		}
//		output += "</fieldset>";
//		HTML friends = new HTML(output);
//		menuFacebook.add(friends);
//	}
	
	void showFeed(FacebookPhoto result){
		String img = "";
		Integer likes = 0;
		String error= "";
		try{
			for(Data d : result.getData()){
				if(d.getLikes().getData().size()>likes){
					likes = d.getLikes().getData().size();
					for(Images i : d.getImages()){
						img = i.getSource();
						break;
					}
				}
			}
			
		}catch(Exception e){
			error = "No se ha podido realizar la operacion";
		}
		
		String photoRes = "<span><h2>Esta es tu foto con m&aacute;s likes con "+likes+" likes:</h2></span>";
		photoRes+="<img width='640' class='imgRes' src='"+img+"'>";
		
		res = new HTML(photoRes);
		fotosFace.add(res);
	}

	void showInfo(InstaInfo result) {
		String output = "<fieldset>";
		output += "<legend>Información de tu perfil</legend>";
		if (result != null) {
			output += "<span><img src='"
					+ result.getData().getProfile_picture() + "'>";
		} else {
			output = "<span> Algo no va bien a la hora de mostrar tus datos </span>";
		}
		output += "</fieldset>";
		HTML info = new HTML(output);
		fotos.add(info);
	}

	void procesaFotos(InstaFeed feed, String op) {
		FeedData foto = feed.getData().get(0);
		String img = "";
		String output;
		if (op.equals("likes")) {
			output = "<span><h2>Esta es tu foto con más Likes:</h2><br/>";
			for (FeedData fd : feed.getData()) {
				if (fd.getLikes().getCount() > foto.getLikes().getCount()) {
					foto = fd; // Nos quedamos con la que más tenga
				}
			}

		} else {
			output = "<span><h2>Esta es tu foto con más Comentarios:</h2><br/>";
			for (FeedData fd : feed.getData()) {
				if (fd.getComments().getCount() > foto.getComments().getCount()) {
					foto = fd; // Nos quedamos con la que más tenga
				}
			}
		}

		img = "<img class='imgRes' src='"
				+ foto.getImages().getStandard_resolution().getUrl() + "'>";
		output += img;
		output += "</span>";

		HTML res = new HTML(output);
		fotos.add(res);
	}

}

