package domain;

import java.time.LocalDateTime;

public class CancelSale {
    Sale sale;
    float refund;
    LocalDateTime canceledDateTime;

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public float getRefund() {
        return refund;
    }

    public void setRefund(float refund) {
        this.refund = refund;
    }

    public LocalDateTime getCanceledDateTime() {
        return canceledDateTime;
    }

    public void setCanceledDateTime(LocalDateTime canceledDateTime) {
        this.canceledDateTime = canceledDateTime;
    }
}
