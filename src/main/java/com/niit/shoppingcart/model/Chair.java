package com.niit.shoppingcart.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity  
@Component
public class Chair
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="chairId")
	int chairId;
	@Column(name="chairName")
	String chairName;
	@Column(name="chairPrice")
	int chairPrice;
	@Column(name="chairDesc")
	String chairDesc;
	@Column(name="chairStyle")
	String chairStyle;
	@Column(name="warranty")
	String warranty;
	@Column(name="primaryMeterial")
	String primaryMeterial;
	@Column(name="capacity")
	String capacity;
	 	
	 	 
	 	@OneToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="supplier")
		private Supplier supplier;
	 	
	 	 @OneToOne(cascade=CascadeType.PERSIST)
			@JoinColumn(name="category")
			private Category category;
	 	
		@Column(name="image",columnDefinition="varchar(255)")
		@Size(min=3,message="Please Select the Image")
		private	String image;
		@JsonIgnore
		transient private MultipartFile img;
		public int getChairId() {
			return chairId;
		}
		public void setChairId(int chairId) {
			this.chairId = chairId;
		}
		public String getChairName() {
			return chairName;
		}
		public void setChairName(String chairName) {
			this.chairName = chairName;
		}
		public int getChairPrice() {
			return chairPrice;
		}
		public void setChairPrice(int chairPrice) {
			this.chairPrice = chairPrice;
		}
		public String getChairDesc() {
			return chairDesc;
		}
		public void setChairDesc(String chairDesc) {
			this.chairDesc = chairDesc;
		}
		public String getChairStyle() {
			return chairStyle;
		}
		public void setChairStyle(String chairStyle) {
			this.chairStyle = chairStyle;
		}
		public String getWarranty() {
			return warranty;
		}
		public void setWarranty(String warranty) {
			this.warranty = warranty;
		}
		public String getPrimaryMeterial() {
			return primaryMeterial;
		}
		public void setPrimaryMeterial(String primaryMeterial) {
			this.primaryMeterial = primaryMeterial;
		}
		public String getCapacity() {
			return capacity;
		}
		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}
		public Supplier getSupplier() {
			return supplier;
		}
		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public MultipartFile getImg() {
			return img;
		}
		public void setImg(MultipartFile img) {
			this.img = img;
		}
				
}