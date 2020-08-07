project_path=$(pwd)
echo $project_path

ids=$(java -jar translate-check.jar $project_path)

if [[ ${ids} == 0 ]]; then
	echo "success"
else
	for e in ${ids}; do
		echo ${e}
	done
fi