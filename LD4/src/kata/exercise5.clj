(ns kata.exercise5
  (:use [clojure.test]
        [kata.data]))

(testing "Names List"

  ; Create a list of customer names by using (map ...)
  (let [name-list []]

    (is (= name-list
           ["Joe", "Steven", "Patrick", "Diana", "Chris", "Kathy", "Alice", "Andrew", "Martin", "Amy"]))))


(testing "Ages Set"

  ; Create a set of customer ages by using (set ...)
  (let [ages-set []]

    (is (= 9 (count ages-set)))
    (is (= ages-set
           #{21, 22, 26, 27, 28, 32, 35, 36, 38}))))

(testing "Names in CSV"

  ; Create a csv string of customer names in brackets "[]" by using (clojure.string/join ...)
  (let [names ""]

    (is (= names "[Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy]"))))

(testing "Oldest Customer"

  ; Get the oldest customer by using combining (apply ...) and (max-key ...)
  (let [oldest-customer {}]

    (is (= oldest-customer (nth (:customers mall) 3)))))

(testing "Age Distribution"

  ; Create a map of age as key and number of customers as value using (group-by ...) and (count ...)
  (let [age-distribution {}]

    (is (= (count age-distribution) 9))
    (is (every? (fn [[k v]] (if (= k 22)
                              (= v 2)
                              (= v 1))) age-distribution))))
