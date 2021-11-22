;; Type: (list of ANY) -> (list of ANY (list of ANY))
;; Returns: a list of the results of using the function foo on abc-structs
(define (bar2 lst)
  (map
   (lambda (p)
     (if (and (abc? p) (list? (abc-b p)))(list (abc-a p) (abc-b p)) false))
   (filter abc? lst)))