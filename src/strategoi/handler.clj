(ns strategoi.handler
  (:require [compojure.core :as cmpj]
            [compojure.handler :refer [api]]
            [ring.middleware.json :refer  [wrap-json-response]]))

(defn create-routes
  [database marathon])
