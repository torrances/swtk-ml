rf -rf moose-*/target
myfile=$(date +'%Y%m%d_SWTK-ML%s.tar.gz')
tar cvf $myfile .
mv $myfile /Volumes/NO\ NAME/
