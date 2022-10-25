package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent extends Sale {
    private LocalDateTime refundDate;
    private float refund;

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

    @Override
    public String generateOperationNumber(int customerId) { // R18102214550901 => Rent 18.10.2022 14:55.09 01 idli Müşteri
        String receiptNumber = "R" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss")) + customerId;
        return receiptNumber;
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
