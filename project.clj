(defproject pwndpassword "0.1.0-SNAPSHOT"
  :description "checks if a password has been pwnd"
  :url "https://github.com/korlando7/pwndpassword"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.9.1"]]
  :plugins [[lein-cljfmt "0.6.4"]]
  :main ^:skip-aot pwndpassword.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
