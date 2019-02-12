package com.munteanu.grouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class ValidationResult {
    private String message;

    public ValidationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

class ViolationEntity {

    private List<ValidationResult> results = new ArrayList<>();

    public ViolationEntity(List<ValidationResult> results) {
        this.results = results;
    }

    public List<ValidationResult> getResults() {
        return results;
    }

    public void setResults(List<ValidationResult> results) {
        this.results = results;
    }
}

public class GroupingMain {
    public static void main(String[] args) {

        List<ViolationEntity> entities = new ArrayList<>();

        entities.add(new ViolationEntity(Arrays.asList(
            new ValidationResult("pattern for x"),
            new ValidationResult("pattern for y"),
            new ValidationResult("length for y"),
            new ValidationResult("columns 1/2"),
            new ValidationResult("pattern for x"),
            new ValidationResult("columns 5/6")
        )));

        entities.add(new ViolationEntity(Arrays.asList(
                new ValidationResult("pattern for x"),
                new ValidationResult("length for z"),
                new ValidationResult("columns 2/3")
        )));

        entities.add(new ViolationEntity(Arrays.asList(
                new ValidationResult("length for y")
        )));

        Map<String, Long> groupedResult = new HashMap<>();

        for (ViolationEntity entity : entities) {

            List<ValidationResult> results = entity.getResults();

            // new Tuple2
//            Map<String, Long> groupedMap = results.stream().map(res -> {
//                if (res.getMessage().startsWith("columns")) {
//                    res.setMessage("columns");
//                }
//                return res;
//            }).collect(groupingBy(ValidationResult::getMessage, counting()));


            Map<String, Long> groupedMap = results.stream().map(res ->
                res.getMessage().startsWith("columns") ? "columns" : res.getMessage()
            ).collect(groupingBy(Function.identity(), counting()));

            System.out.println(results);
            printMap(groupedMap);

            groupedResult = Stream.concat(groupedResult.entrySet().stream(), groupedMap.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (val1, val2) -> val1 + val2 ));

        }
        printMap(groupedResult);
    }

    public static void printMap(Map<String, Long> map) {
        System.out.println("-----");
        map.forEach((k, v) -> {
            System.out.println(String.format("KEY: `%s` VALUE: %d", k, v));
        });
    }
}
