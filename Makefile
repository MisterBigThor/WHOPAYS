

documentation:
	javadoc -d docs/ WHOPAYS.Domain WHOPAYS.Persistence WHOPAYS
	git add docs/*
	git commit -m "update JAVADOC"
	git push
