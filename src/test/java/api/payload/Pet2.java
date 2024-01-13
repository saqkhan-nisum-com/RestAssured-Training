package api.payload;

import java.util.List;

public class Pet2 {

	 long id;
     Category_pet category;
     String name;
     List<String> photoUrls;
     List<Tag_pet> tags;
     String status;
     
     
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category_pet getCategory() {
		return category;
	}
	public void setCategory(Category_pet category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<Tag_pet> getTags() {
		return tags;
	}
	public void setTags(List<Tag_pet> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



}
