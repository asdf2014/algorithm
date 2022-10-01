# 计算下一个周六，给 README.md 生成下周六用的
import os
from datetime import datetime, timedelta


def next_weekday(weekday, d=datetime.now()):
    delta = weekday - d.isoweekday()
    if delta <= 0:
        delta += 7
    return d + timedelta(delta)


def parse_ymd(s):
    year_s, mon_s, day_s = s.split("-")
    return datetime(int(year_s), int(mon_s), int(day_s))


with open("README.md", "r", encoding="utf-8") as fp:
    lines = fp.readlines()
    last_line = lines[-1]
    time_str = last_line.split(" ")
    # plan
    time_str[1] = next_weekday(weekday=6, d=parse_ymd(time_str[1])).strftime("%Y-%m-%d")
    # date
    time_str[3] = datetime.now().strftime("%Y-%m-%d")
    # Title
    next_file_name = "[12]IntegerToRoman.cpp"
    q_index = next_file_name[1 : next_file_name.find("]")]
    q_title = next_file_name[next_file_name.find("]") + 1 :]
    time_str[4] = "|[{}.{}](leetcode/editor/cn/{})|".format(
        q_index, q_title, next_file_name
    )
    # ms
    time_str[5] = "xx"
    # MB
    time_str[8] = "xx.xx"
    # info
    info = " ".join(time_str)
    print(info)

with open(file="README.md", mode="a") as af:
    af.writelines(info)
