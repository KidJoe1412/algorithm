package leetcode;

import java.util.*;

/**
 * 题干：LRU 缓存
 *请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * ******************************************************
 * 解法：哈希表+双向链表
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/lru-cache/description/"></a>
 * ******************************************************
 */
class Node{
    int key,value;// [pre|key|value|next]
    Node pre,next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
    Node(){}
}
class DoubleList{
    Node head;
    Node tail;
    DoubleList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    public void addFirst(Node x){ // 头插法
        x.pre = head;
        x.next = head.next;
        head.next.pre = x;
        head.next = x;
    }
    public void remove(Node x){ // 删除一个结点
        x.pre.next = x.next;
        x.next.pre = x.pre;
        x.next = null;
        x.pre = null;
    }
    public Node removeLast(){ // 删除尾结点
        Node temp = this.tail.pre;
        remove(temp);
        return temp;
    }

}

class LRUCache {
    HashMap<Integer,Node> map;
    // 真正容量用map的size记录
    DoubleList list;
    int capacity; // 预设容量

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){ // 如果不包含key
            return -1;
        }else { // 如果包含key
            Node node = map.get(key);
            // get也算使用过，此node放在最前面
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key,value);
        if (map.containsKey(key)){ // 如果包含
            list.remove(map.get(key)); // 包含要通过map去定位删除
            map.remove(key);
        }else { // 不包含
            if (map.size() >= capacity){ // 且容量不够
                Node last = list.removeLast();
                map.remove(last.key);
            }
        }
        // 不管咋样都要更新
        list.addFirst(node);
        map.put(key,node);
    }
}




