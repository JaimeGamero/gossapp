
package gossapp.shared.domain.facebook;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)

public class Data implements Serializable{
	private String created_time;
   	private String id;
   	private List<Images> images;
   	private Like likes;

 	public String getCreated_time(){
		return this.created_time;
	}
	public void setCreated_time(String created_time){
		this.created_time = created_time;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public List<Images> getImages(){
		return this.images;
	}
	public void setImages(List<Images> images){
		this.images = images;
	}
	public Like getLikes() {
		return likes;
	}
	public void setLikes(Like likes) {
		this.likes = likes;
	}
}
