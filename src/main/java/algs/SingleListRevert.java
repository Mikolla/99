package algs;

import java.util.Iterator;

/**
 * Оборачивание списка рекурсией, итеративной и путем создания нового списка добавлением в начало из исходного
 */
public class SingleListRevert
{
    public static void main(String[] args)
    {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(1, "Васильев Евстахий Борисович", "+129381832"));
        contactList.addToEnd(new Contact(2, "Коновалов Степан Петрович", "+234432334"));
        contactList.addToEnd(new Contact(3, "Калинин Артём Валериевич", "+2234234423"));
        contactList.addToEnd(new Contact(4, "Предыбайло Григорий Анатолиевич", "+2342344234"));
        contactList.addToEnd(new Contact(5, "Степанов Мирослав Андреевич", "+6678877777"));

        System.out.println("------Исходный список------");
        System.out.println("head = " + contactList.head.data);
        for (Contact contact : contactList)
        {
            System.out.println(contact);
        }
        System.out.println("tail = " + contactList.tail.data);

        contactList.reverseFinish();

        System.out.println("--------Перевернутый список------");

        System.out.println("head = " + contactList.head.data);
        for (Contact contact : contactList)
        {
            System.out.println(contact);
        }
        System.out.println("tail = " + contactList.tail.data);
    }

    static class Contact
    {
        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone)
        {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString()
        {
            return "Contact{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable<T>
    {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator<T> iterator()
        {
            return new Iterator<T>()
            {
                ListItem<T> current = head;

                @Override
                public boolean hasNext()
                {
                    return current != null;
                }

                @Override
                public T next()
                {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        public static class ListItem<T>
        {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty()
        {
            return head == null;
        }

        public void addToEnd(T item)
        {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty())
            {
                head = newItem;
                tail = newItem;
            }
            else
            {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void addToStart(T item)
        {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty())
            {
                head = newItem;
                tail = newItem;
                tail.next = null;
            }
            else
            {
                newItem.next = head;
                head = newItem;
            }
        }

        /**
         * Переворачивает список (хвост и голову меняет местами)
         */
        public void reverse()
        {
            if (!isEmpty() && head.next != null)
            {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null)
                {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }

        /**
         * По одной (певой) переданной переменной из списка переворачивает весь односвязный список
         * @param head первый член исходного односвязного списка
         * @return первый член перевернутого односвязного списка
         */
        public ListItem<T> reverseVerySimple(ListItem<T> head)
        {
            ListItem<T> prev = null;
            ListItem<T> next = null;
            while (head != null)
            {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }

        /**
         * Метод создан для того, чтоб поменять ссылки с хвоста на голову переворачиваемого односвязного списка и
         * наоборот после метода reverseVerySimple()
         */
        public void reverseFinish()
        {
            tail = head;
            head = reverseVerySimple(head);
        }

        /**
         * Оборачивание односвязного списка путем добавления его членов в начало нового списка
         * @return перевернутый список
         */
        public SingleLinkList<T> getReversedList()
        {
            SingleLinkList reversed = new SingleLinkList();
            if (!isEmpty())
            {
                ListItem<T> current = head;
                do
                {
                    reversed.addToStart(current.data);
                    current = current.next;
                }
                while (current != null);
            }
            return reversed;
        }

        /**
         * Оборачиваниие односвязного списка рекурсией
         * @param headItem - первый член исходного списка
         * @return первый член перевернутого списка
         */
        public ListItem<T> reverseRecursion(ListItem<T> headItem)
        {
            if (headItem == null || headItem.next == null)
            {
                return headItem;
            }
            // last node or only one node
            ListItem<T> newHeadNode = reverseRecursion(headItem.next);
            // change references for middle chain
            headItem.next.next = headItem;
            headItem.next = null;
            // send back new head node in every recursion
            return newHeadNode;
        }
    }
}
