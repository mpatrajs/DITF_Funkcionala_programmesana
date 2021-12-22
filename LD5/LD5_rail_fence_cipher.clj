(defn rail_fence_cipher [type key text]
  (let [counter (* 2 (dec key))
        groups (map
                 (fn [index]
                   (take-nth
                     counter
                     (drop index (range))))
                 (range counter))
        encrypt-text
        (take
          (count text)
          (loop [x (rest groups)
                 encrypt-text (take-while
                              #(> (count text) %)
                              (first groups))]
            (if
              (= 1 (count x))
              (concat encrypt-text (last x))
              (recur
                (rest (drop-last x))
                (concat
                  encrypt-text
                  (take-while
                    #(> (count text) %)
                    (interleave (first x) (last x))))))))
        decrypt-text (->> encrypt-text
                         (map-indexed vector)
                         (sort-by second)
                         (map first))]
    (cond
      (= type "encrypt")
      (apply str
             (map #(nth text %) encrypt-text))
      (= type "decrypt")
      (apply str
             (map #(nth text %) decrypt-text))
      :else
      "Please enter a valid cipher mode.")))

(rail_fence_cipher "encrypt" 2 "Mihails")
(rail_fence_cipher "decrypt" 2 "Mhisial")