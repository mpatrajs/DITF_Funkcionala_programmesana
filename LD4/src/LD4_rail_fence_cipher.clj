(defn rail_fence_cipher [type key text]
  (let [group-count (* 2 (dec key))
        groups (map
                 (fn [first-idx]
                   (take-nth
                     group-count
                     (drop first-idx (range))))
                 (range group-count))
        cipher-map
        (take
          (count text)
          (loop [x (rest groups)
                 cipher-map (take-while
                              #(> (count text) %)
                              (first groups))]
            (if
              (= 1 (count x))
              (concat cipher-map (last x))
              (recur
                (rest (drop-last x))
                (concat
                  cipher-map
                  (take-while
                    #(> (count text) %)
                    (interleave (first x) (last x))))))))
        inverse-map (->> cipher-map
                         (map-indexed vector)
                         (sort-by second)
                         (map first))]
    (cond
      (= type "encrypt")
      (apply str
             (map #(nth text %) cipher-map))
      (= type "decrypt")
      (apply str
             (map #(nth text %) inverse-map))
      :else
      "Please enter a valid cipher mode.")))

(rail_fence_cipher "encrypt" 2 "Mihails")
(rail_fence_cipher "decrypt" 2 "Mhisial")