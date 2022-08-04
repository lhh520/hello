package testproject;

import java.util.Deque;
import java.util.LinkedList;

class AnimalShelf {


    Deque<int[]> queueCat;
    Deque<int[]> queueDog;

    public AnimalShelf() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        // 判断种类后入队
        if (animal[1] == 0) {
            queueCat.addLast(animal);
        } else if (animal[1] == 1) {
            queueDog.addLast(animal);
        }
    }

    public int[] dequeueAny() {
        // 取出cat的队首，判空则直接返回
        int[] headCat;
        if (!queueCat.isEmpty()) {
            headCat = queueCat.getFirst();
        } else if (!queueDog.isEmpty()) {
            return queueDog.removeFirst();
        } else {
            return new int[]{-1,-1};
        }
        // 取出dog的队首，判空则直接返回
        int[] headDog;
        if (!queueDog.isEmpty()) {
            headDog = queueDog.getFirst();
        } else {
            return queueCat.removeFirst();
        }
        // 比较后返回
        if (headCat[0]<=headDog[0]) {
            return queueCat.removeFirst();
        } else {
            return queueDog.removeFirst();
        }
    }

    public int[] dequeueDog() {
        if (!queueDog.isEmpty()) {
            return queueDog.removeFirst();
        } else {
            return new int[]{-1,-1};
        }
    }

    public int[] dequeueCat() {
        if (!queueCat.isEmpty()) {
            return queueCat.removeFirst();
        } else {
            return new int[]{-1,-1};
        }
    }
}
