public class OBQueue
{
    // Указатель на первый элемент
    private ObjectBox head = null;
    // Указатель на последний элемент
    private ObjectBox tail = null;
    // Поле для хранения размера очереди
    private int size = 0;
    public void push(Object obj) {
    // Сразу создаем вспомогательный объект и помещаем новый элемент в него
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);
    // Если очередь пустая - в ней еще нет элементов
        if (head == null) {
    // Теперь наша голова указывает на наш первый элемент
            head = ob;
        } else {
    // Если это не первый элемент, то нам надо указать, чтобы последний элемент в очереди
    // указывал на наш новый элемент через поле next
            tail.setNext(ob);
    // и наш новый элемент должен указывать на предыдущий элемент (tail) через поле prev
            ob.setPrev(tail);
        }
    // И в любом случае нам надо наш "хвост" переместить на новый элемент
    // Если это первый элемент, то "голова" и "хвост" будут указывать на один и тот же элемент
        tail = ob;
    // Увеличиваем размер нашей очереди
        size++;
    }

    public Object pull() {
        // Если у нас нет элементов, то возвращаем null
        if (size == 0) {
            return null;
        }
        // Получаем наш объект из вспомогательного класса из "головы"
        Object obj = head.getObject();
         // Перемещаем "голову" на следующий элемент
        head = head.getNext();
         // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже должен указать на null.
        if (head == null) {
            tail = null;
        } else {
            // если в очереди еще остались элементы, то надо указать, что следующий элемент от новой головы
            // не имеет предыдущего элемента
            head.setPrev(null);
        }
        // Уменьшаем размер очереди
        size--;
        // Возвращаем значение
        return obj;
    }

    public int size() {
        return size;
    }

    // Наш вспомогательный класс будет закрыт от посторонних глаз
    private class ObjectBox
    {
        // Поле для хранения объекта
        private Object object;
        // Поле для указания на следующий элемент в цепочке.
        // Если оно равно NULL - значит это последний элемент
        private ObjectBox next;
        // Поле для указания на предыдущий элемент в цепи
        // Геттеры и сеттеры для полей.
        private ObjectBox prev;
        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }

        public ObjectBox getPrev() {
            return prev;
        }

        public void setPrev(ObjectBox prev) {
            this.prev = prev;
        }
    }
}