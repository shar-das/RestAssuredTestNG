package pojo.response;

public class AllOrdersResponse {
	
	private String orderId;
	private String toolId;
	private String customerName;
	private int quantity;
	private String created;
	private String comment;
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getToolId() {
		return toolId;
	}
	
	public void setToolIdI(String toolId) {
		this.toolId = toolId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getCreated() {
		return created;
	}
	
	public void setCreatedDate(String created) {
		this.created = created;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

}
