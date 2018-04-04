package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left > right) {
            return (List<Integer>) IntStream.range(right, left + 1)
                    .map(i -> left - i + right)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return (List<Integer>) IntStream.range(left, right + 1).boxed().collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left > right) {
            return (List<Integer>) IntStream.range(right, left + 1)
                    .map(i -> left - i + right)
                    .boxed()
                    .filter(number -> number % 2 == 0)
                    .collect(Collectors.toList());
        }
        return (List<Integer>) IntStream.range(left, right + 1)
                .boxed()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).boxed()
                .skip(array.length - 1)
                .findFirst()
                .get();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).boxed()
                .filter(first ->
                        Arrays.stream(secondArray).boxed()
                                .collect(Collectors.toSet())
                                .contains(first)
                )
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<>(Arrays.asList(firstArray));
        List<Integer> concatList = Stream.of(secondArray)
                .filter(second ->
                        !Stream.of(firstArray)
                                .collect(Collectors.toSet())
                                .contains(second)
                )
                .collect(Collectors.toList());
        result.addAll(
                concatList
        );
        return result;
    }
}
