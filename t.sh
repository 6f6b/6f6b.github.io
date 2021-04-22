files=$(ls)
main=index.html
cat /dev/null > $main
echo '<!DOCTYPE html><html lang="zh-CN"><head><meta charset="UTF-8"><title>产品组各类原型图</title></head><body><center><h1>产品组各类原型图</h1><ul>' > $main
for i in $files; do
  if [ $i != 'index.html' ] && [ $i != 'getindex.sh' ] && [ $i != 'main.html' ]; then
    echo '<li><a href="'$i'">'$i'</a></li>' >> $main
  fi
done
echo '</ul></center></body></html>' >> $main
echo '首页文件生成完毕'