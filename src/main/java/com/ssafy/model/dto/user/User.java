package com.ssafy.model.dto.user;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private Date registDate;
	private String email;
	private String type;
	private String img;
	private Date birth;
	private String gender;
	private String comment;
	private String socialLogin;
	private MultipartFile file;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String password, String name, String nickname, Date registDate, String email, String type,
			String img, Date birth, String gender, String comment, String socialLogin, MultipartFile file) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.registDate = registDate;
		this.email = email;
		this.type = type;
		this.img = img;
		this.birth = birth;
		this.gender = gender;
		this.comment = comment;
		this.socialLogin = socialLogin;
		this.file = file;
	}



	public User(String id, String password, String name, String nickname, String email, String socialLogin) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.socialLogin = socialLogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSocialLogin() {
		return socialLogin;
	}

	public void setSocialLogin(String socialLogin) {
		this.socialLogin = socialLogin;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", registDate=" + registDate + ", email=" + email + ", type=" + type + ", img=" + img + ", birth="
				+ birth + ", gender=" + gender + ", socialLogin=" + socialLogin + ", file=" + file + "]";
	}

}
