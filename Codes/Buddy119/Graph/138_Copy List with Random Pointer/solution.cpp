/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node() {}

    Node(int _val, Node* _next, Node* _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head) return nullptr;
        if(copy.find(head) == copy.end()){
            copy[head] = new Node(head->val, nullptr, nullptr);
            copy[head]->next = copyRandomList(head->next);
            copy[head]->random = copyRandomList(head->random);
         }
        return copy[head];
    }
private:
    unordered_map<Node*, Node*> copy;
};
