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
	echo "arg1 = " $arg1
	echo "arg2 = " $arg2
fi
echo "iostat results: "
iostat $arg1 $arg2
echo "mpstat results: "
mpstat $arg1 $arg2