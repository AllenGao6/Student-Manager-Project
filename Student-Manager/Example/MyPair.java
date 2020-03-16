public class MyPair<K, V>{
    private K key;
    private V value;
    
    public MyPair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public String toString()
    {
        return key + " : " + value;
    }
    
    public K getKey()
    {
        return key;
    }
    
    public V getValue()
    {
        return value;
    }
}