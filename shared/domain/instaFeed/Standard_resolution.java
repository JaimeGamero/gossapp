package gossapp.shared.domain.instaFeed;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)

public class Standard_resolution implements Serializable{
	
	private Number height;
   	private String url;
   	private Number width;

 	public Number getHeight(){
		return this.height;
	}
	public void setHeight(Number height){
		this.height = height;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public Number getWidth(){
		return this.width;
	}
	public void setWidth(Number width){
		this.width = width;
	}

}
