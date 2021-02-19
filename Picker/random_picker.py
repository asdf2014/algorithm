import datetime
import json
import random

import pytz
import requests

# load all of problems
problems_json_file = "Picker/all_problems.json"
try:
    page = requests.get("https://leetcode.com/api/problems/all/")
    text = page.content.decode("utf-8")
    problems = json.loads(text)
    with open(problems_json_file, "w+", encoding="utf-8") as f:
        f.write(text)
except:
    print("Unable to update problems!")
    with open(problems_json_file, "r+", encoding="utf-8") as f:
        readlines = f.readlines()[0]
        problems = json.loads(str(readlines))

# parse
id_title_map = {}
for problem in problems["stat_status_pairs"]:
    if problem["paid_only"]:
        continue
    question_id = problem["stat"]["question_id"]
    question__title = problem["stat"]["question__title"]
    question__title_slug = problem["stat"]["question__title_slug"]
    id_title_map[question_id] = [question__title, question__title_slug]

# make a choice
choice = random.choice(list(id_title_map.keys()))


def flush_readme(readme_file, url, date_comment, local):
    lines = []
    count = 0
    index = -1
    with open(readme_file) as readme:
        for line in readme:
            if "| ID | Title |" in line:
                index = count
            lines.append(line)
            count += 1

    # skip header
    index += 2

    # build infos
    choice_ = id_title_map[choice]
    lines[index] = "| [%s](%s%s) | %s |\n" % (choice, url, choice_[1], choice_[0])

    dt = datetime.datetime.utcnow()
    if local:
        dt = dt.replace(tzinfo=pytz.utc).astimezone(pytz.timezone("Asia/Shanghai"))
    date_stamp = dt.strftime("%Y-%m-%d %H:%M:%S")
    lines[index + 2] = date_comment % date_stamp

    with open(readme_file, "w") as readme:
        readme.write("".join(lines))


# flush README
flush_readme(
    "README.md", "https://leetcode-cn.com/problems/", "🤖：最近一次更新时间为 `%s`。\n", True
)
flush_readme(
    "README-en.md",
    "https://leetcode.com/problems/",
    "🤖: The last update time was `%s`.\n",
    False,
)
