package pl.zajavka.mortgage;

import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.MortgageType;
import pl.zajavka.mortgage.model.Overpayment;
import pl.zajavka.mortgage.services.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MortgageCalculator {

    public static void main(String[] args) {

        InputData inputData;
        try {
            inputData = new InputDataService().read();
        } catch (Exception e) {
            System.err.println("Error loading input data, interrupting. Error: " + e.getMessage());
            return;
        }

        var overpaymentSchema = new TreeMap<>(
            Map.of(
                5, BigDecimal.valueOf(12000),
                19, BigDecimal.valueOf(10000),
                28, BigDecimal.valueOf(11000),
                64, BigDecimal.valueOf(16000),
                78, BigDecimal.valueOf(18000)
            )
        );

        var updatedInputData = inputData
            .withAmount(new BigDecimal("296192.11"))
            .withMonthsDuration(BigDecimal.valueOf(360))
            .withOverpaymentReduceWay(Overpayment.REDUCE_PERIOD)
            .withType(MortgageType.DECREASING)
            .withOverpaymentSchema(overpaymentSchema);

        CalculatorCreator.getInstance().calculate(updatedInputData);
    }

    static class CalculatorCreator {

        private static MortgageCalculationService instance;

        private CalculatorCreator() {
        }

        public static MortgageCalculationService getInstance() {
            if (Objects.isNull(instance)) {
                instance = new MortgageCalculationServiceImpl(
                    new RateCalculationServiceImpl(
                        new TimePointCalculationServiceImpl(),
                        new AmountsCalculationServiceImpl(
                            new ConstantAmountsCalculationServiceImpl(),
                            new DecreasingAmountsCalculationServiceImpl()
                        ),
                        new ResidualCalculationServiceImpl(),
                        new ReferenceCalculationServiceImpl(),
                        new OverpaymentCalculationServiceImpl()
                    ),
                    new PrintingServiceImpl(),
                    SummaryServiceFactory.create()
                );
            }
            return instance;
        }
    }
}
