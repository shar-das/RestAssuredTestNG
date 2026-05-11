package pojo.response;

public class CreateOrderResponse {

    private boolean created;
    private String orderId;

    public boolean getIsCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
