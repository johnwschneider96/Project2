package com.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STORY")
public class Story
{
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="num_likes")
	private int numLikes;
	
	//@ManyToOne
	//@JoinColumn(name="user_email", nullable=false)
	private String userEmail;
	
	public Story() {
	}

	public Story(int postId, String content, int numLikes, String userEmail) {
		super();
		this.postId = postId;
		this.content = content;
		this.numLikes = numLikes;
		this.userEmail = userEmail;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumLikes() {
		return numLikes;
	}

	public void setNumLikes(int numLikes) {
		this.numLikes = numLikes;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Story [postId=" + postId + ", content=" + content + ", numLikes=" + numLikes + ", userEmail="
				+ userEmail + "]";
	}
}