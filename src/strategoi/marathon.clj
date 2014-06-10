(ns strategoi.marathon
  (:require [clj-http.client :as c]))

(defn- app)

(defn- app-cmd
  [app cmd]
  (assoc app :cmd cmd))

(defn- app-tag
  [app tag])

(defn- app-image
  [app image])

(defn- new-app
  []
  {:
   })

(defn build-app
  [image tag command healthcheck cpus memory instances]
  (-> (new-app)
      (app-image image)
      (app-tag tag)
      (app-cmd command)
      (app-healthcheck healthcheck)
      (app-resources cpus memory)
      (app-instances instances)))
