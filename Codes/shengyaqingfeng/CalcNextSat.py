# 计算下一个周六，给 README.md 生成下周六用的
import os
from datetime import datetime, timedelta

project_path = "leetcode/editor/cn/"


def next_weekday(weekday, d=datetime.now()):
    delta = weekday - d.isoweekday()
    if delta <= 0:
        delta += 7
    return d + timedelta(delta)


def parse_ymd(s):
    year_s, mon_s, day_s = s.split("-")
    return datetime(int(year_s), int(mon_s), int(day_s))


def get_latest_file():
    files = os.listdir(project_path)
    max_index = 0
    result = ""
    for file in files:
        if file[0] == "[":
            file_index = int(file[1 : file.find("]")])
            if file_index > max_index:
                max_index = file_index
                result = file
    return result


with open("README.md", "r", encoding="utf-8") as fp:
    lines = fp.readlines()
    last_line = lines[-1]
    time_str = last_line.split("|")
    # plan
    time_str[1] = next_weekday(weekday=6, d=parse_ymd(time_str[1])).strftime("%Y-%m-%d")
    # date
    time_str[2] = datetime.now().strftime("%Y-%m-%d")
    # Title
    next_file_name = get_latest_file()
    q_index = next_file_name[1 : next_file_name.find("]")]
    q_title = next_file_name[next_file_name.find("]") + 1 :]
    time_str[3] = "[{}.{}]({}{})".format(q_index, q_title, project_path, next_file_name)
    # ms
    time_str[4] = "xx ms"
    # MB
    time_str[5] = "xxx MB"
    info = "|".join(time_str)
    print(info)

with open(file="README.md", mode="a") as af:
    af.writelines(info)
with open(file=project_path + "CMakeLists.txt", mode="a") as af:
    af.writelines("add_executable({} {})\n".format(q_title[:-4], next_file_name))
