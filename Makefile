
out_dir = compile

documentation:
	javadoc -d docs/ WHOPAYS.Domain WHOPAYS.Persistence WHOPAYS
	git add docs/*
	git commit -m "update JAVADOC"
	git push

compile_project:
	javac -d $(out_dir)/ WHOPAYS/Domain/*.java
	javac -d $(out_dir)/ WHOPAYS/Persistence/*.java
	javac -d $(out_dir)/ WHOPAYS/*.java

run_main:
	cd class_files
	java WHOPAYS.Main

#jar: compile_project
#jar cvfm WHOPAYS.jar MANIFEST.MF $(out_dir)/*
#

