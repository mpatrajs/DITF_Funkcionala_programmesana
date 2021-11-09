;; 1. Find the last element of a list.

(defn my-last [xs]
  (first (reverse xs)))

(my-last [1 2 3 4])

(assert (= :d
           (my-last '(:a :b :c :d))))

;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
  (last (take (inc n) xs)))

(get-nth [1 2 3 4] 2)

(assert (= :c
           (get-nth '(:a :b :c :d) 2)))

;; 3. Find the length of a list
(defn my-length [xs]
  (count xs))

(my-length [1 2 3 4 5 6 7])

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
(defn my-reverse [xs]
  (into '() xs))

(my-reverse [1 2 3 4])

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.
(defn is-palindrome? [xs]
  (if (string? xs) (= xs (apply str (reverse xs)))
                    (= xs (reverse xs))))

(assert (= true
           (is-palindrome? '(:a :b :c :b :a))))

;; 6. Duplicate the elements of a list.
(defn duplicate [xs]
  (sort (take (* 2 (count xs)) (cycle xs))))

(duplicate [1 5 3 9])

(assert (= '(:a :a :b :b :c :c)
           (duplicate '(:a :b :c))))

;; 7. Eliminate consecutive duplicates of a list.
(defn compress [xs]
  (distinct xs))

(compress [1 2 1 3 4 3])

(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
  (keep-indexed #(if (not= %1 n) %2) xs))

(remove-at [1 2 3 4] 2)

(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list. ????????
(defn insert-at [x xs n]
  (let [[before after] (my-drop xs (dec n))]
    (if (empty? after)
      (if (= (count before) (dec n))
        (concat before (replicate 1 x))
        before)
      (concat before (conj after x)))))

(insert-at 9 [1 2 3 4] 4)

(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
  (into [] (range a (inc b))))

(my-range 1 7)

(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
  (distinct (concat xs ys)))

(my-concat [9 8 7 6 5] [1 2 3 4])

(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
  (reduce #(if (< (count (first %1)) n)
             (list (concat (first %1) [%2]) '())
             (list (first %1) (concat (last %1) [%2])))
          '(() ()) xs))

(my-drop [1 2 3 4] 2)

(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
  (reduce #(if (< (count (first %1)) n)
             (list (concat (first %1) [%2]) '())
             (list (first %1) (concat (last %1) [%2])))
          '(() ()) xs))

(my-take [1 2 3 4] 2)

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
(defn my-filter [p xs]
  (if-not (empty? xs)
    (if (p (first xs))
      (cons (first xs) (my-filter p (rest xs)))
      (my-filter p (rest xs)))))

(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [f xs]
  ((let [firsElement (first xs)]
     (if firsElement
       (do
         (f firsElement)
         (my-map f (rest xs)))))))

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  (reduce f acc xs))

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
(defn my-flatten [xs]
  (let [[a & b] xs]
    (cond
      (empty? xs) '()
      (coll? a) (concat (my-flatten a) (my-flatten b))
      :else (cons a (my-flatten b)))))

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))