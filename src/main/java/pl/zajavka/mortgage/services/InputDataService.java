package pl.zajavka.mortgage.services;

import pl.zajavka.mortgage.model.InputData;
import pl.zajavka.mortgage.model.MortgageType;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputDataService {

    private static final Path FILE_LOCATION = Paths.get("src/main/resources/inputData.csv");

    public InputData read() throws IOException {
        var content = Files.readString(FILE_LOCATION)
            .lines()
            .collect(Collectors.groupingBy(line -> line.split(";")[0]));

        validate(content);

        var inputData = content.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get(0).split(";")[1]));

        return new InputData(
            Optional.ofNullable(inputData.get("repaymentStartDate")).map(LocalDate::parse).orElseThrow(),
            Optional.ofNullable(inputData.get("wibor")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("amount")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("monthsDuration")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("rateType")).map(MortgageType::valueOf).orElseThrow(),
            Optional.ofNullable(inputData.get("margin")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("overpaymentProvision")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("overpaymentProvisionMonths")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("overpaymentStartMonth")).map(BigDecimal::new).orElseThrow(),
            Optional.ofNullable(inputData.get("overpaymentSchema")).map(this::calculateSchema).orElseThrow(),
            Optional.ofNullable(inputData.get("overpaymentReduceWay")).orElseThrow(),
            Optional.ofNullable(inputData.get("mortgagePrintPayoffsSchedule")).map(Boolean::parseBoolean).orElseThrow(),
            Optional.ofNullable(inputData.get("mortgageRateNumberToPrint")).map(Integer::parseInt).orElseThrow()
        );
    }

    private Map<Integer, BigDecimal> calculateSchema(String schema) {
        return Stream.of(schema.split(","))
            .map(entry -> Map.entry(entry.split(":")[0], entry.split(":")[1]))
            .collect(Collectors.toMap(
                entry -> Integer.parseInt(entry.getKey()),
                entry -> new BigDecimal(entry.getValue()),
                (v1, v2) -> v2,
                TreeMap::new
            ));
    }

    private void validate(final Map<String, List<String>> content) {
        if (content.values().stream().anyMatch(values -> values.size() != 1)) {
            throw new IllegalArgumentException("Configuration mismatch");
        }
    }
}
