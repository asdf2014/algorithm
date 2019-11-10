import os
import time

users = os.listdir("./Codes")

updates = {}
finished = {}
for user in users:
    # skip .DS_Store / .gitignore etc
    if user.startswith("."):
        continue
    g = os.walk(os.path.join("Codes", user))

    max_update_time = -1
    count = 0
    for path, d, files in g:
        for file in files:
            if file.startswith(".") or file.lower().startswith("readme"):
                continue
            count += 1
            f = os.path.join(path, file)
            update_time = os.path.getmtime(f)
            if update_time > max_update_time:
                max_update_time = update_time
    updates[user] = max_update_time
    finished[user] = count

top_10_updated = sorted(updates.items(), key=lambda kv: kv[1], reverse=True)[:10]
top_10_finished = sorted(finished.items(), key=lambda kv: kv[1], reverse=True)[:10]

count = 3
print("### 完成题目最多的小伙伴")
print("""
| User | Completed |
| ---- | --------- |""")
for k, v in top_10_finished:
    if count > 0:
        print("|", "**" + k + "**", "|", v, "|")
    else:
        print("|", k, "|", v, "|")
    count -= 1

print()

count = 3
print("### 最活跃的小伙伴")
print("""
| User | Latest Active Date |
| ---- | ------------------ |""")
for k, v in top_10_updated:
    if count > 0:
        print("|", "**" + k + "**", "|", time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(v)), "|")
    else:
        print("|", k, "|", time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(v)), "|")
    count -= 1
