# Vincent Nguyen
# CECS 325-0
# Program 3 - Sorting Contest

# This script is provided from class instructions

# This file is called sortrace.sh
# It must have execute privilege set to run
# run it as a background task like this: (see the 2 lines below)
#----------------------------------------------------------------------------------------------
$ rm sortrace.log # start with fresh log file
$ sortrace.sh >> sortrace.log & # this may take an hour
#----------------------------------------------------------------------------------------------
#
echo Generating 1000000 random numbers
sleep 1                                # Pauses the script for 1 second
./generate 1000000 -100000 100000      # generate.cpp from what I wrote
sleep 1
echo Starting system sort
sleep 1
# Using this line for Windows
{time sort -n numbers.dat > systemsort.out;} 2>> sortrace.log 
# This is for Mac, but I switch between systems so leaving this here to change 
# {time sort -n numbers.dat > systemsort.out;} 2>&1>> sortrace.log
sleep 1
echo Starting mysort
sleep 1
# Using this line for Windows 
{time ./mysort numbers.dat mysort.out; } 2>> sortrace.log
# This is for Mac
# {time ./mysort numbers.dat sort.out; } 2>&1 sortrace.log 
sleep 1
wc mysort.out                          # wc is word cout 
sort -c -n mysort.out 2>> sortrace.log # verify file is sorted