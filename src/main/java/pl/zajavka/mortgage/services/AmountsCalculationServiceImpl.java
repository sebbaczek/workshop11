package pl.zajavka.mortgage.services;

import lombok.AllArgsConstructor;
import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.Overpayment;
import pl.zajavka.mortgage.model.Rate;
import pl.zajavka.mortgage.model.RateAmounts;

@AllArgsConstructor
public class AmountsCalculationServiceImpl implements AmountsCalculationService {

    private final ConstantAmountsCalculationService constantAmountsCalculationService;

    private final DecreasingAmountsCalculationService decreasingAmountsCalculationService;

    @Override
    public RateAmounts calculate(final InputData inputData, final Overpayment overpayment) {
        return switch (inputData.rateType()) {
            case CONSTANT -> constantAmountsCalculationService.calculate(inputData, overpayment);
            case DECREASING -> decreasingAmountsCalculationService.calculate(inputData, overpayment);
        };
    }

    @Override
    public RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate) {
        return switch (inputData.rateType()) {
            case CONSTANT -> constantAmountsCalculationService.calculate(inputData, overpayment, previousRate);
            case DECREASING -> decreasingAmountsCalculationService.calculate(inputData, overpayment, previousRate);
        };
    }


}
