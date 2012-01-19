(ns closure-library-build.core
  (:use
    [leiningen.compile :only [eval-in-project]]))

(defn copy-resources [project]
  (eval-in-project project
    `(let [dest# ~(:resources-path project)]
      (when (fs/exists? dest#)
        (fs/deltree dest#)
        (fs/mkdir dest#))
      (fs/copy-tree "upstream/third_party/closure/goog" dest#)
      (fs/copy-tree "upstream/closure/goog" dest#)
      (let [deps# (slurp (fs/join dest# "goog/deps.js"))
            rep# (.replaceAll deps# "\\.\\./\\.\\./third_party/closure/goog/" "")]
        (spit (fs/join dest# "goog/deps.orig") deps#)
        (spit (fs/join dest# "goog/deps.js") rep#)))
      nil
      nil
      '(require 'fs)))
