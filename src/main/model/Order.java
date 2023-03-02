package main.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "orders")
public class Order {

	public enum Payment {
		money, card;
	}

//	public Order() {
//		setOrderDetail1(new OrderDetail());
//	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;
	
	@NotNull(message = "{order.date.notnull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "order_date")
	private Date orderDate;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{order.cid.pattern}")
	@Size(min = 5, max = 20, message = "{order.cid.size}")
	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "payment")
	private Payment payment;
	
	@Min(value = 0, message = "{order.amount}")
	@Column(name = "amount")
	private BigDecimal amount = new BigDecimal("0");

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_details_id")
//	private OrderDetail orderDetail;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
//	@Column(name = "order_detail1")
//	private OrderDetail orderDetail1;
	
    private Date createTime;
	
	private Date updateTime;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
		
//	public OrderDetail getOrderDetail() {
//		return orderDetail;
//	}
//
//	public void setOrderDetail(OrderDetail orderDetail) {
//		this.orderDetail = orderDetail;
//	}
//
//	public OrderDetail getOrderDetail1() {
//		return orderDetail1;
//	}
//
//	public void setOrderDetail1(OrderDetail orderDetail1) {
//		this.orderDetail1 = orderDetail1;
//	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_TIME", length = 7, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_TIME", length = 7)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
