(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

(defn train
  []
  (println "Choo choo!")
  (if true
    (do (println "Success!")
        "By Zeus's hammer!")
    (do (println "Failure!")
        "By Aquaman's trident!"))
  (when true
    (println "Success!")
    "abra cadabra!"))

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk!"])

failed-protagonist-names

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOMED!")))

(defn no-params
  []
  "I take no paramters!")
(defn one-param
  [x]
  (str "I take one parameter: " x))
(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(defn weird-arity
  ([]
   "Random string")
  ([number]
   (inc number)))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(defn ann-tres-loc
  [{lat :lat lng :lng}]
  (println (str "Tres lat: " lat))
  (println (str "Tres lng: " lng)))

(defn illust-fn
  []
  (+ 1 304)
  30
  "joe")

(defn num-comment
  [x]
  (if (> x 6)
    "omg! what a big number"
    "that number's OK, I guess"))

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Maggo"])

((fn [x] (* x 5)) 8)

(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Luke" "Leia"])

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
;; fn w/ takes in part arg. where variable :name replace w/ part. replace left- with right-

(defn sym-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [rem-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? rem-asym-parts)
      final-body-parts)
    (let [[part & remaining] rem-asym-parts]
      (recur remaining
             (into final-body-parts
                   (set [part (matching-part part)])))))
