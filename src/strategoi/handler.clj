(ns strategoi.handler
  (:require [compojure.core :as cmpj :refer [routes context GET POST PATCH DELETE]]
            [compojure.handler :refer [api]]
            [ring.middleware.json :refer  [wrap-json-response]]))

(defn- wrap-user
  [handler]
  (fn [req]))

(defn- wrap-application
  [handler]
  (fn [req]) )

(defn- wrap-version
  [handler]
  (fn [req]))

(defn- wrap-auth
  [handler]
  (fn [req]))

(defn- wrap-media
  [handler]
  (fn [req]))

(defn create-routes
  [database marathon]
  (let [handler (routes
                  (context "/users" []
                           (GET "" [] (list-users database))
                           (context "/:id" [id]
                                    (wrap-user
                                      (GET "" [user] (show-user database user))
                                      (PATCH "" [user :as req] (update-user database user (:body req)))
                                      (DELETE "" [user] (delete-user database user)))))
                  (context "/applications" []
                           (GET "" [] (list-apps database))
                           (POST "" [] (create-app database))
                           (context "/:id" [id]
                                    (wrap-app
                                      (GET "" [app] (show-app database app))
                                      (PATCH "" [app :as req] (update-app database app (:body req)))
                                      (DELETE "" [app] (delete-app database app)))))
                  (context "/versions" []
                           (GET "" [] (list-versions database))
                           (POST "" {:body body} (create-version database app))
                           (context"/:id" [id]
                                          (wrap-version
                                            (GET "" [version] (show-version database version))
                                            (PATCH "" [version :as req] (update-version database version (:body req)))
                                            (DELETE "" [version] (delete-version version))))))]
    (-> (api handler)
        wrap-json-response
        wrap-media
        wrap-auth)))
