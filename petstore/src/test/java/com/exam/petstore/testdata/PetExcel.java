package com.exam.petstore.testdata;

import com.poiji.annotation.ExcelCell;

public class PetExcel {
	@ExcelCell(0)
	int id;
	@ExcelCell(1)
	String categoryid;
	@ExcelCell(2)
	String categoryname;
	@ExcelCell(3)
	String name;
	@ExcelCell(4)
	String photoUrls;
	@ExcelCell(5)
	String status;
	@ExcelCell(6)
	String tagsid;
	@ExcelCell(7)
	String tagsname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}

	public String getTagsid() {
		return tagsid;
	}

	public void setTagsid(String tagsid) {
		this.tagsid = tagsid;
	}

	public String getTagsname() {
		return tagsname;
	}

	public void setTagsname(String tagsname) {
		this.tagsname = tagsname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
