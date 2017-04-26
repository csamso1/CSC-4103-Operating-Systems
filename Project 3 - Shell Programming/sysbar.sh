#Checks if help is requested
if [ "$1" = "help" ]; then
	echo "Print help statments here..."
#Checks number of arguments provided is equal to 2
elif [ $# -ne 2 ]; then
	echo "Invalid number of arguments, please provide 2 arguments <interval in seconds> and <number of collections>"
	echo "Use ./sysbar.sh help to access help instructions."
else
	#Saves CMD line arguments to arg1 and arg2 vars
	arg1=$1
	arg2=$2
	#Print statment for confirming argument inputs
	echo "arg1 =" $arg1
	echo "arg2 =" $arg2
fi
#iostat $arg1 $arg2
#mpstat $arg1 $arg2
#Setting up disk_usage.plot header
echo "=stacked; A; B" >> disk_usage.plot
echo "title=Disk Utilization" >> disk_usage.plot
echo "colors=yellow,red" >> disk_usage.plot
echo "xlabel=Time of data collection in HH:MM:SS" >> disk_usage.plot
echo "ylabel=Bandwith (Kb/sec)" >> disk_usage.plot
echo "=table" >> disk_usage.plot
echo "=norotate" >> disk_usage.plot
echo "yformat=%g" >> disk_usage.plot
#Setting up cpu_usage.plot header
echo "=stacked; A; B" >> cpu_usage.plot
echo "title=CPU Utilization" >> cpu_usage.plot
echo "colors=yellow,red" >> cpu_usage.plot
echo "xlabel=Time of data collection in HH:MM:SS" >> cpu_usage.plot
echo "ylabel=Percentage (%)" >> cpu_usage.plot
echo "=table" >> cpu_usage.plot
echo "=norotate" >> cpu_usage.plot
echo "yformat=%g" >> cpu_usage.plot
#For loop to run test for defined interval
for (( i=1; i<=$arg2; i++)); do
	io_results="$(iostat)"
	mp_results="$(mpstat)"
	current_time="$(date +"%T")"
	echo $current_time
	#echo "$(date +"%T")" >> disk_usage.plot
	#echo "$(date +"%T")" >> cpu_usage.plot
	echo $current_time "${io_results}" | awk '{print $3;}' >> disk_usage.plot
	echo $current_time "${mp_results}" | awk '{print $4;}' >> cpu_usage.plot
	sleep $arg1
done