package com.thoughtworks.collection;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.naturalOrder()).get();
    }

    public double getMinimum() {
        return arrayList.stream().max(Comparator.reverseOrder()).get();
    }

    public double getAverage() {
        return arrayList.stream().map(a -> (double) a).reduce((a, b) -> a + b).get() / arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> sortedList = arrayList.stream()
                .sorted()
                .collect(Collectors.toList());
        int middleIndex = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            return (double) (sortedList.get(middleIndex) + sortedList.get(middleIndex - 1)) / 2;
        }
        return (double) sortedList.get(middleIndex);
    }

    public int getFirstEven() {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst()
                .get();
    }

    public int getIndexOfFirstEven() {
        return IntStream.range(0, arrayList.size())
                .filter(i -> arrayList.get(i) % 2 == 0)
                .findFirst()
                .getAsInt();
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() != arrayList.size())
            return false;
        return !IntStream.range(0, arrayList.size())
                .filter(i->this.arrayList.get(i) != arrayList.get(i))
                .findFirst()
                .isPresent();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        LinkList<Integer> linkList = new LinkList<Integer>();
        for (Integer item :
                arrayList) {
            linkList.addTailPointer(item);
            singleLink.addTailPointer(item);
        }
        int size = linkList.size();
        int middle1 = linkList.getNode(size / 2);
        if (size % 2 == 1) {
            return (double) middle1;
        } else {
            int middle2 = linkList.getNode(size / 2 - 1);
            return ((double) middle1 + (double) middle2) / 2;
        }

    }

    public int getLastOdd() {
        return arrayList.stream()
                .filter(number -> number % 2 == 1)
                .reduce((first, second) -> second)
                .get();
    }

    public int getIndexOfLastOdd() {
        return IntStream.range(0, arrayList.size())
                .filter(i -> arrayList.get(i) % 2 == 1)
                .reduce((first, second) -> second)
                .getAsInt();
    }
}
