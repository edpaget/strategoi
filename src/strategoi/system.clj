(ns strategoi.system
  (:require [com.stuartsierra.component :as component]
            [strategoi.components.database :refer [new-database]]
            [strategoi.components.app :refer [new-app]]
            [strategoi.handler :refer [create-routes]]))

(defn system
  "Returns a new instance of the whole application"
  [{:keys [port jdbc]
    :or {port 8080}}]
  (component/system-map
    :db (new-database jdbc)
    :app (component/using
           (new-app port create-routes)
           [:db])))


