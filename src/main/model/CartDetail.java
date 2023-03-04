package main.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cart_detail")
public class CartDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotBlank(message = "{cart.productId.notblank}")
	@Column(name = "cart_detail_id")
	private long cartDetailId;
	
	@NotBlank(message = "{cart.productId.notblank}")
	@Column(name = "product_id")
	private long productId;
	
	@NotBlank(message = "{cart.quantity.notblank}")
	@Column(name = "quantity")
	private long quantity;
	
	@NotBlank(message = "{cart.name.notblank}")
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@NotBlank(message = "{cart.name.notblank}")
	private BigDecimal discount;
	
	@ManyToOne
	@JoinColumn(name = "cart_cart_id")
	private Cart cart;
	
    private Date createTime;
	
	private Date updateTime;

    public long getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(long cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
//	@Column(name = "CREATE_TIME", length = 7, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
//	@Column(name = "UPDATE_TIME", length = 7)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
