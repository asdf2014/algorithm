# -*- coding: utf-8 -*-
# @Time: 2020/11/8 23:47 
# @Author: GraceKoo
# @File: test.py
# @Desc:
from threading import Lock, Thread
import time


def print_numbers():
    time.sleep(0.2)
    print("子线程结束")


if __name__ == "__main__":
    t1 = Thread(target=print_numbers)
    t1.setDaemon(True)
    t1.start()
    # print("主线程结束")
