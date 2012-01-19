(defproject emezeske/closure-library "0.0.1+r1376"
  :description "Google Closure Library"
  :url "http://github.com/emezeske/closure-library"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :dev-dependencies [[fs "0.11.1"]]
  :jar-exclusions [#"closure" #"bin" #"css" #"known_issues"]  
  :resources-path "resources")

(use '[leiningen.core :only [prepend-tasks]]
     '[leiningen.pom :only [pom]]
     '[leiningen.jar :only [jar]]
     '[closure-library-build.core :only [copy-resources]])

(prepend-tasks #'pom copy-resources)
(prepend-tasks #'jar copy-resources)
