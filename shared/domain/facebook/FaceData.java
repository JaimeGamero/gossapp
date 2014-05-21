package gossapp.shared.domain.facebook;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class FaceData implements Serializable{
	
	private String id;
	private From from;
	private String message;
	private String story;
	private String picture;
	private String link;
	private String description;
	private List<Actions> actions;
	private Number object_id;
	private List<Like> likes;
	private List<Comment> comments;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public From getFrom() {
		return from;
	}
	public void setFrom(From from) {
		this.from = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Actions> getActions() {
		return actions;
	}
	public void setActions(List<Actions> actions) {
		this.actions = actions;
	}
	public Number getObject_id() {
		return object_id;
	}
	public void setObject_id(Number object_id) {
		this.object_id = object_id;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
