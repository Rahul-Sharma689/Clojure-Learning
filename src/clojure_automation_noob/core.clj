(ns clojure-automation-noob.core
  (:gen-class))
(def filename "suspects.csv")

(defn -main[]
	(println "Welcome to Chapter 3 Assignment"))

(defn exercise_2 [num]
	;Taking single numeric value 
	(print (str "Number after increment" ":" (+ num 100))))
	
(defn exercise_1 []
	(println "Delineation  and Concatenation of String")
	
	(def test_string "We are learning Clojure")
	(println (str "Welcome" "! "test_string))
	
	(println "--- map practice ---")

	(def Candidate {:Name "Jhon" :Address {:City "NewYork" :Country "USA"} :Exp 5 :Profile "SDET"})

	(println "----Looking up values in maps with the get function---")
	(println "Candidate Name:"(get Candidate :Name ))
	(println "Total Number of Experience:"(get Candidate :Exp ))

	(println "---Looking up nested values in maps using get-in---")
	(println "Candidate City:"(get-in Candidate [:Address :City] ))
	(println "Candidate Country:"(get-in Candidate [:Address :Country]))

	(println "---Treating the map like a function with the key as its argument--")
	(println "Candidate Profile:"(Candidate :Profile ))

	(println "--- Vector practice ---")
	(def basket [1 "Mango" 12.45])
	(println "Get Mango out of basket:"(get basket 1 ))
	(println "Add orange into basket:"(conj basket "Orange" ))

	(println "--- List practice ---")
	(println "Second element of list:" (nth '(:a :b :c) 1))
	(println "Adding new element in List:" (conj '(1.2 7 3) 15))

	(println "--- Set practice ---")
	(println "Hash set values:" #{"Apple" 21 :CLJ})
	(println "Converting Vector into Hash:" (set [1 2 1 3 4 3]))
	(println "Asserting value Apple contains in Hash:" (contains? #{:Apple :Orange} :Apple)))

	(defn dec-maker  
	"Create a custom decrementor" 
	(println "--- Customize Decrementor  Exercise 3---")
	[dec-by]
	#(- % dec-by))
	
(def vamp-keys [:name :glitter-index])
 (defn str->int
	[str]
	(Integer. str))

(def conversions {:name identity
	:glitter-index str->int})

 (defn convert
	[vamp-key value]
	((get conversions vamp-key) value))

(defn parse
	"Convert a CSV into rows of columns"
	[string]
	(map #(clojure.string/split % #",")
	(clojure.string/split string #"\n")))

(defn mapify
	"Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
	[rows]
	(map (fn [unmapped-row]
	(reduce (fn [row-map [vamp-key value]]
	(assoc row-map vamp-key (convert vamp-key value)))
	{}
	(map vector vamp-keys unmapped-row)))
	rows))

(defn glitter-filter
	[minimum-glitter records]
	(filter #(>= (:glitter-index %) minimum-glitter) records))

; Exercise -1 (Turn the result of your glitter filter into a list oxf names.)
(defn turning-glitter-into-name [minimum-glitter records]
     	 (map :name (filter #(>= (:glitter-index %) minimum-glitter) records)))
		 
;Exercise -2 Write a function, append, which will append a new suspect to your list of suspect
		 (defn append-suspect
         [name glitter-value]
         (conj (mapify (parse (slurp filename))) {:name name :glitter-index glitter-value}))
		 
; Exercise -3 (validated :name and :glitter-index.)	
(defn validate-values
	[name glitter-index]
	(if (and (empty? name) (not(empty? value)))
	 (println "validated :name and :glitter-index")))	 

;exercise - 4 Write a function that will take your list of maps and convert it back to a
(clojure.string/join "," (vals glitter-filter))