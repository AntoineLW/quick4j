#!/usr/bin/env bash
#根据thrift定义，生成java model,添加的时候在后面自己添加,不要删除别人的
rm -rf gen-java
thrift --gen java school.thrift

cp -rf gen-java/* ../src/main/java/
rm -rf gen-java
