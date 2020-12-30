import os

code_path = "Codes"
users = os.listdir(code_path)
base_path = os.path.abspath(
    os.path.dirname(os.path.abspath(__file__)) + os.path.sep + "."
)

for user in users:
    # skip .DS_Store / .gitignore etc
    if user.startswith("."):
        continue

    # for directories
    for parent, directories, _ in os.walk(os.path.join(code_path, user)):
        for directory in directories:
            if " " in directory:
                origin_path = os.path.join(parent, directory)
                current_path = os.path.join(parent, directory.replace(" ", "-"))
                origin_abs_path = os.path.join(base_path, origin_path)
                current_abs_path = os.path.join(base_path, current_path)
                print(origin_abs_path)
                print(current_abs_path)
                os.system("\\mv '%s' '%s'" % (origin_abs_path, current_abs_path))

    # for files
    for parent, _, files in os.walk(os.path.join(code_path, user)):
        for file in files:
            if " " in file:
                origin_path = os.path.join(parent, file)
                current_path = os.path.join(parent, file.replace(" ", "-"))
                origin_abs_path = os.path.join(base_path, origin_path)
                current_abs_path = os.path.join(base_path, current_path)
                print(origin_abs_path)
                print(current_abs_path)
                os.system("\\mv '%s' '%s'" % (origin_abs_path, current_abs_path))
