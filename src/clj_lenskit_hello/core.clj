(ns clj-lenskit-hello.core
  (:require [clojure.java.io :as io])
  (:import [org.grouplens.lenskit
            ItemRecommender ItemScorer Recommender RecommenderBuildException]
           [org.grouplens.lenskit.baseline
            BaselineScorer ItemMeanRatingItemScorer UserMeanBaseline
            UserMeanItemScorer]
           [org.grouplens.lenskit.core
            LenskitConfiguration LenskitRecommender]
           [org.grouplens.lenskit.cursors Cursors]
           [org.grouplens.lenskit.data.dao
            EventCollectionDAO EventDAO SimpleFileRatingDAO]
           [org.grouplens.lenskit.knn.item ItemItemScorer]
           [org.grouplens.lenskit.transform.normalize
            BaselineSubtractingUserVectorNormalizer UserVectorNormalizer]))

(defn run
  [delim inpath & users]
  (let [base (SimpleFileRatingDAO. (io/file inpath) delim)
        dao (EventCollectionDAO. (-> base .streamEvents Cursors/makeList))
        config (doto (LenskitConfiguration.)
                 (-> (.bind EventDAO) (.to dao))
                 (-> (.bind ItemScorer) (.to ItemItemScorer))
                 (-> (.bind BaselineScorer ItemScorer) (.to UserMeanItemScorer))
                 (-> (.bind UserMeanBaseline, ItemScorer)
                     (.to ItemMeanRatingItemScorer))
                 (-> (.bind UserVectorNormalizer)
                     (.to BaselineSubtractingUserVectorNormalizer)))
        rec (LenskitRecommender/build config)
        irec (.getItemRecommender rec)]
    (doseq [user users, item (.recommend irec user 10)]
      (->> item .getId (format "\t%d\n") print))))

(defn -main
  [& args]
  (let [[delim args] (if (= "-d" (first args))
                       [(second args) (drop 2 args)]
                       ["\t" args])
        inpath (first args)
        users (map #(Long/parseLong %) (rest args))]
    (apply run delim inpath users)))
