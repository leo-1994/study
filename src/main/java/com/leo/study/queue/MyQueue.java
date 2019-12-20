package com.leo.study.queue;

import java.util.*;

/**
 * 使用单向链表实现一个先进先出的基本队列
 *
 * @author chao.li@quvideo.com
 * @date 2019-05-23 09:50
 */
public class MyQueue<E> extends AbstractCollection<E> implements Queue<E> {
    private int size;

    private int limit;

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    public MyQueue(int limit) {
        this.limit = limit;
        this.size = 0;
    }

    @Override
    public boolean add(E e) {
        if (!offer(e)) {
            throw new RuntimeException("队列已满");
        }
        return true;
    }

    @Override
    public boolean offer(E e) {
        if (size >= limit) {
            return false;
        }
        Node node = new Node(e);
        if (size <= 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public E remove() {
        E result = poll();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E result = head.data;
        this.head = head.next;
        size--;
        return result;
    }

    @Override
    public E element() {
        if (size == 0 || head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public E peek() {
        if (size == 0 || head == null) {
            return null;
        }
        return head.data;
    }

    class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    private class Itr implements Iterator<E> {
        int index = 0;
        Node curr = head;
        Node pre = null;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E result = curr.data;
                pre = curr;
                curr = curr.next;
                index++;
                return result;
            }
            return null;
        }

        @Override
        public void remove() {
            if (curr == null) {
                return;
            }
            if (pre == null) {
                head = head.next;

            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
            size--;
        }
    }


}
