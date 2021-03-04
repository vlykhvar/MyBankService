package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.lib.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface GetRate {
    BigDecimal getRate(Currency from, Currency to, LocalDate date);
}
