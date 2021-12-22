package main

var add = map[uint8]uint8{
	'1' + '2': '3',
	//'0' + '2': '2',
	'1' + '1': '2',
	'1' + '0': '1',
	'0' + '0': '0',
	'3':       '3',
	'2':       '2',
	'1':       '1',
	'0':       '0',
}

func addBinary(a string, b string) string {
	var addFlag uint8 = '0'
	res := ""
	for i, j := len(a)-1, len(b)-1; i >= 0 || j >= 0 || addFlag != '0'; {
		var aVal, bVal uint8 = 0, 0
		if i != -1 {
			aVal = a[i]
			i--
		}
		if j != -1 {
			bVal = b[j]
			j--
		}
		addRes := add[add[aVal+bVal]+addFlag]
		switch addRes {
		case '3':
			addFlag = '1'
			res = "1" + res
		case '2':
			addFlag = '1'
			res = "0" + res
		case '1':
			addFlag = '0'
			res = "1" + res
		case '0':
			addFlag = '0'
			res = "0" + res
		}
	}
	return res
}
