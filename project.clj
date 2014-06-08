(defproject strategoi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [compojure "1.1.5"]
                 [ring/ring-json "0.3.1"]
                 [http-kit "2.1.16"]
                 [clj-http "0.9.1"]
                 [clj-time "0.6.0"]
                 [pg-json "0.2.1"]
                 [korma "0.3.2"]
                 [ragtime "0.3.7"]
                 [com.stuartsierra/component "0.2.1"]
                 [org.clojure/java.jdbc "0.3.3"]
                 [postgresql/postgresql "9.3-1101.jdbc4"]]
  :profiles {:dev {:plugins [[ragtime/ragtime.lein "0.3.7"]]}})
