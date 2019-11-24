class MyHashMap {
public:
    /** Initialize your data structure here. */
    MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        for (int i=0; i<keys.size(); ++i)
        {
            if (keys[i]==key)
            {
                values[i] = value;
                return ;
            }
        }
        keys.push_back(key);
        values.push_back(value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int i = 0;
        for(i=0; i<keys.size(); ++i)
        {
            if(keys[i]==key)
                break;
                
        }
        if (i==keys.size())
            return -1;
        return values[i];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int i=0;
        for(i=0; i<keys.size(); ++i)
        {
            if (keys[i]==key)
                break;
        }
        if(i==keys.size())
            return ;
        std::swap(keys[i], keys[keys.size()-1]);
        std::swap(values[i], values[values.size()-1]);
        keys.pop_back();
        values.pop_back();
        /*
        keys.erase(keys.begin()+i);
        values.erase(values.begin()+i);*/
    }
    
    vector<int> keys;
    vector<int> values;
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
