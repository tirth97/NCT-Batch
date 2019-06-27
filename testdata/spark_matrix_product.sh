#!/bin/bash
USERNAME=hadoop
HOSTS="129.10.112.225"
SCRIPT="kp-BBB27; batchserver/mminspark.sh"
for HOSTNAME in ${HOSTS} ; do
    ssh -l ${USERNAME} ${HOSTNAME} "${SCRIPT}"
done
