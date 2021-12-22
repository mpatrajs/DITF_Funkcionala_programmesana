(defn rail-fence-cipher [action rails text]
  (case action
    "encrypt" (encrypt text rails)
    "decrypt" (decrypt text rails)
    "Unknown action."))

(defn rails-pattern [rails]
  (concat (range rails)
          (drop 1 (range (dec rails) 0 -1))))

(defn encrypt [text rails]
  (->> (clojure.string/replace text #" " "")
       (map vector (cycle (rails-pattern rails)))
       (sort-by first)
       (map second)
       (clojure.string/join)))

(defn decrypt [text rails]
  (->> (encrypt text rails)
       (map vector)
       (sort-by second)
       (map first)
       (clojure.string/join)))

(encrypt "Mihails" 2)
(decrypt "Mhisial" 2)