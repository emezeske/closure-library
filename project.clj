(defproject emezeske/closure-library "r1376"
  :description "Google Closure Library"
  :url "http://github.com/emezeske/closure-library"
  :dev-dependencies [[fs "0.11.1"]]
  :jar-exclusions [#"closure" #"bin" #"css" #"known_issues"]  
  :resources-path "resources")

(use '[leiningen.core :only [prepend-tasks]]
     '[leiningen.pom :only [pom]]
     '[leiningen.jar :only [jar]]
     '[build.core :only [copy-resources]])

(prepend-tasks #'pom copy-resources)
(prepend-tasks #'jar copy-resources)
