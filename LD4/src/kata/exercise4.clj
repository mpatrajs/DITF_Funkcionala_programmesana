(ns kata.exercise4
  (:use [clojure.test]
        [kata.data]))

(testing "First registrant"

  ; Find the first customer
  (let [first-customer {}]

    (is (= (:name first-customer) "Joe"))))


(testing "Is there anyone older than 40?"

  ; Check whether any customer older than 40 exists or not by using (some ...)
  (let [over40 true]

    (is (nil? over40))))

(testing "Is everybody older than 20?"

  ; Check whether all customer are older than 20 or not by using (every ...)
  (let [over20 false]

    (is (true? over20))))

(testing "Everyone wants something"

  ; Confirm that none of the customer has empty :wants-to-buy by using (not-any? ...)
  (let [all-want-smth false]

    (is (true? all-want-smth))))
