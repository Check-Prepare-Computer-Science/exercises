;; Type: number | (list of (number | (list of (number | ...)))) -> boolean
;; Returns: true, if the same number appears more than once in the list
(define (duplicates-deep? deep-lst)
  (local 
    (
     ;; Type: number | (list of (number | (list of (number | ...)))) -> (list of number)
     ;; Precondtion: oracle must be empty at the beginning
     ;; Returns: a singleton list from a nested list
     (define (collect lst oracle)
       (cond
         [(empty? lst) oracle]
         [(list? lst) (collect (rest lst) (append oracle (collect (first lst) empty)))]
         [else (list lst)]))
     )
    (duplicates? (collect deep-lst empty))))

;; Tests
(check-expect (duplicates-deep?
               (list (list 1 2 3 4 5) (list (list 6 7 8 (list 0 2))))) #true)
(check-expect (duplicates-deep?
               (list (list 1 2 3 4 5) (list (list 6 7 8 (list 0 (list 22)))))) #false)
(check-expect (duplicates-deep?(list (list 1 2 3 4 5) (list (list 6 7 8 (list 0 (list 22))
               list 99 (list (list 11 958 32 (list 3212) (list 2313))))))) #false)