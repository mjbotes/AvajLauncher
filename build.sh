find  . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
