package ru.job4j.tracker;

import java.util.Arrays;

/**
 *  Класс, представляющий собой хранилище заявок.
 *  Содержит методы:
 *  - Добавление новой заявки в хранилище (add())
 *  - Замена заявки на новую по id (replace())
 *  - Поиск заявки по id (findById())
 *  - Поиск заявки по наименованию (findByName())
 *  - Метод возвращающий список всех заявок (findAll())
 *  - Удаление заявки по id (delete())
 */

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = true;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
        } else {
            rsl = false;
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                rsl[count++] = item;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}