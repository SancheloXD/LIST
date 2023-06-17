public class Main
{
    public static void main(String[] arg) {
        OBQueue queue = new OBQueue();

        queue.push("Алексей");
        queue.push("Дмитрий");
        queue.push("Владимир");
        queue.push("Александр");
        queue.push("Виктор");

        System.out.println("Размер очереди: " + queue.size());

        Object obj1 = queue.pull();
        System.out.println("Вытаскиваем элемент из очереди: " + obj1);
        System.out.println("Размер очереди: " + queue.size());

        Object obj3 = queue.pull();
        System.out.println("Вытаскиваем элемент из очереди: " + obj3);
        System.out.println("Размер очереди: " + queue.size());

        Object obj4 = queue.pull();
        System.out.println("Вытаскиваем элемент из очереди: " + obj4);
        System.out.println("Размер очереди: " + queue.size());

        Object obj5 = queue.pull();
        System.out.println("Вытаскиваем элемент из очереди: " + obj5);
        System.out.println("Размер очереди: " + queue.size());

        Object obj0 = queue.pull();
        System.out.println("Вытаскиваем элемент из очереди: " + obj0);

    }
}