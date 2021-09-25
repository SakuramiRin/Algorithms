package muke.week3.chap1;

public class Test {
    public static void main(String[] args) {
        Array<Integer> integerArray = new Array<>();

        integerArray.addLast(0);
        integerArray.addLast(1);
        integerArray.addLast(2);
        integerArray.addLast(3);
        integerArray.addLast(4);
        integerArray.addLast(5);
        integerArray.addLast(6);
        integerArray.addLast(7);
        integerArray.addLast(8);
        integerArray.addLast(9);
        integerArray.addElement(9, 99);
        System.out.println(integerArray.toString());
        integerArray.deleteLast();
        System.out.println(integerArray.toString());

    }
}
