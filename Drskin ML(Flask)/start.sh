#!/bin/sh



proc=`ps -ef |grep python |grep "skin_webserver.py" |awk '{print$2}'`

if [ X"$proc" != X"" ]; then
	echo "[$proc] aleady executed.."
else
	sudo env "PATH=$PATH" nohup python skin_webserver.py   output.log 2&1
fi
