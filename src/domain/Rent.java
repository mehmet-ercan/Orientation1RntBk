package domain;

import java.time.LocalDateTime;

public class Rent extends Sale {
    private LocalDateTime refundDate;
    public float refund;

    public LocalDateTime getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDateTime refundDate) {
        this.refundDate = refundDate;
    }

    public float getRefund() {
        return refund;
    }

    public void setRefund(float refund) {
        this.refund = refund;
    }

    /* Refund Sınıfında Yapılacak İşlemler
    /*public void calculatePercent() {
        if (refundDate <= 14) {
            refundPercent = 0.75f;
        } else if (refundDate <= 24) {
            refundPercent = 0.75f - ((refundPercent - 14) * 0.5f);
        } else {
            refundPercent = 0.25f;
        }
    }*/

}
