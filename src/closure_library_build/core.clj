(ns closure-library-build.core
  (:use
    [leiningen.compile :only [eval-in-project]])) 

(defn copy-resources [project]
  (eval-in-project project
    `(let [~'dest ~(:resources-path project)]
      (fs/copy-tree "upstream/closure" ~'dest)
      (fs/copy-tree "upstream/third_party/closure/goog" ~'(fs/join dest "third_party/goog")))
      nil 
      nil 
      '(require 'fs)))
