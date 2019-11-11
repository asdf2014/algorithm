import os
import time

code_path = "Codes"
users = os.listdir(code_path)

active = {}
complete = {}
for user in users:
    # skip .DS_Store / .gitignore etc
    if user.startswith("."):
        continue

    w = os.walk(os.path.join(code_path, user))

    latest_active_date = -1
    complete_count = 0
    for parent, directories, files in w:
        for file in files:
            if file.startswith(".") or file.lower().startswith("readme"):
                continue
            complete_count += 1
            f = os.path.join(parent, file)
            t = os.path.getmtime(f)
            if t > latest_active_date:
                latest_active_date = t
    active[user] = latest_active_date
    complete[user] = complete_count


def top_n(m, n):
    return sorted(m.items(), key=lambda kv: kv[1], reverse=True)[:n]


top_10_active = top_n(active, 10)
top_10_complete = top_n(complete, 10)


def flush_readme(readme_file):
    lines = []
    count = 0
    index = -1
    with open(readme_file) as data:
        for line in data:
            if '| User | Completed |' in line:
                index = count
            lines.append(line)
            count += 1

    # skip header
    index += 2

    top3 = 3
    for k, v in top_10_complete:
        if top3 > 0:
            row = "| " + "**" + k + "**" + " | " + str(v) + " |\n"
        else:
            row = "| " + k + " | " + str(v) + " |\n"

        lines[index] = row

        index += 1
        top3 -= 1

    # skip header
    index += 5

    top3 = 3
    for k, v in top_10_active:
        date_stamp = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(v))
        if top3 > 0:
            row = "| " + "**" + k + "**" + " | " + date_stamp + " |\n"
        else:
            row = "| " + k + " | " + date_stamp + " |\n"

        lines[index] = row

        index += 1
        top3 -= 1

    with open(readme_file, 'w') as data:
        data.write(''.join(lines))


flush_readme('README.md')
flush_readme('README-en.md')
