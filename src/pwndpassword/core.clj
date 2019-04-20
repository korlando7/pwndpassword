(ns pwndpassword.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def base-url "https://api.pwnedpasswords.com")

(defn sha-1 [strng]
  (apply str
         (map (partial format "%X")
              (.digest (doto (java.security.MessageDigest/getInstance "SHA-1")
                         .reset
                         (.update (.getBytes strng)))))))

(defn hash-subs [pass]
  (let [hash (sha-1 pass)]
    {:prefix (subs hash 0 5)
     :suffix (subs hash 5)}))

(defn get-search-result [{:keys [prefix suffix]}]
  (let [url (str base-url "/range/" prefix)]
    {:body (:body (client/get url {:accept :json}))
     :suffix suffix}))

(defn find-pass [{:keys [suffix body]}]
  (-> suffix
      re-pattern
      (re-find body)))

(defn pwnd? [pass]
  (-> pass
      hash-subs
      get-search-result
      find-pass
      some?))

(defn -main [& args])
