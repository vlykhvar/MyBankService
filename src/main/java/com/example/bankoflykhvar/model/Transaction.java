package com.example.bankoflykhvar.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_from", nullable = false)
    private Account accountFrom;
    @ManyToOne
    @JoinColumn(name = "account_to", nullable = false)
    private Account accountTo;
    private BigDecimal amount;
    @Column(name = "date")
    private LocalDateTime date;
    @Enumerated(value = EnumType.STRING)
    private Type type;

    public enum Type {
        INCOMING,
        OUTCOMING
    }
}


