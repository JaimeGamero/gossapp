package gossapp.shared.domain.instaFeed;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class FeedData implements Serializable{
	
	
	private Comments comments;
	private Likes likes;
	private Images images;
	private User user;
	
	
	public Comments getComments() {
		return comments;
	}
	public void setComment(Comments comments) {
		this.comments = comments;
	}
	public Likes getLikes() {
		return likes;
	}
	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	public Images getImages() {
		return images;
	}
	public void setImages(Images images) {
		this.images = images;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
