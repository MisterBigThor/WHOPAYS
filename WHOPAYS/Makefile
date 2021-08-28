
out_dir = classFiles

documentation:
	javadoc -d JAVADOC/ Domain Persistence ConsoleInterface inout.java LOG.java Main.java
	git add JAVADOC/*
	git commit -m "update JAVADOC"
	#git push

run_main:
	cd class_files
	java WHOPAYS.Main

#jar: compile_project
#jar cvfm WHOPAYS.jar MANIFEST.MF $(out_dir)/*
#

