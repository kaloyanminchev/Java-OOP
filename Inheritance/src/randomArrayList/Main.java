package randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> arrayList = new RandomArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);

        System.out.println("Size before: " + arrayList.size());
        System.out.println(arrayList.getRandomElement());
        System.out.println("Size after: " + arrayList.size());
    }
}
