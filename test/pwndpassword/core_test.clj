(ns pwndpassword.core-test
  (:require [clojure.test :refer :all]
            [pwndpassword.core :refer :all]))

(deftest test-sha-1 []
  (is (= (sha-1 "helloworld") "6ADFB183A4A2C94A2F92DAB5ADE762A47889A5A1")))

(deftest test-hash-subs []
  (is (=
       (hash-subs "helloworld")
       {:prefix "6ADFB" :suffix "183A4A2C94A2F92DAB5ADE762A47889A5A1"})))

(deftest test-find-pass []
  (let [body (str "00226133013BC78DBE0FB3FCFDDD7B71436:1\r\n
                   002674DCD6816E4D4ED92AB62F196B6F865:6\r\n
                   00C0A73F0044CBCC5B553A2AF7D254E1437:2\r\n
                   00C709040319184E59F40DCF2E115F56202:1\r\n
                   183A4A2C94A2F92DAB5ADE762A47889A5A1:14816\r\n
                   A7D18832E7D02DC7E9674A26DE79E7B9299:2\r\n
                   A80B249AE043E0D52273E9C8BDD00BC789E:1")
        body2 (str "00226133013BC78DBE0FB3FCFDDD7B71436:1\r\n
                    002674DCD6816E4D4ED92AB62F196B6F865:6\r\n
                    00C0A73F0044CBCC5B553A2AF7D254E1437:2")
        params {:body body :suffix "183A4A2C94A2F92DAB5ADE762A47889A5A1"}
        params2 {:body body2 :suffix "183A4A2C94A2F92DAB5ADE762A47889A5A1"}]
    (is (= (find-pass params) (:suffix params)))
    (is (= (find-pass params2)) nil)))
