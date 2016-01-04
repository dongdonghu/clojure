(ns clojure-study.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def a '( :a "a" :b 2))
(print a)
(defn make-cd [name price author]
  {:name name :price price :author author})
(def db ())
(defn add-cd [cd]
  (cons cd db)
  db)
(def db (add-cd (make-cd "vol1" 12 "hdd")))

(defn select [db seffn]
  (filter seffn db ))

(select db #(= (:author %) "hdd"))

(defn make-fns [{:keys [name price author]}]
  (fn [cd]
    (and
     (if name (= (:name cd) name) true)
     (if price (= (:price cd) price) true)
     (if author (= (:author cd) author) true))))

(select  db (make-fns {:author "hdd" :name "vol1"}))

(defun make-clauses [clauses]
  (let pairs (partition ))
  [])
(defmacro [&clauses]
  `(fn [cd] (and ,@(make-clauses clauses)))
