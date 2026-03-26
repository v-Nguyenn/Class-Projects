# Vincent Nguyen
# CECS 325-0
# Program 4 - Sorting Contest Using Threads

# I certify that this program is part of my original work.
# This script is provided from class instructions. I further certify
# that I typed each and every line of code in this program.

#####################################################
# this file should be called sortrace.sh
# it must have execute privilege set to run
# run it as a backgroud task like this:
#           $ rm sortrace.log    # start with fresh log file
#           $ sortrace.sh >> sortrace.log & # run in the background
#####################################################
echo "======= Start ======="
whoami
date
echo My machine has this many processors
nproc # this is for Windows machines
# sysctl -n hw.Ncpu # this is for Mac machines
echo Generating 1000000 random numbers
sleep 1
./generate 1000000 -1000000 1000000 # generate.cpp that we wrote
sleep 1 
echo Starting system sort
sleep 1
{ time sort -n numbers.dat > systemsort.out; } 2>> sortrace.log # For Windows
# { time sort -n numbers.dat > systemsort.out; } 2>&1 >> sortrace.log # change for Mac
sleep 1
echo Starting my sort
sleep 1
{ time ./mysort numbers.dat mysort.out; } 2>> sortrace.log # For Windows
# { time ./mysort numbers.dat mysort.out; } 2>&1>> sortrace.log # Change for Mac
sleep 1
ls -l systemsort.out
ls -l mysort.out
echo Comparing systemsort.out to mysort.out
diff systemsort.out mysort.out 2>> sortrace.log
echo All done with diff compare
echo "======== End ========"
date