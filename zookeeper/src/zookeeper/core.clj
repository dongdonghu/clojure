;; (ns foo.bar
;;   (:refer-clojure :exclude [ancestors printf])
;;   (:require (clojure.contrib sql combinatorics))
;;   (:use (my.lib this that))
;;   (:import (java.util Date Timer Random)
;;            (java.sql Connection Statement)))
(ns com.hdd.zookeeper
  (:require [clojure.pprint :as pprint])
  (:import (org.apache.zookeeper ZooKeeper Watcher CreateMode)
                               ;(org.apache.zookeeper Watcher)
                               (org.apache.zookeeper.ZooDefs$Ids)
                               ;(org.apache.zookeeper.CreateMode)
                               (java.util Calendar)))


(def unsafe org.apache.zookeeper.ZooDefs$Ids/OPEN_ACL_UNSAFE)
(def persistent org.apache.zookeeper.CreateMode/PERSISTENT)

(def zk (ZooKeeper. "127.0.0.1:2181",60000,nil))
(.create zk "/hdd2" (.getBytes "hello hudongdong") unsafe persistent)

(defn add-if-not-exist [zk k value]
  (if (.exists zk k false)
    "exist"
    (.create zk k (.getBytes value) unsafe persistent)
  ))
(add-if-not-exist zk "/hdd4", "hdd")
(.get

