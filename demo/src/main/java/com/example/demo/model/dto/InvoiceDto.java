package com.example.demo.model.dto;

import com.example.demo.model.entity.Branch;
import com.example.demo.model.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
@Builder
public class InvoiceDto {
    private Integer invoiceId;
    private PaymentMethod paymentMethod;
    private BigDecimal discount;
    private BigDecimal total;
    private Branch fkBranchId;
    private Timestamp emittedAt;
    private List<InvoiceDetailDto> invoiceDetailDtos;

    public InvoiceDto(Integer invoiceId, PaymentMethod paymentMethod, BigDecimal discount, BigDecimal total, Branch fkBranchId, Timestamp emittedAt, List<InvoiceDetailDto> invoiceDetailDtos) {
        this.invoiceId = invoiceId;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.total = total;
        this.fkBranchId = fkBranchId;
        this.emittedAt = emittedAt;
        this.invoiceDetailDtos = invoiceDetailDtos;
    }
}
