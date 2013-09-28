(defproject clj-lenskit-hello "0.1.0-SNAPSHOT"
  :description "Clojure version of the GroupLens lenskit-hello demo. 
Original Java project URL: https://bitbucket.org/grouplens/lenskit-hello
This is the work of Marshall Bockrath-Vandegrift, https://github.com/llasram"
  :url "https://gist.github.com/llasram/6472144"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ^:skip-aot clj-lenskit-hello.core
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.grouplens.lenskit/lenskit-knn "2.0.2"]
                 [org.slf4j/slf4j-api "1.7.5"]
                 [org.slf4j/slf4j-log4j12 "1.7.5"]
                 [log4j "1.2.17"]])
