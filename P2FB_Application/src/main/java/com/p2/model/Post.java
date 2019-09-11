package com.p2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "p2sq_posts")
public class Post {

	@Id
	@Column(name = "p2sq_post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	@Column(name = "p2sq_content")
	private String content;
	
	@Column(name = "p2sq_num_of_likes")
	private int numOfLikes;
	
	@ManyToOne
	@JoinColumn(name = "p2sq_email", nullable = false)
	private User user;

	public Post() {
		super();
	}

	public Post(String content, int numOfLikes, User user) {
		super();
		this.content = content;
		this.numOfLikes = numOfLikes;
		this.user = user;
	}
	
	public Post(int postId, String content, int numOfLikes, User user) {
		super();
		this.postId = postId;
		this.content = content;
		this.numOfLikes = numOfLikes;
		this.user = user;
	}

	public int getPostId() {return postId;}
	public void setPostId(int postId) {this.postId = postId;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public int getNumOfLikes() {return numOfLikes;}
	public void setNumOfLikes(int numOfLikes) {this.numOfLikes = numOfLikes;}
	public User getCreator() {return user;}
	public void setCreator(User creator) {this.user = creator;}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", numOfLikes=" + numOfLikes + ", user=" + user
				+ "]";
	}
}
