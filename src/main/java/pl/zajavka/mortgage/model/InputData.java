package pl.zajavka.mortgage.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;

public record InputData(
    LocalDate repaymentStartDate,
    BigDecimal wiborPercent,
    BigDecimal amount,
    BigDecimal monthsDuration,
    MortgageType rateType,
    BigDecimal marginPercent,
    BigDecimal overpaymentProvisionPercent,
    BigDecimal overpaymentProvisionMonths,
    BigDecimal overpaymentStartMonth,
    Map<Integer, BigDecimal> overpaymentSchema,
    String overpaymentReduceWay,
    boolean mortgagePrintPayoffsSchedule,
    Integer mortgageRateNumberToPrint
) {

    private static final BigDecimal PERCENT = new BigDecimal("100");

    public InputData withRepaymentStartDate(LocalDate repaymentStartDate) {
        return new InputData(
            repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withWiborPercent(BigDecimal wiborPercent) {
        return new InputData(
            this.repaymentStartDate,
            wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withAmount(BigDecimal amount) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withMonthsDuration(BigDecimal monthsDuration) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withType(MortgageType rateType) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withMarginPercent(BigDecimal marginPercent) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withOverpaymentProvisionPercent(BigDecimal overpaymentProvisionPercent) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withOverpaymentProvisionMonths(BigDecimal overpaymentProvisionMonths) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withOverpaymentStartMonth(BigDecimal overpaymentStartMonth) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withOverpaymentSchema(Map<Integer, BigDecimal> overpaymentSchema) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withOverpaymentReduceWay(String overpaymentReduceWay) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withMortgagePrintPayoffsSchedule(boolean mortgagePrintPayoffsSchedule) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            mortgagePrintPayoffsSchedule,
            this.mortgageRateNumberToPrint
        );
    }

    public InputData withMortgageRateNumberToPrint(Integer mortgageRateNumberToPrint) {
        return new InputData(
            this.repaymentStartDate,
            this.wiborPercent,
            this.amount,
            this.monthsDuration,
            this.rateType,
            this.marginPercent,
            this.overpaymentProvisionPercent,
            this.overpaymentProvisionMonths,
            this.overpaymentStartMonth,
            this.overpaymentSchema,
            this.overpaymentReduceWay,
            this.mortgagePrintPayoffsSchedule,
            mortgageRateNumberToPrint
        );
    }

    public BigDecimal wiborPercent() {
        return wiborPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal marginPercent() {
        return marginPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal overpaymentProvisionPercent() {
        return overpaymentProvisionPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal interestPercent() {
        return marginPercent().add(wiborPercent());
    }

    public BigDecimal interestToDisplay() {
        return wiborPercent().add(marginPercent());
    }

}
