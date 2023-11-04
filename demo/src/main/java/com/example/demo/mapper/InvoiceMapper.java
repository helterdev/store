package com.example.demo.mapper;

import com.example.demo.model.dto.InvoiceDto;
import com.example.demo.model.dto.response.InvoiceResponseDto;
import com.example.demo.model.entity.Invoice;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class InvoiceMapper {

    @Autowired
    public InvoiceDetailMapper invoiceDetailMapper;

    public InvoiceResponseDto toDTO(Invoice invoice) {
        return InvoiceResponseDto.builder()
                .invoiceId(invoice.getInvoiceId())
                .paymentMethod(invoice.getPaymentMethod())
                .discount(invoice.getDiscount())
                .total(invoice.getTotal())
                .emittedAt(invoice.getEmittedAt())
                .invoiceDetailDtos(invoiceDetailMapper.toDTOs(invoice.getInvoiceDetails()))
                .build();
    }

    public List<InvoiceResponseDto> toDTOs(List<Invoice> invoices) {
        if (invoices == null) {
            return null;
        }

        List<InvoiceResponseDto> list = new ArrayList<>();

        for (Invoice invoice : invoices) {
            list.add(toDTO(invoice));
        }

        return list;
    }

    public Invoice toEntity(InvoiceDto invoiceDto) {
        return Invoice.builder()
                .paymentMethod(invoiceDto.getPaymentMethod())
                .discount(invoiceDto.getDiscount())
                .total(invoiceDto.getTotal())
                .build();
    }
}