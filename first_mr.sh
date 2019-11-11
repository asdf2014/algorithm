#!/usr/bin/env bash

# check username
user_name=`git config user.name`

if [[ ${user_name}_x != "_x" ]]; then
    echo "Get github's username: ${user_name}."
else
    echo "Please set github's username firstly!"
    open "https://yuzhouwan.com/posts/30041/#Git-Config"
    exit -1
fi

# check SSH
ssh_succ=`ssh -T git@github.com 2>&1 | grep "successfully" | wc -l`

if [[ $(echo "${ssh_succ}" | bc) -eq 1 ]]; then
    echo "You've successfully authenticated."
else
    echo "Please set SSH to github!"
    open "https://yuzhouwan.com/posts/30041/#SSH-%E5%85%8D%E5%AF%86"
    exit -1
fi

# build project
mkdir algorithm
cd algorithm

git init
git remote add origin git@github.com:${user_name}/algorithm.git
git remote add upstream git@github.com:asdf2014/algorithm.git

git pull upstream master:master

# build MR
git checkout -b ${user_name}_first_mr
mkdir -p Codes/${user_name}
echo ${user_name} > Codes/${user_name}/README.md

# push MR
git add .
git commit -m "Create ${user_name}'s first MR"
git push upstream master
