import os
import time


def top_n(m, n):
    return sorted(m.items(), key=lambda kv: kv[1], reverse=True)[:n]


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
    for path, d, files in w:
        for file in files:
            if file.startswith(".") or file.lower().startswith("readme"):
                continue
            complete_count += 1
            f = os.path.join(path, file)
            t = os.path.getmtime(f)
            if t > latest_active_date:
                latest_active_date = t
    active[user] = latest_active_date
    complete[user] = complete_count

top_10_active = top_n(active, 10)
top_10_complete = top_n(complete, 10)

top3 = 3
print("### 完成题目最多的小伙伴")
print("""
| User | Completed |
| :--: | :-------: |""")
for k, v in top_10_complete:
    if top3 > 0:
        print("|", "**" + k + "**", "|", v, "|")
    else:
        print("|", k, "|", v, "|")
    top3 -= 1

print()

top3 = 3
print("### 最活跃的小伙伴")
print("""
| User | Latest Active Date |
| :--: | :----------------: |""")
for k, v in top_10_active:
    date_stamp = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(v))
    if top3 > 0:
        print("|", "**" + k + "**", "|", date_stamp, "|")
    else:
        print("|", k, "|", date_stamp, "|")
    top3 -= 1
