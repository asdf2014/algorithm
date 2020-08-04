#!/usr/bin/env bash

# check git
command -v git >/dev/null 2>&1 || {
    echo >&2 "I require git but it's not installed!"; exit 1;
}

# check username
user_name=$(git config user.name)

if [[ ${user_name}_x != "_x" ]]; then
    echo "Get github's username: ${user_name}."
else
    echo "Please set github's username firstly!"
    command -v open >/dev/null 2>&1 || {
        echo >&2 "FYI, https://yuzhouwan.com/posts/30041/#Git-Config"; exit 1;
    }
    open "https://yuzhouwan.com/posts/30041/#Git-Config"
    exit 1
fi

# check SSH
ssh_succ=$(ssh -T git@github.com 2>&1 | grep "successfully")

if [[ "${ssh_succ}" != "" ]]; then
    echo "You've successfully authenticated."
else
    echo "Please set SSH to github!"
    command -v open >/dev/null 2>&1 || {
        echo >&2 "FYI, https://yuzhouwan.com/posts/30041/#SSH-%E5%85%8D%E5%AF%86"; exit 1;
    }
    open "https://yuzhouwan.com/posts/30041/#SSH-%E5%85%8D%E5%AF%86"
    exit 1
fi

# build project
mkdir algorithm
cd algorithm || {
    echo >&2 "Unable to create the algorithm directory!"; exit 1;
}

git init
git remote add origin git@github.com:"${user_name}"/algorithm.git
git remote add upstream git@github.com:asdf2014/algorithm.git

git pull upstream master:master

# build commit
mkdir -p Codes/"${user_name}"
echo "${user_name}" > Codes/"${user_name}"/README.md
git add .
git commit -m "Add ${user_name}'s first commit"

# push commit
git push upstream master
