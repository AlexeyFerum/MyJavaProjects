package com.alexferum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

class KeyValueContainer<K, V> implements Serializable {

    private K key;
    private V value;

    public KeyValueContainer(){}
    public KeyValueContainer(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey()
    {
        return key;
    }
    public V getValue()
    {
        return value;
    }
    public void setKey(K key)
    {
        this.key=key;
    }
    public void setValue(V value)
    {
        this.value=value;
    }

}
