package com.example.bankoflykhvar.model;

import com.example.bankoflykhvar.lib.Currency;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;
    private BigDecimal balance;
    private boolean isActive;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Account{"
                + "id=" + id
                + ", accountNumber='" + accountNumber
                + '\'' + ", balance=" + balance
                + ", active=" + isActive + '}';
    }
}
