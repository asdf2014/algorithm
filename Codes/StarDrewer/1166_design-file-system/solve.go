//You are asked to design a file system that allows you to create new paths and
//associate them with different values.
//
// The format of a path is one or more concatenated strings of the form: /
//followed by one or more lowercase English letters. For example, "/leetcode" and "/
//leetcode/problems" are valid paths while an empty string "" and "/" are not.
//
// Implement the FileSystem class:
//
//
// bool createPath(string path, int value) Creates a new path and associates a
//value to it if possible and returns true. Returns false if the path already
//exists or its parent path doesn't exist.
// int get(string path) Returns the value associated with path or returns -1 if
//the path doesn't exist.
//
//
//
// Example 1:
//
//
//Input:
//["FileSystem","createPath","get"]
//[[],["/a",1],["/a"]]
//Output:
//[null,true,1]
//Explanation:
//FileSystem fileSystem = new FileSystem();
//
//fileSystem.createPath("/a", 1); // return true
//fileSystem.get("/a"); // return 1
//
//
// Example 2:
//
//
//Input:
//["FileSystem","createPath","createPath","get","createPath","get"]
//[[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
//Output:
//[null,true,true,2,false,-1]
//Explanation:
//FileSystem fileSystem = new FileSystem();
//
//fileSystem.createPath("/leet", 1); // return true
//fileSystem.createPath("/leet/code", 2); // return true
//fileSystem.get("/leet/code"); // return 2
//fileSystem.createPath("/c/d", 1); // return false because the parent path "/
//c" doesn't exist.
//fileSystem.get("/c"); // return -1 because this path doesn't exist.
//
//
//
// Constraints:
//
//
// The number of calls to the two functions is less than or equal to 10⁴ in
//total.
// 2 <= path.length <= 100
// 1 <= value <= 10⁹
//
// Related Topics 设计 字典树 哈希表 字符串 👍 19 👎 0

package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
type FileSystem struct {
	cache map[string]int
}

func Constructor() FileSystem {
	return FileSystem{
		cache: map[string]int{},
	}
}

func (fs *FileSystem) CreatePath(path string, value int) bool {
	if path == "" || path == "/" {
		return false
	}
	if path[len(path)-1] == '/' {
		return false
	}
	for i := 1; i < len(path); i++ {
		if path[i] == '/' {
			if fs.Get(path[:i]) == -1{
				return false
			}
		}
	}
	if _, ok := fs.cache[path]; ok{
		return false // path exists
	}
	fs.cache[path] = value
	return true
}

func (fs *FileSystem) Get(path string) int {
	if v, ok := fs.cache[path]; ok {
		return v
	} else {
		return -1
	}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.CreatePath(path,value);
 * param_2 := obj.Get(path);
 */
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	obj := Constructor()
	fmt.Println(obj.CreatePath("/", 1))
	fmt.Println(obj.CreatePath("", 1))
	fmt.Println(obj.CreatePath("/1/2/3", 1))
	fmt.Println(obj.CreatePath("/a", 1))
	fmt.Println(obj.CreatePath("/a/b", 1))
}
