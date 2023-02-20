package main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	public enum State {
//		Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware, Florida, Georgia, Hawaii, Idaho, Illinois, Indiana,Iowa,Kansas
//		,Kentucky,Louisiana,Maine,Maryland,Massachusetts,Michigan,Minnesota,Mississippi,Missouri,Montana,Nebraska,Nevada,NewHampshire,NewJersey
//		,NewMexico,NewYork,NorthCarolina,NorthDakota,Ohio,Oklahoma,Oregon,Pennsylvania,RhodeIsland,SouthCarolina,SouthDakota,Tennessee,Texas
//		,Utah,Vermont,Virginia,Washington,WestVirginia,Wisconsin,Wyoming;
		台灣
	}
	
	public enum City {
//		NewYork,LosAngeles,Chicago,Houston,Phoenix,Boston,SanAntonio,SanDiego,Dallas,SanJose,LasVegas;
//		Taichung,Kaohsiung,Taipei,Tainan,Zhongli,Changhua,Pingtung,Hsinchu,TaoyuanDistrict,Keelung,Chiayi,Zhubei,Nantou,Yilan,Hualien,Taitung,
//		Douliu,Miaoli,Magong,Taibao,Nangan,Banqiao,Jincheng
		基隆市,台北市,新北市,桃園縣,新竹市,新竹縣,苗栗縣,台中市,彰化縣,南投縣,雲林縣,嘉義市,嘉義縣,台南市,高雄市,
		屏東縣,台東縣,花蓮縣,宜蘭縣,澎湖縣,金門縣,連江縣
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "{customer.companyName.notblank}")
	@Size(min = 2, max = 20, message = "{customer.name.size}")
	@Column(length = 20)
	@Pattern(regexp = "^[\\u4e00-\\u9fa5]+\\u516C\\u53F8$", message = "{customer.companyName.type}")
	private String companyName;
	
	@NotBlank(message = "{customer.contactName.notblank}")
	@Size(min = 2, max = 20, message = "{customer.name.size}")
	@Column(length = 20)
	@Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "{customer.name.type}")
	private String contactName;
	
	@Pattern(regexp = "^[0-9]{5}$", message = "{customer.postalcode.pattern}")
	private String postalcode;
	
	@Pattern(regexp = "^09\\d{8}", message= "{customer.phonenumber.pattern}")     
	private String phonenumber;
	
	private State state;
	
	private City city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_details_id")
	private CustomerDetails customerDetails;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	
			
}