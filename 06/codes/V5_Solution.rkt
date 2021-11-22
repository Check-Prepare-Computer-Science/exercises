;; Type: (list of ANY) -> (list of ANY (list of ANY))
;; Returns: a list of the results of using the function foo on abc-structs 
(define (bar1 lst)
	(cond
		[(empty? lst) empty]
		[(abc? (first lst)) (cons (foo (first lst)) (bar1 (rest lst)))]
		[else (bar1 (rest lst))]))