package gossapp.shared.domain.facebook;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Images implements Serializable{
   	private Number height;
   	private String source;
   	private Number width;

 	public Number getHeight(){
		return this.height;
	}
	public void setHeight(Number height){
		this.height = height;
	}
 	public String getSource(){
		return this.source;
	}
	public void setSource(String source){
		this.source = source;
	}
 	public Number getWidth(){
		return this.width;
	}
	public void setWidth(Number width){
		this.width = width;
	}
}
