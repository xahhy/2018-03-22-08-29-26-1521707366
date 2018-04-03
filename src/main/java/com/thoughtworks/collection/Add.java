package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (rightBorder < leftBorder) {
            int tmp = rightBorder;
            rightBorder = leftBorder;
            leftBorder = tmp;
        }
        return IntStream.range(leftBorder, rightBorder + 1)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (rightBorder < leftBorder) {
            int tmp = rightBorder;
            rightBorder = leftBorder;
            leftBorder = tmp;
        }
        return IntStream.range(leftBorder, rightBorder + 1)
                .filter(number -> number % 2 == 1)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number -> number * 3 + 2)
                .reduce(0, (sum, number) -> sum + number);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number -> {
                    if (number % 2 == 1) {
                        return number * 3 + 2;
                    } else {
                        return number;
                    }
                })
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 1)
                .map(number -> number * 3 + 5)
                .reduce(0, (sum, number) -> sum + number);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .flatMapToInt(number->IntStream.of(number))
                .average()
                .getAsDouble();
        //        List<Integer> result = arrayList.stream()
//                .filter(number -> number % 2 == 0)
//                .sorted()
//                .map(number->{
//                    System.out.println(number);
//                    return number;
//                })
//                .collect(Collectors.toList());
//        return result.get(result.size()/2);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .flatMapToInt(IntStream::of)
                .average()
                .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .anyMatch(number-> specialElment.equals(number));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Map<Boolean, List<Integer>> splitList = arrayList.stream()
                .collect(Collectors.partitioningBy(number->number%2==0));

        List<Integer> result = splitList.get(true).stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        result.addAll(
                splitList.get(false).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                );
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<List<Integer>> middleArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            middleArray.add(Arrays.asList(arrayList.get(i), arrayList.get(i + 1)));
        }
        return middleArray.stream()
                .map(twoNumber -> (twoNumber.get(0) + twoNumber.get(1)) * 3)
                .collect(Collectors.toList());
    }
}
