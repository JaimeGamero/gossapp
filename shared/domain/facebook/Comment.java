package gossapp.shared.domain.facebook;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Comment implements Serializable{
	
	private Number id;
	private From From;
	private String message;
	
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public From getFrom() {
		return From;
	}
	public void setFrom(From from) {
		From = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
