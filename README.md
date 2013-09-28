# clj-lenskit-hello

A Clojure translation of the lenskit-hello project, written by [Marshall Bockrath-Vandegrift](https://github.com/llasram)

As published orginally in his [gist](https://gist.github.com/llasram/6472144)

All credit/thanks for this should be directed to Marshall, all I did was put Marshall's gist into the proper [Leiningen](https://github.com/technomancy/leiningen) project structure, which Marshall had doubtlessly done himself, and added a tiny bit of usage documentation (this README), also I've bumped the [LensKit](http://lenskit.grouplens.org) version number to use the latest release. 

## Running the project

	lein run path-to-data-file user-id(s)

## Where to obtain a data file

You need to provide a valid data file in order to run the sample, one data file source is the [GroupLens Research MovieLens data sets](http://www.grouplens.org/node/12).
N.B. the usage licenses for these data downloads.

## Example output

Assuming one has downloaded the MovieLens 100K data set, and it is available in the root of the project directory as u.data, then:

	lein run u.data 99
	log4j:WARN No appenders could be found for logger (org.grouplens.lenskit.data.dao.SimpleFileRatingDAO).
	log4j:WARN Please initialize the log4j system properly.
	log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
	 	1122
 		1536
		1500
		1467
		1189
		1201
		357
		603
		318
		1449
		


