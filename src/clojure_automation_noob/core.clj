(ns clojure-automation-noob.core
  (:gen-class))

(defn -main[]
	(println "Welcome to Chapter 3 Assignment"))

(defn exercise_2 [num]
	;Taking single numeric value 
	(print (str "Number after increment" ":" (+ num 100))))
	
(defn exercise_1 []
	(println "Delineation  and Concatenation of String")
	
	(def test_string "We are learning Clojure")
	(println (str "Welcome" "! "test_string))
	)
