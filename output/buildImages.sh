cd ../
mvn package
cp target/WorldCreator-1.jar ./output
cd output
sudo docker build -t worldcreator .
