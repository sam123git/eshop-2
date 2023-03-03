package main.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private long orderDetailId;
    
    
    @ManyToOne
	@JoinColumn(name = "orders_order_id")
	private Order order;
    

    @Column(name = "product_id")
    private long productId;

    @Min(value = 0, message = "{detail.price}")
    @Column(name = "order_price")
    private BigDecimal orderPrice = new BigDecimal("0");

    @Min(value = 1, message = "{detail.quantity}")
    @Column(name = "order_quantity")
    private long orderQuantity = 1;

    @Min(value = 0, message = "{detail.discount}")
    @Column(name = "discount")
    private BigDecimal discount = new BigDecimal("0");
    
    private Date createTime;
	
	private Date updateTime;

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice.setScale(0, RoundingMode.DOWN);
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getDiscount() {
        return discount.setScale(0, RoundingMode.DOWN);
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    
    /*
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    */
    
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
